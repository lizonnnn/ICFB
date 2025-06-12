<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>用户注册</title>
    <style>
        .error { color: red; }
    </style>
</head>
<body>
    <div class="register-container">
        <h2>用户注册</h2>
        <form action="/registerfunc" method="post">
            <div>
                <label>用户名：</label>
                <input type="text" name="username" required
                       onblur="checkUsername(this.value)">
                <span id="usernameTip"></span>
            </div>
            <div>
                <label>密码：</label>
                <input type="password" name="password" required>
            </div>
            <div>
                <label>邮箱：</label>
                <input type="email" name="email">
            </div>
            <button type="submit">注册</button>
            <div class="error">${error!}</div>
        </form>
    </div>

</body>
</html>