// 页面加载时获取所有日志
window.onload = function() {
    document.getElementById('searchInput').value = '';
    fetchData();
    //setInterval(fetchData, 5000); // 每隔 5 秒获取一次数据
};

// 搜索功能
function fetchData() {
    const searchInput = document.getElementById('searchInput').value.trim();
    const url='/recordersearch?str='+searchInput;
    fetch(url)
        .then(response => response.json())
        .then(data => {
            displayLogs(data);
        })
        .catch(error => {
            console.error('Error:', error);
        });
}

// 显示日志
function displayLogs(logs) {
    const resultsDiv = document.getElementById('results');
    resultsDiv.innerHTML = ''; // 清空之前的内容

    if (logs.length === 0) {
        resultsDiv.innerHTML = '<p>未找到相关日志</p>';
        return;
    }

    logs.forEach(log => {
        const logEntry = document.createElement('div');
        logEntry.style.marginBottom = '10px';
        logEntry.style.padding = '10px';
        logEntry.style.backgroundColor = '#f9f9f9';
        logEntry.style.border = '1px solid #ddd';
        logEntry.style.borderRadius = '4px';

        logEntry.innerHTML = `
	<div style="display: grid; grid-template-columns: auto auto auto  auto; align-items: center;">
    	    <p style="text-align: left;">${log.sourceIP}</p>    
    	    <p style="text-align: center;">${log.destinationPort} </p>
            <p style="text-align: center;">${log.timecamp} </p>
    	    <p style="text-align: right;">${log.labell} </p></div>`;

        resultsDiv.appendChild(logEntry);
    });
}
//左导航栏跳转
document.getElementById('clickableDiv1').addEventListener('click', function() {
    window.location.href = '性能.html';
});
document.getElementById('clickableDiv2').addEventListener('click', function() {
    window.location.href = '/recorder';
});
document.getElementById('clickableDiv3').addEventListener('click', function() {
    window.location.href = '/ip';
});
// 调用后端 API 获取用户姓名
fetch('/getusername')
    .then(response => response.text())
    .then(data => {
        // 将用户姓名显示在 div 中
        document.getElementById('username').textContent = data;
    })
    .catch(error => {
        console.error('Error:', error);
        document.getElementById('username').textContent = '加载失败';
    });