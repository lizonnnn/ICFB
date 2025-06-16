<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>用户注册</title>
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
        
        /* 注册框容器样式 */
        .register-container {
            width: 100%;
            max-width: 450px;
            padding: 40px;
            background-color: rgba(255, 255, 255, 0.95);
            border-radius: 10px;
            box-shadow: 0 15px 30px rgba(0, 0, 0, 0.15);
            transition: all 0.3s ease;
        }
        
        /* 鼠标悬停时注册框效果 */
        .register-container:hover {
            box-shadow: 0 20px 40px rgba(0, 0, 0, 0.25);
            transform: translateY(-5px);
        }
        
        /* 标题样式 */
        .register-title {
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
        .input-group input {
            width: 100%;
            padding: 12px 15px;
            border: 1px solid #ddd;
            border-radius: 5px;
            font-size: 16px;
            transition: all 0.3s;
            background-color: #f9f9f9;
        }
        
        /* 输入框聚焦效果 */
        .input-group input:focus {
            border-color: #4facfe;
            box-shadow: 0 0 0 3px rgba(79, 172, 254, 0.2);
            outline: none;
            background-color: #fff;
        }
        
        /* 密码强度提示样式 */
        .password-hint {
            font-size: 12px;
            color: #666;
            margin-top: 5px;
            display: none;
        }
        
        /* 错误提示样式 */
        .error-message {
            color: #e74c3c;
            font-size: 12px;
            margin-top: 5px;
            display: none;
        }
        
        /* 注册按钮样式 */
        .register-btn {
            width: 100%;
            padding: 12px;
            background: linear-gradient(to right, #667eea 0%, #764ba2);
            border: none;
            border-radius: 5px;
            color: white;
            font-size: 16px;
            font-weight: 600;
            cursor: pointer;
            transition: all 0.3s;
            margin-top: 10px;
        }
        
        /* 注册按钮悬停效果 */
        .register-btn:hover {
            background: linear-gradient(to right, #3ca0f0, #00d9e6);
            box-shadow: 0 5px 15px rgba(79, 172, 254, 0.4);
        }
        
        /* 底部链接样式 */
        .bottom-links {
            text-align: center;
            margin-top: 20px;
            font-size: 14px;
        }
        
        .bottom-links a {
            color: #4facfe;
            text-decoration: none;
            transition: color 0.3s;
        }
        
        .bottom-links a:hover {
            color: #00a8ff;
            text-decoration: underline;
        }
        
        /* 响应式设计 - 在小屏幕上调整样式 */
        @media (max-width: 480px) {
            .register-container {
                padding: 30px 20px;
                margin: 0 15px;
            }
            
            .register-title {
                font-size: 24px;
                margin-bottom: 20px;
            }
        }
    </style>
</head>
<body>
    <!-- 注册表单容器 -->
    <div class="register-container">
        <!-- 注册标题 -->
        <h1 class="register-title">用户注册</h1>
        
        <!-- 注册表单 -->
        <form id="registerForm" action="/registerfunc" method="POST" onsubmit="return validateForm()">
            <!-- 用户名输入组 -->
            <div class="input-group">
                <label for="username">用户名</label>
                <input 
                    type="text" 
                    id="username" 
                    name="username" 
                    placeholder="请输入用户名（4-20个字符）" 
                    required
                    minlength="4"
                    maxlength="20"
                    autocomplete="username"
                >
                <div id="usernameError" class="error-message">用户名长度应在4-20个字符之间</div>
            </div>
            
            <!-- 密码输入组 -->
            <div class="input-group">
                <label for="password">密码</label>
                <input 
                    type="password" 
                    id="password" 
                    name="password" 
                    placeholder="请输入密码（至少8位，包含字母和数字）" 
                    required
                    minlength="8"
                    autocomplete="new-password"
                    oninput="checkPasswordStrength()"
                >
                <div id="passwordHint" class="password-hint">密码必须包含字母和数字，且长度大于8个字符</div>
                <div id="passwordError" class="error-message">密码必须包含字母和数字，且长度大于8个字符</div>
            </div>
            
            <!-- 确认密码输入组 -->
            <div class="input-group">
                <label for="confirmPassword">确认密码</label>
                <input 
                    type="password" 
                    id="confirmPassword" 
                    name="confirmPassword" 
                    placeholder="请再次输入密码" 
                    required
                    autocomplete="new-password"
                >
                <div id="confirmPasswordError" class="error-message">两次输入的密码不一致</div>
            </div>
            
            <!-- 邮箱输入组 -->
            <div class="input-group">
                <label for="email">电子邮箱</label>
                <input 
                    type="email" 
                    id="email" 
                    name="email" 
                    placeholder="请输入有效的电子邮箱" 
                    required
                    autocomplete="email"
                >
                <div id="emailError" class="error-message">请输入有效的电子邮箱地址</div>
            </div>
            
            <!-- 注册按钮 -->
            <button type="submit" class="register-btn">注 册</button>
            
            <!-- 底部链接 -->
            <div class="bottom-links">
                已有账号？<a href="/">立即登录</a>
            </div>
        </form>
    </div>

    <script>
        // 密码强度检查
        function checkPasswordStrength() {
            const password = document.getElementById('password').value;
            const hint = document.getElementById('passwordHint');
            const error = document.getElementById('passwordError');
            
            // 显示提示
            hint.style.display = 'block';
            error.style.display = 'none';
            
            // 检查密码长度
            if (password.length > 0 && password.length < 8) {
                hint.style.color = '#e74c3c';
            } else {
                hint.style.color = '#666';
            }
        }
        
        // 表单验证
        function validateForm() {
            let isValid = true;
            
            // 验证用户名
            const username = document.getElementById('username').value;
            const usernameError = document.getElementById('usernameError');
            if (username.length < 4 || username.length > 20) {
                usernameError.style.display = 'block';
                isValid = false;
            } else {
                usernameError.style.display = 'none';
            }
            
            // 验证密码
            const password = document.getElementById('password').value;
            const passwordError = document.getElementById('passwordError');
            const passwordRegex = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$/;
            if (!passwordRegex.test(password)) {
                passwordError.style.display = 'block';
                document.getElementById('passwordHint').style.display = 'none';
                isValid = false;
            } else {
                passwordError.style.display = 'none';
            }
            
            // 验证确认密码
            const confirmPassword = document.getElementById('confirmPassword').value;
            const confirmPasswordError = document.getElementById('confirmPasswordError');
            if (password !== confirmPassword) {
                confirmPasswordError.style.display = 'block';
                isValid = false;
            } else {
                confirmPasswordError.style.display = 'none';
            }
            
            // 验证邮箱
            const email = document.getElementById('email').value;
            const emailError = document.getElementById('emailError');
            const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            if (!emailRegex.test(email)) {
                emailError.style.display = 'block';
                isValid = false;
            } else {
                emailError.style.display = 'none';
            }
            
            return isValid;
        }

        });
    </script>
</body>
</html>