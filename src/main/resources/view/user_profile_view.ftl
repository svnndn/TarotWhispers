<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Profile</title>
    <link rel="stylesheet" type="text/css" href="/res/styles/form_style.css">
    <link rel="stylesheet" type="text/css" href="/res/styles/singlepost_style.css">
    <style>
        .menu {
            position: fixed;
            bottom: 0;
            width: 100%;
            background-color: #333;
            display: flex;
            justify-content: center;
            padding: 10px 0;
        }
        .menu a {
            color: white;
            padding: 10px 20px;
            text-decoration: none;
            text-align: center;
            border: none;
            outline: none;
            background-color: transparent;
            cursor: pointer;
        }
        .menu a img {
            width: 24px;
            height: 24px;
        }
        .menu a:hover {
            background-color: #555;
        }
    </style>
</head>
<body>
<header>
    <#include "includes/menu.ftl">
</header>
<div class="header">
    <div class="column" style="box-sizing: revert !important;">
        <h1>Username: ${user.username}</h1>
        <div>
            <p>Email: ${user.email}</p>
        </div>
        <div>
            <p>Role: ${user.role}</p>
        </div>
    </div>
</div>
<div class="menu">
    <a href="/" title="Back to Home">
        <img src="/res/images/icons/back_icon.png" alt="Back">
    </a>
    <#if (user.username == currentUser.username || currentUser.role == "ROLE_ADMIN")>
        <a href="/profile/edit/${user.id}" title="Edit Profile">
            <img src="/res/images/icons/edit_icon.png" alt="Edit">
        </a>
        <a href="/profile/delete/${user.id}" title="Delete Profile">
            <img src="/res/images/icons/delete_icon.png" alt="Delete">
        </a>
    </#if>
</div>
</body>
</html>