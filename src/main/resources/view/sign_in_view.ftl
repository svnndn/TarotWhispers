<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sign in</title>
    <link rel="stylesheet" type="text/css" href="/res/styles/form_style.css">
</head>
<body>
<div class="wave"></div>
<div class="wave"></div>
<div class="wave"></div>
<div class="column" style="box-sizing: revert !important">
    <h1>Sign in</h1>
    <form method="post">
        <div>
            <label>
                <input type="text" name="username" placeholder="username">
            </label>
        </div>
        <div>
            <label>
                <input name="password" type="password" placeholder="Password">
            </label>
        </div>
        <div>
            <input type="submit" value="Sign in">
        </div>
    </form>
    <#if errorMessage??>
        <div class="error">Invalid username or password</div>
    </#if>

    <div>
        <p style="color: whitesmoke; text-align: center">New to EmoNote? <a href="sign-up" style="color: white;">Create an account</a></p>
    </div></div>
</body>
</html>