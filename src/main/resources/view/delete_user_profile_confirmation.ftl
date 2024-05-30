<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Delete User Profile Confirmation</title>
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
    <h1>Delete User Profile Confirmation</h1>
    <p>Are you sure you want to delete the profile of ${user.username}?</p>
    <form action="/profile/delete/${user.id}" method="post">
        <input type="submit" value="Yes, Delete Profile">
    </form>
    <div>
        <p style="text-align: center;"> <a style="color:whitesmoke" href="/profile/${user.id}">Cancel</a></p>
    </div>
</div>
</body>
</html>