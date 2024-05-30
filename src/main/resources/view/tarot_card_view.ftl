<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${tarotCard.name}</title>
    <link rel="stylesheet" type="text/css" href="/res/styles/form_style.css">
    <link rel="stylesheet" type="text/css" href="/res/styles/singlepost_style.css">
    <style>
        .header {
            display: flex;
            justify-content: center;
            padding: 20px;
        }
        .column {
            display: flex;
            flex-direction: row;
            align-items: center;
            width: 70%;
        }
        .column img {
            border-radius: 10px;
            max-width: 300px;
            height: auto;
            margin-right: 20px;
        }
        .column .text {
            max-width: 70%;
        }
        .column h1 {
            margin: 0 0 10px 0;
        }
        .column p {
            margin: 0;
        }
    </style>
</head>
<body>
<header>
    <#include "includes/menu.ftl">
</header>
<div class="header">
    <div class="column" style="box-sizing: revert !important;">
        <#if tarotCard.imageUrl?? && tarotCard.imageUrl != "">
            <img src="/res/images/tarotcard/${tarotCard.imageUrl}" alt="Card image">
        </#if>
        <div class="text">
            <h1>${tarotCard.name}</h1>
            <div>
                <p>${tarotCard.meaning}</p>
            </div>
        </div>
    </div>
</div>
</body>
</html>