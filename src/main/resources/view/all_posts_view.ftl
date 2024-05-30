<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>All Posts</title>
    <link rel="stylesheet" type="text/css" href="/res/styles/post_style.css">
    <link rel="stylesheet" type="text/css" href="/res/styles/form_style.css">
    <style>.note-details {
            width: 1800px;
        }
    </style>

</head>
<header>
    <#include "includes/menu.ftl">
</header>
<body>
<h1>All Posts</h1>
<#list posts as post>
    <div class="note">
        <div class="note-details" style="margin: 20px">
            <#if post.post.imageUrl??>
                <div class="note-details" style="margin: 20px">
                    <img style="width: 300px; border-radius: 10px;" src="/res/images/tarotcard/${post.post.imageUrl}" alt="Card image">
                </div>
            </#if>
            <h2 style="text-align: left"><a href="/posts/${post.post.id}">${post.post.title}</a></h2>
            <p>${post.post.content}</p>
            <p><a href="/profile/${post.post.user.id}">posted by ${post.post.user.username}</a></p>

            <#if post.likedByCurrentUser>
                <a href="#" id="unlikeIcon_${post.post.id}" onclick="toggleLike('${post.post.id}')" title="Unlike Post">
                    <img src="/res/images/icons/unlike_icon.png" alt="Unlike">
                </a>
                <a href="#" id="likeIcon_${post.post.id}" onclick="toggleLike('${post.post.id}')" title="Like Post" style="display: none;">
                    <img src="/res/images/icons/like_icon.png" alt="Like">
                </a>
            <#else>
                <a href="#" id="likeIcon_${post.post.id}" onclick="toggleLike('${post.post.id}')" title="Like Post">
                    <img src="/res/images/icons/like_icon.png" alt="Like">
                </a>
                <a href="#" id="unlikeIcon_${post.post.id}" onclick="toggleLike('${post.post.id}')" title="Unlike Post" style="display: none;">
                    <img src="/res/images/icons/unlike_icon.png" alt="Unlike">
                </a>
            </#if>
        </div>
    </div>
</#list>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="/res/scripts/likeScript.js"></script>
</body>
</html>