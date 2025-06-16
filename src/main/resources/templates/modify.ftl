<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>个人信息修改</title>
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

     /* 表单容器样式 */
     .form-container {
     width: 100%;
     max-width: 450px;
     padding: 40px;
     background-color: rgba(255, 255, 255, 0.95);
     border-radius: 10px;
     box-shadow: 0 15px 30px rgba(0, 0, 0, 0.15);
     transition: all 0.3s ease;
     }

     /* 鼠标悬停时表单容器效果 */
     .form-container:hover {
     box-shadow: 0 20px 40px rgba(0, 0, 0, 0.25);
     transform: translateY(-5px);
     }

     /* 标题样式 */
     h2 {
     text-align: center;
     margin-bottom: 30px;
     color: #333;
     font-size: 28px;
     font-weight: 600;
     }

     /* 表单组样式 */
     .form-group {
     margin-bottom: 20px;
     position: relative;
     }

     /* 表单标签样式 */
     .form-group label {
     display: block;
     margin-bottom: 8px;
     color: #555;
     font-size: 14px;
     font-weight: 500;
     }

     /* 表单输入框样式 */
     .form-group input {
     width: 100%;
     padding: 12px 15px;
     border: 1px solid #ddd;
     border-radius: 5px;
     font-size: 16px;
     transition: all 0.3s;
     background-color: #f9f9f9;
     }

     /* 表单输入框聚焦效果 */
     .form-group input:focus {
     border-color: #4facfe;
     box-shadow: 0 0 0 3px rgba(79, 172, 254, 0.2);
     outline: none;
     background-color: #fff;
     }

     /* 错误提示样式 */
     .form-group small {
     color: #e74c3c;
     position: absolute;
     bottom: -18px;
     left: 0;
     font-size: 0.8em;
     display: none;
     }

     .form-group.invalid small {
     display: block;
     }

     /* 按钮样式 */
     button {
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

     /* 按钮悬停效果 */
     button:hover {
     background: linear-gradient(to right, #3ca0f0, #00d9e6);
     box-shadow: 0 5px 15px rgba(79, 172, 254, 0.4);
     }

     /* 返回链接样式 */
     .back-link {
     display: block;
     text-align: center;
     margin-top: 20px;
     color: #4facfe;
     text-decoration: none;
     transition: color 0.3s;
     }

     .back-link:hover {
     color: #00a8ff;
     text-decoration: underline;
     }

     /* 响应消息样式 */
     .response-message {
     padding: 10px;
     margin-bottom: 15px;
     border-radius: 4px;
     display: none;
     }

     .success {
     background-color: #d4edda;
     color: #155724;
     border: 1px solid #c3e6cb;
     }

     .error {
     background-color: #f8d7da;
     color: #721c24;
     border: 1px solid #f5c6cb;
     }

     /* 响应式设计 - 在小屏幕上调整样式 */
     @media (max-width: 480px) {
     .form-container {
     padding: 30px 20px;
     margin: 0 15px;
     }

     h2 {
     font-size: 24px;
     margin-bottom: 20px;
     }
     }
     </style>
</head>
<body>
    <div class="form-container">
        <h2>个人信息修改</h2>
        <form id="profileForm" action="/modifyfunc" method="POST">
            <div class="form-group">
                <label for="username">用户名</label>
                <input type="text" id="username" name="username" required minlength="2">
                <small>用户名至少需要2个字符</small>
            </div>
            <div class="form-group">
                <label for="password">密码</label>
                <input type="password" id="password" name="password" required>
            </div>
            <div class="form-group">
                <label for="email">邮箱</label>
                <input type="email" id="email" name="email" required>
                <small>请输入有效的邮箱地址</small>
            </div>
            <div class="response-message" id="responseMessage"></div>
            <button type="submit">提交修改</button>
        </form>
        <a href="/center" class="back-link">返回个人中心</a>
    </div>

    <script>
        const form = document.getElementById('profileForm');
        const responseMessage = document.getElementById('responseMessage');

        // 表单验证
        function validateForm() {
            let isValid = true;
            const username = document.getElementById('username').value.trim();
            const email = document.getElementById('email').value.trim();
            const usernameInput = document.getElementById('username');
            const emailInput = document.getElementById('email');

            // 清除之前的状态
            document.querySelectorAll('.form-group').forEach(group => {
                group.classList.remove('invalid');
            });

            // 用户名验证
            if (username.length < 2) {
                showError(usernameInput, '用户名至少需要2个字符');
                isValid = false;
            }

            // 邮箱验证
            const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            if (!emailRegex.test(email)) {
                showError(emailInput, '请输入有效的邮箱地址');
                isValid = false;
            }

            return isValid;
        }

        // 显示错误信息
        function showError(input, message) {
            const formGroup = input.parentElement;
            formGroup.classList.add('invalid');
            formGroup.querySelector('small').textContent = message;
        }

        // 显示响应消息
        function showMessage(type, message) {
            responseMessage.textContent = message;
            responseMessage.className = `response-message `;
            responseMessage.style.display = 'block';

            // 3秒后自动隐藏
            setTimeout(() => {
                responseMessage.style.display = 'none';
            }, 3000);
        }
    </script>
</body>
</html>