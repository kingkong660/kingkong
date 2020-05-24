<html class="x-admin-sm">
<%
//程序名称：login.jsp
//程序功能：黑名单
//创建日期：2020年5月22日23:28:47
//创建人    ：谭金刚 
//更新记录： 更新人    更新日期     更新原因/内容
%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"  contentType="text/html; charset=utf-8"%> 

<head>
	<meta charset="UTF-8">
	<title>登录</title>
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="stylesheet" href="../css/font.css" type=text/css>
    <link rel="stylesheet" href="../css/login.css" type=text/css>
	<link rel="stylesheet" href="../css/xadmin.css" type=text/css>
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="../lib/layui/layui.js" charset="utf-8"></script>
    <script src="../js/login.js"></script>
    <!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body class="login-bg">
    
    <div class="login layui-anim layui-anim-up">
        <div class="message">admin1.0-管理登录</div>
        <div id="darkbannerwrap"></div>
        
        <form method="post" class="layui-form" >
            <input name="username" placeholder="用户名"  type="text" lay-verify="required" class="layui-input" >
            <hr class="hr15">
            <input name="password" lay-verify="required" placeholder="密码"  type="password" class="layui-input">
            <hr class="hr15">
            <input value="登录"  style="width:100%;" type="submit" onclick="passwordLogin()">
            <hr class="hr20" >
        </form>
    </div>

</body>
</html>