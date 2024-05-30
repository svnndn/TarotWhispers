<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit User Profile</title>
    <link rel="stylesheet" type="text/css" href="/res/styles/form_style.css">
</head>
<header>
    <#include "includes/menu.ftl">
</header>
<div class="wave"></div>
<div class="wave"></div>
<div class="wave"></div>
<body>
<div class="column" style="box-sizing: revert !important">
<h1>Edit User Profile</h1>
    <h2 style="color:whitesmoke; font-style: italic;
    font-family: emoji;">After updating the data, you will be redirected to the sign in page.</h2>
    <h2 style="color:whitesmoke; font-style: italic;
    font-family: emoji;">Please sign in again to your account so that all changes take effect.</h2>
<form action="/profile/edit/${userId}" method="post">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" value="${userDTO.username}" required>
    <br>
    <label for="email">Email:</label>
    <input type="email" id="email" name="email" value="${userDTO.email}" required>
    <br>
    <label for="password">Password:</label>
    <input type="text" id="password" name="password" value="${userDTO.password}" required minlength="7">
    <br>
    <#if currentUser.role != "ROLE_ADMIN">
    <input type="hidden" name="role" value="${userDTO.role}">
    </#if>
    <#if currentUser.role == "ROLE_ADMIN">
        <label for="role">Role:</label>
        <select id="role" name="role">
            <option value="ROLE_USER" <#if userDTO.role == "ROLE_USER">selected</#if>>User</option>
            <option value="ROLE_ADMIN" <#if userDTO.role == "ROLE_ADMIN">selected</#if>>Admin</option>
        </select>
        <br>
    </#if>
    <input type="submit" value="Save Changes">
</form>
<a style="color: whitesmoke; text-align: center" href="/profile/${userId}">Cancel</a>
</div>
</body>
</html>