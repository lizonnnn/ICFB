<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>访问记录</title>
    <link rel="stylesheet" type="text/css" href="/static/css/recorder.css">
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
                <span style="position: absolute;top: 50%;left: 50%;transform: translate(-50%, -50%);color: white; font-weight: bold;font-size: 20px;">流量</span>
            </div>
            <div id="clickableDiv2" style="width:100%;height:10%;position:absolute;top:30%; background-color: #5965C9; cursor: pointer;">
                <span style="position: absolute;top: 50%;left: 50%;transform: translate(-50%, -50%);color: white; font-weight: bold;font-size: 20px;">访问日志</span>
            </div>
            <div id="clickableDiv3" style="width:100%;height:10%;position:absolute;top:45%; background-color: #4D58B5; cursor: pointer;">
                <span style="position: absolute;top: 50%;left: 50%;transform: translate(-50%, -50%);color: white; font-weight: bold;font-size: 20px;">访问控制</span>
            </div>
        </div>
    </div>
    <div class="zt">
        <div class="ip">
            <div style="width:80%;height:7%;position:absolute;top:2%;left:10%; background-color: #F5FAFF;">
                <span style="position: absolute;top: 50%;left: 50%;transform: translate(-50%, -50%);color: black; font-weight: bold;font-size: 20px;">访问日志</span>
            </div>
            <div style="width:80%;height:6%;position:absolute;top:11%;left:10%;">
                <input type="text" style="width:30%;height:87%;position:absolute;left:30%;text-align: center;" id="searchInput" placeholder="输入搜索IP">
                <button style="width:5%;height:100%;position:absolute;left:61%;text-align: center;" onclick="search()">搜索</button>
            </div>
            <div style="width:80%;height:70%;position:absolute;top:17%;left:10%">
                <div style="width:100%;height:10%;position:absolute;top:0%;left:0%">
                    <div style="display: grid; grid-template-columns: auto auto auto  auto; align-items: center;">
                        <p style="text-align: left;">访问ip</p>
                        <p style="text-align: center;">访问端口</p>
                        <p style="text-align: center;">访问时间 </p>
                        <p style="text-align: right;">判别结果 </p>
                    </div>
                </div>
                <div id="results" style="width:100%;height:90%;position:absolute;top:10%;left:0%;overflow-y: auto; border: 1px solid #ccc; padding: 10px;">

                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script src="/static/js/recorder.js"></script>
