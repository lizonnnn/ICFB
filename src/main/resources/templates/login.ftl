<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>系统登录</title>
    <!-- 使用CSS样式美化登录页面 -->
    <style>
        /* 全局样式重置 */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Arial', sans-serif;
        }
        
        /* 页面背景样式 */
        body {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            background-size: cover;
            background-attachment: fixed;
        }
        
        /* 登录框容器样式 */
        .login-container {
            width: 100%;
            max-width: 400px;
            padding: 40px;
            background-color: rgba(255, 255, 255, 0.9);
            border-radius: 10px;
            box-shadow: 0 15px 30px rgba(0, 0, 0, 0.2);
            transition: all 0.3s ease;
        }
        
        /* 鼠标悬停时登录框效果 */
        .login-container:hover {
            box-shadow: 0 20px 40px rgba(0, 0, 0, 0.3);
            transform: translateY(-5px);
        }
        
        /* 标题样式 */
        .login-title {
            text-align: center;
            margin-bottom: 30px;
            color: #333;
            font-size: 28px;
            font-weight: 600;
        }
        
        /* 输入框组样式 */
        .input-group {
            margin-bottom: 20px;
            position: relative;
        }
        
        /* 输入框标签样式 */
        .input-group label {
            display: block;
            margin-bottom: 8px;
            color: #555;
            font-size: 14px;
            font-weight: 500;
        }
        
        /* 输入框样式 */
        .input-group input, 
        .input-group select {
            width: 100%;
            padding: 12px 15px;
            border: 1px solid #ddd;
            border-radius: 5px;
            font-size: 16px;
            transition: all 0.3s;
            background-color: #f9f9f9;
        }
        
        /* 输入框聚焦效果 */
        .input-group input:focus, 
        .input-group select:focus {
            border-color: #667eea;
            box-shadow: 0 0 0 3px rgba(102, 126, 234, 0.2);
            outline: none;
            background-color: #fff;
        }
        
        /* 密码输入框额外样式 */
        .input-group input[type="password"] {
            letter-spacing: 1px;
        }

        
        .remember-me input {
            margin-right: 10px;
        }
        
        /* 登录按钮样式 */
        .login-btn {
            width: 100%;
            padding: 12px;
            background: linear-gradient(to right, #667eea, #764ba2);
            border: none;
            border-radius: 5px;
            color: white;
            font-size: 16px;
            font-weight: 600;
            cursor: pointer;
            transition: all 0.3s;
        }
        
        /* 登录按钮悬停效果 */
        .login-btn:hover {
            background: linear-gradient(to right, #5a6fd1, #6a4295);
            box-shadow: 0 5px 15px rgba(102, 126, 234, 0.4);
        }
        
        /* 底部链接样式 */
        .bottom-links {
            display: flex;
            justify-content: space-between;
            margin-top: 20px;
            font-size: 14px;
        }
        
        .bottom-links a {
            color: #667eea;
            text-decoration: none;
            transition: color 0.3s;
        }
        
        .bottom-links a:hover {
            color: #764ba2;
            text-decoration: underline;
        }
        
        /* 响应式设计 - 在小屏幕上调整样式 */
        @media (max-width: 480px) {
            .login-container {
                padding: 30px 20px;
                margin: 0 15px;
            }
            
            .login-title {
                font-size: 24px;
                margin-bottom: 20px;
            }
        }
    </style>
</head>
<body>
    <!-- 登录表单容器 -->
    <div class="login-container">
        <!-- 登录标题 -->
        <h1 class="login-title">系统登录</h1>
        
        <!-- 登录表单 -->
        <form action="/loginfunc" method="POST">
            <!-- 用户名输入组 -->
            <div class="input-group">
                <label for="username">用户名</label>
                <input 
                    type="text" 
                    id="username" 
                    name="username" 
                    placeholder="请输入用户名" 
                    required
                    autocomplete="username"
                >
            </div>
            
            <!-- 密码输入组 -->
            <div class="input-group">
                <label for="password">密码</label>
                <input 
                    type="password" 
                    id="password" 
                    name="password" 
                    placeholder="请输入密码" 
                    required
                    autocomplete="current-password"
                >
            </div>
            
            <!-- 用户身份选择组 -->
<!--            <div class="input-group">-->
<!--                <label for="user-role">用户身份</label>-->
<!--                <select id="user-role" name="role" required>-->
<!--                    <option value="" disabled selected>请选择您的身份</option>-->
<!--                    <option value="user">普通用户</option>-->
<!--                    <option value="admin">管理员</option>-->
<!--                    <option value="developer">开发人员</option>-->
<!--                </select>-->
<!--            </div>-->
            
            
            <!-- 登录按钮 -->
            <button type="submit" class="login-btn">登 录</button>
            
            <!-- 底部链接 -->
            <div class="bottom-links">
                <!-- <a href="/forgot-password">忘记密码?</a> -->
                <a href="/register">注册新账号</a>
            </div>
        </form>
    </div>
</body>
</html>