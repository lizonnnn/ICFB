<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>访问控制</title>
    <link rel="stylesheet" type="text/css" href="/static/css/manage_old.css">
</head>
<body>
<div class="container">
    <div class="sdhl">
        <div class="tb">
            <img src="/static/img/logo.png" alt="Image">
        </div>
        <div class="username">
            <span style="position: absolute;top: 50%;left: 50%;transform: translate(-50%, -50%);color: white; font-weight: bold;font-size: 15px;" id="username"></span>
        </div>
    </div>
    <div style="width:15%;height:89%;position:absolute;top:10%;background-color: #F5F7F9;">
        <div class="zdhl">
            <div id="clickableDiv1" style="width:100%;height:10%;position:absolute;top:15%; background-color: #4D58B5; cursor: pointer;">
                <span style="position: absolute;top: 50%;left: 50%;transform: translate(-50%, -50%);color: white; font-weight: bold;font-size: 20px;">性能</span>
            </div>
            <div id="clickableDiv2" style="width:100%;height:10%;position:absolute;top:30%; background-color: #4D58B5; cursor: pointer;">
                <span style="position: absolute;top: 50%;left: 50%;transform: translate(-50%, -50%);color: white; font-weight: bold;font-size: 20px;">访问日志</span>
            </div>
            <div id="clickableDiv3" style="width:100%;height:10%;position:absolute;top:45%; background-color: #5965C9; cursor: pointer;">
                <span style="position: absolute;top: 50%;left: 50%;transform: translate(-50%, -50%);color: white; font-weight: bold;font-size: 20px;">访问控制</span>
            </div>
        </div>
    </div>
    <div class="zt">
        <div class="ip">
            <div style="width:80%;height:7%;position:absolute;top:2%;left:10%; background-color: #F5FAFF;">
                <span style="position: absolute;top: 50%;left: 50%;transform: translate(-50%, -50%);color: black; font-weight: bold;font-size: 20px;">ip黑名单</span>
            </div>
            <div style="width:80%;height:6%;position:absolute;top:11%;left:10%;">
                <input type="text" style="width:58%;height:80%;position:absolute;left:0%;text-align: center;" id="searchInput" placeholder="输入搜索IP">
                <button style="width:14%;height:100%;position:absolute;left:61%;text-align: center;" onclick="search()">搜索</button>
                <button style="width:24%;height:100%;position:absolute;left:76%;text-align: center;" onclick="openAddModal()">添加信息</button>
            </div>

            <div id="results" style="width:80%;height:70%;position:absolute;top:19%;left:10%;">
                <div style="display: grid; grid-template-columns: auto auto auto auto; align-items: center;">
                    <p>序列数</p>
                    <p>IP地址</p>
                    <p>截至访问时间</p>
                </div>
                <hr style="border: none; height: 1px; background-color: black; margin-top: 0;">
            </div>
            <div class="pagination">
                <button id="prevPage" style="width:30%;height:100%;position:absolute;top:0%;left:15%;background-color:white;color:black;" onclick="prevPage()" disabled>上一页</button>
                <button id="nextPage" style="width:30%;height:100%;position:absolute;top:0%;left:55%;background-color:white;color:black;" onclick="nextPage()" disabled>下一页</button>
            </div>
            <!-- 添加信息的弹窗 -->
            <div id="addModal" class="modal">
                <h3>添加信息</h3>
                <input type="text" id="addip" placeholder="IP">
                <input type="datetime-local" id="addtime" placeholder="禁止访问时间">
                <button onclick="addItem()">添加</button>
                <button onclick="closeAddModal()">关闭</button>
            </div>
        </div>
    </div>
</div>
</body>
<script src="/static/js/ipmanage.js"></script>