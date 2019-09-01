package com.hmn.ym.utils;

import com.hmn.ym.utils.des.DesEncrypt;
import com.hmn.ym.utils.des.MD5Utils;

public class PasswordUtils {
    private static final DesEncrypt desEncrpt = new DesEncrypt(Const.DES_PUBLIC_ENCRYPT_KEY);
    private static final DesEncrypt aesEncrypt = new DesEncrypt(Const.DES_PRIVATE_ENCRYPT_KEY);


    public static String getPassword(String password) {
        return MD5Utils.stringToMD5(aesEncrypt.encrypt(desEncrpt.decrypt(password)));
    }

    public static String getInitPassword() {
        return MD5Utils.stringToMD5(aesEncrypt.encrypt("123456"));
    }
}
