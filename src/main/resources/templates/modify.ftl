<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>个人信息修改</title>
    <style>
        /* 原有样式保持不变 */
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #f5f7fa, #c3cfe2);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .form-container {
            background-color: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
            width: 350px;
        }
        /* 新增响应样式 */
        .form-group {
            margin-bottom: 15px;
            position: relative;
        }
        .form-group input {
            width: 100%;
            padding: 8px;
            border: 1px solid #ced4da;
            border-radius: 4px;
            transition: border-color 0.3s;
        }
        .form-group input:focus {
            border-color: #007BFF;
            outline: none;
            box-shadow: 0 0 0 0.2rem rgba(0, 123, 255, 0.25);
        }
        .form-group small {
            color: #dc3545;
            position: absolute;
            bottom: -18px;
            left: 0;
            font-size: 0.8em;
            display: none;
        }
        .form-group.invalid small {
            display: block;
        }
        button {
            width: 100%;
            padding: 12px;
            background-color: #007BFF;
            color: white;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            transition: background-color 0.3s;
            margin-bottom: 15px;
        }
        button:hover {
            background-color: #0056b3;
        }
        .back-link {
            display: block;
            text-align: center;
            color: #007BFF;
            text-decoration: none;
            transition: color 0.3s;
        }
        .back-link:hover {
            color: #0056b3;
        }
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
    </style>
</head>
<body>
    <div class="form-container">
        <h2>个人信息修改</h2>
        <form id="profileForm">
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

        // 提交处理
        form.addEventListener('submit', async (e) => {
            e.preventDefault();
            
            if (!validateForm()) return;

            const formData = {
                username: document.getElementById('username').value.trim(),
                email: document.getElementById('email').value.trim()
            };

            try {
                const response = await fetch('/api/user/update', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(formData)
                });

                const result = await response.json();

                if (response.ok) {
                    showMessage('success', '信息更新成功！');
                    
                    // 3秒后自动返回个人中心
                    setTimeout(() => {
                        window.location.href = 'personal_center.html?refresh';
                    }, 3000);
                } else {
                    showMessage('error', result.message || '更新失败，请重试');
                }
            } catch (error) {
                showMessage('error', '网络错误，请检查连接');
                console.error('提交失败:', error);
            }
        });

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