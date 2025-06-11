<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登录页面</title>
    <link rel="stylesheet" type="text/css" href="/static/css/login.css">

</head>
<body>
    <div class="login-container">
        <div class="left">
            <img src="/static/img/logo.png" alt="Centered Image">
        </div>
        <div class="right">
            <h2>建筑外立面裂缝检测系统</h2>
                <form action="/modifyfunc" method="post">
                    <input type="text" name="username" placeholder="用户名" required>
                    <input type="password" name="password" placeholder="密码" required>
                    <input type="text" name="email" placeholder="邮箱" required>
                    <button type="submit">修改</button>
                </form>
                <div class="error-message" id="error-message"></div>
        </div>
    </div>
</body>

</html>