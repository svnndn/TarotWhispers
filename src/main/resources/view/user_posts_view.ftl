<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Posts</title>
</head>
<body>
<h1>User Posts</h1>
<#list posts as post>
    <p>${post.content}</p>
</#list>
</body>
</html>