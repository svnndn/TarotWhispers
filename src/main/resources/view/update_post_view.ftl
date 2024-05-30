<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update Post</title>
    <link rel="stylesheet" type="text/css" href="/res/styles/form_style.css">
</head>
<body>
<header>
    <#include "includes/menu.ftl">
</header>
<div class="wave"></div>
<div class="wave"></div>
<div class="wave"></div>
<div class="column" style="box-sizing: revert !important">
    <h1>Update Post</h1>
    <form id="postForm" method="post" action="/posts/${post.id}">
        <input type="hidden" name="_method" value="put"/>
        <div>
            <label>
                Title:
                <input type="text" name="title" value="${post.title}" required>
            </label>
        </div>
        <div>
            <label>
                Content:
                <textarea name="content" required>${post.content}</textarea>
            </label>
        </div>
        <div>
            <label>
                Image URL:
                <input type="url" name="imageUrl" value="${post.imageUrl}">
            </label>
        </div>
        <div>
            <input type="submit" value="Update Post">
        </div>
    </form>
    <div id="errorMessage" class="error" style="display: none;"></div>
</div>

</body>
</html>