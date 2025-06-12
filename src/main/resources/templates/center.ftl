<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>个人中心</title>
    <style>
        :root {
            --primary-bg: #2c3e50;
            --secondary-bg: #f4f4f4;
            --text-color: #333;
            --primary-red: #e74c3c;
            --hover-red: #c0392b;
            --modal-bg: rgba(0,0,0,0.4);
        }

        body {
            margin: 0;
            padding: 0;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #e9ecef;
        }

        .header {
            background-color: var(--primary-bg);
            color: white;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 20px;
        }

        .avatar img {
            width: 50px;
            height: 50px;
            border-radius: 50%;
            margin-right: 10px;
            border: 2px solid white;
            object-fit: cover;
        }

        .actions a {
            color: white;
            margin-left: 20px;
            text-decoration: none;
            padding: 8px 15px;
            border-radius: 4px;
            transition: background-color 0.3s;
        }

        .actions a:hover {
            background-color: rgba(255, 255, 255, 0.1);
        }

        .modal {
            display: none;
            position: fixed;
            z-index: 1;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            overflow: auto;
            background-color: var(--modal-bg);
        }

        .modal-content {
            background-color: #fefefe;
            margin: 15% auto;
            padding: 20px;
            border: 1px solid #888;
            width: 300px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }

        .close {
            color: #aaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
        }

        .close:hover,
        .close:focus {
            color: black;
            text-decoration: none;
            cursor: pointer;
        }

        button {
            background-color: var(--primary-red);
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        button:hover {
            background-color: var(--hover-red);
        }

        /* 新增加载状态样式 */
        .loading-indicator {
            font-size: 0.9em;
            color: #999;
            margin-left: 10px;
        }
    </style>
</head>
<body>
    <div class="header">
        <div class="avatar">
            <img id="userAvatar" src="/static/img/userlogo/logo.png" alt="用户头像">
            <span id="userName">
                <span id="displayName">加载中...</span>
                <span class="loading-indicator" id="loadingText">⏳</span>
            </span>
        </div>
        <div class="actions">
            <a href="javascript:void(0);" onclick="openModal()">账号注销</a>
            <a href="/modify">个人信息修改</a>
            <a href="index.html">返回首页</a>
        </div>
    </div>

    <div id="myModal" class="modal">
        <div class="modal-content">
            <span class="close" onclick="closeModal()">&times;</span>
            <p>确定要注销账号吗？</p>
            <button onclick="logout()">确认注销</button>
        </div>
    </div>

    <script>
        // 原有模态框功能保持不变
        function openModal() {
            document.getElementById('myModal').style.display = 'block';
        }

        function closeModal() {
            document.getElementById('myModal').style.display = 'none';
        }

        function logout() {
            if (confirm('确定要注销账号吗？')) {
                // 实际应调用注销接口
                alert('账号已注销');
                window.location.href = 'login.html';
            }
        }

        // 新增用户信息加载逻辑
        document.addEventListener('DOMContentLoaded', function() {
            // 模拟API地址（实际应替换为真实接口）
            const API_URL = '/api/user/profile';
            
            // 显示加载状态
            const loadingText = document.getElementById('loadingText');
            loadingText.style.display = 'inline';

            // 模拟请求超时处理
            const controller = new AbortController();
            const timeoutId = setTimeout(() => controller.abort(), 5000);

            fetch(API_URL, { signal: controller.signal })
                .then(response => {
                    clearTimeout(timeoutId);
                    if (!response.ok) {
                        throw new Error(`HTTP错误！`);
                    }
                    return response.json();
                })
                .then(data => {
                    // 更新头像
                    const avatarImg = document.getElementById('userAvatar');
                    avatarImg.src = data.avatarUrl || 'default-avatar.jpg';
                    avatarImg.alt = data.userName || '用户头像';

                    // 更新昵称
                    const displayName = document.getElementById('displayName');
                    displayName.textContent = data.userName || '匿名用户';

                    // 隐藏加载状态
                    loadingText.style.display = 'none';
                })
                .catch(error => {
                    clearTimeout(timeoutId);
                    console.error('用户信息加载失败:', error);
                    
                    // 错误处理
                    const displayName = document.getElementById('displayName');
                    displayName.textContent = '加载失败';
                    
                    // 显示错误提示（可选）
                    // alert('用户信息加载失败，请刷新页面重试');
                });
        });
    </script>
</body>
</html>