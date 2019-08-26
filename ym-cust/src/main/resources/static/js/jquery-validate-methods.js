$(function() {

	jQuery.validator.addMethod("isWebPassword", function(value, element) {
		var passwordPattern = /^[\@A-Za-z0-9]{6,16}$/;
		return this.optional(element) || passwordPattern.test(value);
	}, "密码格式不正确，请输入6-16个英文字母、数字组合");

	
	jQuery.validator.addMethod("isWebPhone", function(value, element) {
		//var phonePattern = /(^(([0\+]\d{2,3}-)?(0\d{2,3})-)(\d{7,8})(-(\d{3,}))?$)|(^(([0\+]\d{2,3})?(0\d{2,3}))(\d{7,8})((\d{3,}))?$)|(^0{0,1}1[3|4|5|6|7|8|9][0-9]{9}$)/;
		var phonePattern = /(13\d|14[57]|15[^4,\D]|17[678]|18\d)\d{8}|170[059]\d{7}/;
		return this.optional(element) || phonePattern.test(value);
	}, "手机号格式不正确");
	
	jQuery.validator.addMethod("isWebCardNumber", function(value, element) {
		var cardNumberPattern = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
		return this.optional(element) || cardNumberPattern.test(value);
	}, "身份证号码格式不正确");
	
	jQuery.validator.addMethod("isMoney", function(value, element) {
		var cardNumberPattern = /^(!0|[1-9][0-9]*)$/;
		return this.optional(element) || cardNumberPattern.test(value);
	}, "输入金额错误！");
	
	jQuery.validator.addMethod("isUsableCapAcntNo", function(value, element) {
		var capAcntNoHeadPattern = /^(?!621700|622707|421349|434061|434062|622609|512425|468203|410062|524011|622908|622909|966666|623058)/;
		return this.optional(element) || capAcntNoHeadPattern.test(value);
	}, "该卡富友目前不支持交易！");
});