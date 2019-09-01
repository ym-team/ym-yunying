package com.hmn.ym.utils;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SendSmsUtils {

    private static final String REGEX = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
    private static final String[] NUMBERS = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private static Pattern P = Pattern.compile(REGEX);
    private static Random RANDOM = new Random();

    public static boolean sendSms(String phone, String code) {
        boolean bln = true;
        if (!checkPhone(phone)) {
            bln = false;
            return bln;
        }
        /**
         * 是否开启短信发送模式
         */
        if (CfgParaUtils.SEND_CODE_VALUE.equals(CachCfgParaUtil.getCfgCache(
                CfgParaUtils.SEND_CODE))) {
            sendSmsAliy(phone, code);
        }

        return bln;
    }


    private static void sendSmsAliy(String phone, String code) {
        String SignName = CachCfgParaUtil.getCfgCache(CfgParaUtils.SIGN_NAME);
        String TemplateCode = CachCfgParaUtil.getCfgCache(CfgParaUtils.TEMPLATE_CODE);
        String accessKeyId = CachCfgParaUtil.getCfgCache(CfgParaUtils.ACCESS_KEY_ID);//"LTAIk8xzqJlt2WQD"
        String accessSecret = CachCfgParaUtil.getCfgCache(CfgParaUtils.ACCESS_SECRET);//"pSty99crj3Ui1NznhdNtNY3lmcnH2X"
        String version = CachCfgParaUtil.getCfgCache(CfgParaUtils.VERSION);
        DefaultProfile profile = DefaultProfile.getProfile("", accessKeyId, accessSecret);
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion(version);
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "default");
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", SignName);
        request.putQueryParameter("TemplateCode", TemplateCode);//"SMS_171358456"
        Map<String, String> map = new HashMap<>(2);
        map.put("code", code);
        map.put("PhoneNumbers", phone);
        request.putQueryParameter("TemplateParam", JSONObject.toJSONString(map));
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(JSONObject.toJSON(response.getData()));
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }


    /**
     * 校验手机号
     *
     * @param phone
     * @return
     */
    public static boolean checkPhone(String phone) {
        if (phone == null || phone.length() != 11) {
            return Boolean.FALSE;
        }

        Matcher m = P.matcher(phone);
        return m.matches();
    }


    /**
     * 生成n位随机数值字符串
     *
     * @param n
     * @return
     */
    public static String randomCode(int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append(NUMBERS[RANDOM.nextInt(NUMBERS.length)]);
        }
        return builder.toString();
    }


    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>(2);
        map.put("code", "123123");
        map.put("phone", "18028081307");
        System.out.println(JSONObject.toJSONString(map));
//		 
        DefaultProfile profile = DefaultProfile.getProfile("", "LTAIk8xzqJlt2WQD", "pSty99crj3Ui1NznhdNtNY3lmcnH2X");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "default");
        request.putQueryParameter("PhoneNumbers", "18028081307");
        request.putQueryParameter("SignName", "画眉鸟");
        request.putQueryParameter("TemplateCode", "SMS_171358456");

        request.putQueryParameter("TemplateParam", JSONObject.toJSONString(map));
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(JSONObject.toJSON(response.getData()));
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }


}
