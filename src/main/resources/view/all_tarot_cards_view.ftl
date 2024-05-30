<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>All Tarot Cards</title>
    <style>
        body {
            background-color: rgb(11, 11, 11);
        }
        .cards-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
        }
        .card {
            width: 16%;
            margin: 0.5%;
            box-sizing: border-box;
            text-align: center;
        }
        .card img {
            width: 100%;
            height: auto;
            border-radius: 10px;
        }
        .card-title {
            margin-top: 5px;
            text-decoration: none;
            color: #ffffff;
            font-size: 25px;
        }
        .card-title:hover {
            color: #eeeeee;
        }
    </style>
</head>
<body>
<header>
    <#include "includes/menu.ftl">
</header>
<h1>Forgotten Legends Tarot</h1>
<div class="cards-container">
    <#list tarotCards as tarotCard>
        <div class="card">
            <#if tarotCard.imageUrl?? && tarotCard.imageUrl != "">
                <img src="/res/images/tarotcard/${tarotCard.imageUrl}" alt="Card image">
            </#if>
            <a class="card-title" href="/tarot-cards/${tarotCard.id}">${tarotCard.name}</a>
        </div>
    </#list>
</div>
</body>
</html>