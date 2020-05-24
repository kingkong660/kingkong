function trim(str) { // 删除左右两端的空格
	return str.replace(/(^\s*)|(\s*$)/g, "");
}
// 密码登录
function passwordLogin() {
	// 获取页面数据
	var userName = trim($("form input[name=username]").val());
	var userPassword = trim($("form input[name=password]").val());
	if (userName == "") {
		$("form table tr:eq(0) td span").html("用户名不能为空");
		alert("用户名不能为空");
		return false;
	}
	if (userPassword == "") {
		$("form table tr:eq(1) td span").html("密码不能为空");
		alert("密码不能为空");
		return false;
	}
	// 发送异步请求
	$.ajax({
		cache : false,
		async : false,
		url : "/user/passwordLogin",
		type : "get",
		data : { "userName" : userName, "userPassword" : userPassword },
		dataType : "json",
		contentType : "utf-8",
		success : function(result) {
			// result.status是服务端返回的数据
			if (result.status==200) {
				
				window.location.href="/";

				if (autologin) {
					if (getCookie("autoLogin") == "") {
						var value = userName + ":" + userPassword;
						setCookie("autoLogin", value);
					}
				} else {
					delCookie("autoLogin");
				}
				if (remember) {
					if (getCookie("loginName") == "") {
						addCookie("loginName", userName, 5);
					}
				} else {
					delCookie("loginName");
				}
			} else if (result.status == 0) {
				alert(result.message);
			}
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(errorThrown);
			alert("请求失败!");
		}
	});

	return false;
}

