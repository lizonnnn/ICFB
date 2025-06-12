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

    //信息的增删查

    let currentPage = 1;
    let totalPages = 1;
    fetch('/iptotalpage')
    .then(response => response.json()) // 解析 JSON 响应
    .then(data => {
        currentPage = data; // 将接口返回的值赋给 currentPage
        console.log('Total pages:', currentPage); // 打印结果
    })
    .catch(error => {
        console.error('Error fetching total pages:', error);
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
    // 搜索功能
    function searchpage(page=1) {
        currentPage=page;
    fetch('/ippage?pagesize=7&page='+currentPage)
    .then(response => response.json())
    .then(data => {
    displayResults(data);
    updatePagination();
});
}
function search(page=1) {
    currentPage=page;
    const searchInput = document.getElementById('searchInput').value.trim();
    fetch('/ipsearch?pagesize=7&page='+currentPage+'&str='+searchInput)
        .then(response => response.json())
        .then(data => {
            displayResults(data);
            updatePagination();
        });
}

    // 显示搜索结果
    function displayResults(results) {
    const resultsDiv = document.getElementById('results');
    resultsDiv.innerHTML = ''; // 清空结果容器

    // 确保 results 是数组
    if (!Array.isArray(results)) {
        return;
    }
    let index=1;
    results.forEach(Ip => {
        const itemDiv = document.createElement('div');
        itemDiv.innerHTML = `
            <div style="display: grid; grid-template-columns: auto auto auto auto; align-items: center;">
                <p>${(currentPage-1)*7+index}</p>
                <p>${Ip.ipaddress}</p>
                <p>${Ip.timecon}</p>
                <button onclick="deleteItem(${Ip.id})">删除</button>
            </div>
            <hr style="border: none; height: 1px; background-color: black; margin-top: 0;">
        `;
        resultsDiv.appendChild(itemDiv);
        index++;
    });
}
    // 删除功能
 /*   function deleteItem(ip) {
    fetch(`id=${ip}`, { method: 'DELETE' })
        .then(() => search());
}
*/
/**
 * 删除指定 id 的记录
 * @param {number|string} id - 要删除的记录的 id
 */
function deleteItem(id) {
    const encodedId = encodeURIComponent(id);
    fetch(`/ipdelete?id=${encodedId}`, {
        method: "DELETE", // 使用 DELETE 方法
        headers: {
            "Content-Type": "application/json" // 设置请求头
        }
    })
        .then(response => {
            if (!response.ok) {
                // 如果响应状态码不是 2xx，抛出错误
                throw new Error(`HTTP error! Status: ${response.status}`);
            }
            return response.json(); // 解析响应数据为 JSON
        })
        .then(data => {
            // 删除成功后的处理逻辑
            console.log("删除成功:", data);
            alert("记录删除成功！");
            searchpage(currentPage);
            // 可以在这里调用其他函数，例如刷新页面或重新加载数据
        })
        .catch(error => {
            // 捕获并处理错误
            console.error("删除失败:", error);
            alert("删除记录时发生错误，请重试。");
        });

}
function nextPage() {
    if (currentPage < totalPages) {
        currentPage++;
        searchpage(currentPage);
    }
}
function prevPage() {
    if (currentPage >=2) {
        currentPage--;
        searchpage(currentPage);
    }
}

function convertToZonedDateTime(datetimeString) {
    // 将输入字符串转换为 Date 对象
    const date = new Date(datetimeString);

    // 获取时区偏移量（分钟）
    const timezoneOffset = date.getTimezoneOffset();

    // 将时间转换为 ISO 8601 格式，并附加时区信息
    const zonedDateTime = date.toISOString().slice(0, -1) + formatTimezoneOffset(timezoneOffset);

    return zonedDateTime;
}

function formatTimezoneOffset(offset) {
    // 将分钟偏移量转换为 ±HH:mm 格式
    const hours = Math.abs(Math.floor(offset / 60));
    const minutes = Math.abs(offset % 60);
    const sign = offset > 0 ? '-' : '+';
    return `${sign}${String(hours).padStart(2, '0')}:${String(minutes).padStart(2, '0')}`;
}

    // 更新分页按钮状态
    function updatePagination() {
    document.getElementById('prevPage').disabled = currentPage === 1;
    document.getElementById('nextPage').disabled = currentPage === totalPages;
}
    // 打开添加弹窗
    function openAddModal() {
    document.getElementById('addModal').style.display = 'block';
}
    // 关闭添加弹窗
    function closeAddModal() {
    document.getElementById('addModal').style.display = 'none';
}
    // 添加信息
    function addItem() {
    const ipaddress = document.getElementById('addip').value;
    const timecon = document.getElementById('addtime').value;
    fetch('/ipadd', {
    method: 'POST',
    headers: {
    'Content-Type': 'application/json'
},
    body: JSON.stringify({ipaddress,timecon})
}).then(() => {
    closeAddModal();
    alert(ipaddress+timecon);
    searchpage(); // 刷新列表
});
}
window.onload = searchpage(1);