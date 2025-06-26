<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>图片上传系统</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
            background-color: #f5f5f5;
        }
        .upload-container {
            background-color: white;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            color: #333;
            text-align: center;
            margin-bottom: 30px;
        }
        .form-group {
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
            color: #555;
        }
        input[type="number"],
        input[type="file"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
            font-size: 16px;
        }
        .btn-upload {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 12px 20px;
            font-size: 16px;
            border-radius: 4px;
            cursor: pointer;
            width: 100%;
            transition: background-color 0.3s;
        }
        .btn-upload:hover {
            background-color: #45a049;
        }
        #preview {
            margin-top: 20px;
            text-align: center;
        }
        #preview img {
            max-width: 300px;
            max-height: 300px;
            border: 1px solid #ddd;
            border-radius: 4px;
            padding: 5px;
        }
        .status-message {
            margin-top: 15px;
            padding: 10px;
            border-radius: 4px;
            text-align: center;
        }
        .success {
            background-color: #dff0d8;
            color: #3c763d;
        }
        .error {
            background-color: #f2dede;
            color: #a94442;
        }
    </style>
</head>
<body>
    <div class="upload-container">
        <h1>图片上传系统</h1>

        <form id="uploadForm" enctype="multipart/form-data">
            <div class="form-group">
                <label for="captureid">Capture ID:</label>
                <input type="number" id="captureid" name="captureid" required>
            </div>

            <div class="form-group">
                <label for="internalnumber">Internal Number:</label>
                <input type="number" id="internalnumber" name="internalnumber" required>
            </div>

            <div class="form-group">
                <label for="photo">选择图片:</label>
                <input type="file" id="photo" name="photo" accept="image/*" required>
            </div>

            <button type="button" class="btn-upload" onclick="uploadData()">上传数据</button>
        </form>

        <div id="preview"></div>
        <div id="statusMessage" class="status-message" style="display: none;"></div>
    </div>

    <script>
        function uploadData() {
            const formData = new FormData(document.getElementById('uploadForm'));
            const statusDiv = document.getElementById('statusMessage');
            statusDiv.style.display = 'none';

            // 验证输入
            const captureid = document.getElementById('captureid').value;
            const internalnumber = document.getElementById('internalnumber').value;
            const photoFile = document.getElementById('photo').files[0];

            if (!captureid || !internalnumber || !photoFile) {
                statusDiv.style.display = 'block';
                statusDiv.className = 'status-message error';
                statusDiv.textContent = '请填写所有必填字段';
                return;
            }

            // 显示加载状态
            const uploadBtn = document.querySelector('.btn-upload');
            const originalBtnText = uploadBtn.textContent;
            uploadBtn.textContent = '上传中...';
            uploadBtn.disabled = true;

            // 添加表单数据
            formData.append('captureid', captureid);
            formData.append('internalnumber', internalnumber);
            formData.append('photo', photoFile);

            fetch('/addcdata', {
                method: 'POST',
                body: formData
            })
            .then(response => {
                if (!response.ok) {
                    throw new Error('网络响应不正常');
                }
                return response.json();
            })
            .then(data => {
                // 显示上传结果
                statusDiv.style.display = 'block';

                if (data > 0) {
                    // 上传成功
                    statusDiv.className = 'status-message success';
                    statusDiv.textContent = '上传成功！';

                    // 显示预览
                    if (photoFile) {
                        const reader = new FileReader();
                        reader.onload = function(e) {
                            document.getElementById('preview').innerHTML =
                                `<img src="${(e.target.result)!}" alt="预览">`;
                        };
                        reader.readAsDataURL(photoFile);
                    }
                } else {
                    // 上传失败
                    statusDiv.className = 'status-message error';
                    statusDiv.textContent = '上传失败，请检查数据';
                }
            })
            .catch(error => {
                console.error('Error:', error);
                statusDiv.style.display = 'block';
                statusDiv.className = 'status-message error';
                statusDiv.textContent = '上传出错: ' + error.message;
            })
            .finally(() => {
                uploadBtn.textContent = originalBtnText;
                uploadBtn.disabled = false;
            });
        }

        // 实时预览功能
        document.getElementById('photo').addEventListener('change', function(e) {
            const file = e.target.files[0];
            if (!file) return;

            if (!file.type.match('image.*')) {
                alert('请选择图片文件');
                e.target.value = '';
                return;
            }

            const reader = new FileReader();
            reader.onload = function(e) {
                document.getElementById('preview').innerHTML =
                    `<img src="${(e.target.result)!}" alt="预览">`;
            };
            reader.readAsDataURL(file);
        });
    </script>
</body>
</html>