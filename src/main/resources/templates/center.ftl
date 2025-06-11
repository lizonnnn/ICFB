<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>系统主页</title>
    <link rel="stylesheet" type="text/css" href="/static/css/error.css">
    <style>
        /* 顶部导航栏样式 */
        .top-nav {
            background-color: #2c3e50;
            color: white;
            padding: 15px 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .user-info {
            display: flex;
            align-items: center;
            gap: 15px;
        }

        .logout-btn {
            background-color: #e74c3c;
            color: white;
            border: none;
            padding: 8px 15px;
            border-radius: 4px;
            cursor: pointer;
            font-size: 14px;
            transition: background-color 0.3s;
        }

        .logout-btn:hover {
            background-color: #c0392b;
        }

        /* 主内容区样式 */
        .main-content {
            padding: 20px;
        }
    </style>
</head>
<body>
    <!-- 顶部导航栏 -->
    <div class="top-nav">
        <div class="system-title">动态安全检测系统</div>
        <div class="user-info">
            <span>欢迎, <span id="username-display"></span></span>
            <form action="/logoutfunc" method="post">
                <button type="submit" class="logout-btn">退出登录</button>
            </form>
        </div>
    </div>

    <!-- 主内容区 -->
    <div class="main-content">
        <h2>系统功能界面</h2>
        <!-- 这里放置你的系统功能内容 -->
        <p>这是登录后的主界面内容...</p>
    </div>

    <script>
        // 页面加载时获取并显示用户名
        document.addEventListener('DOMContentLoaded', function() {
            fetch('/getusername')
                .then(response => {
                    if (!response.ok) {
                        throw new Error('未登录或会话已过期');
                    }
                    return response.text();
                })
                .then(username => {
                    document.getElementById('username-display').textContent = username;
                })

        });
    </script>
</body>
</html>