function trim(str) { // 删除左右两端的空格
	return str.replace(/(^\s*)|(\s*$)/g, "");
}
//密码登录
function passwordLogin(){
	//获取页面数据
	var userName=trim($("form input[name=username]").val());
	var userPassword=trim($("form input[name=password]").val());
	if(userName==""){
		$("form table tr:eq(0) td span").html("用户名不能为空");
		alert("用户名不能为空");
		return false;
	}
	if(userPassword==""){
		$("form table tr:eq(1) td span").html("密码不能为空");
		alert("密码不能为空");
		return false;
	}
	//发送异步请求
	$.ajax({
		cache: false,
		async: false,
		url:"/user/login_password",
		type:"get",
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		data:{"userName":userName,"password":userPassword},
		dataType:"json",
		success:function(result){
			//result.status是服务端返回的数据
			if(result.status==200){
				alert("登陆成功!");
				window.event.returnValue=false;
				window.location.href=result.data;
				
			}else if(result.status==201){
				alert(result.message);
			}
		},
		error:function(){
			alert("请求失败!");
		}
	});
	
	return false;
}
