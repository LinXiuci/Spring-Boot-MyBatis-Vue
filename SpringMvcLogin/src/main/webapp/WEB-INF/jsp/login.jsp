<%--
  Created by IntelliJ IDEA.
  User: XieWenqi
  Date: 2021/6/12
  Time: 3:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登陆页面</title>
    <link rel="stylesheet" href="./css/login.css">
</head>
<body  class="body">
    <section>
        <form method="POST" action="${pageContext.request.contextPath}/login" class="login-form">
            <h1 class="login-title">账号登录</h1>
            <table class="login-form-table">
                <tr>
                    <td><input type="text" name="username" id="login-user" placeholder="输入手机号码或邮箱"></td>
                </tr>
                <tr>
                    <td><input type="password" name="password" id="login-password" placeholder="请输入密码"></td>
                </tr>
                <tr>
                    <td>
                        <p class="login-code-hide">
                            <a href="">忘记密码?</a>
                            <span>${msg}</span>
                        </p>
                    </td>
                </tr>
                <tr>
                    <td>
                        <button id="login-submit">登录</button>
                    </td>
                </tr>
                <tr>
                    <td>
                        <p class="login-code-register"><a href="">隐私政策</a><a href="">注册帐号</a></p>
                    </td>
                </tr>
            </table>
        </form>
    </section>
</body>

</html>
