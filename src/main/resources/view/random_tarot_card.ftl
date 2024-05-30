<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Random Tarot Card</title>
    <link rel="stylesheet" type="text/css" href="/res/styles/form_style.css">
    <link rel="stylesheet" type="text/css" href="/res/styles/singlepost_style.css">
</head>
<body>
<header>
    <#include "includes/menu.ftl">
</header>
<div class="header">
    <div class="column" style="box-sizing: revert !important;">
        <h1 style="font-size: 40px">Daily Tarot Card</h1>
        <p style="font-size: 25px;
    font-style: italic;
    font-family: emoji;">The card of the day is: ${cardName}</p>
        <p style="font-size: 25px;
    font-style: italic;
    font-family: emoji;">Would you like to learn more about this card? <a href="/tarot-cards">Click here</a>.</p>
    </div>
</div>
</body>
</html>