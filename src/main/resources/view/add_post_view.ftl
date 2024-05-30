<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Post</title>
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
    <h1>Add Post</h1>
    <form id="postForm" method="post" action="/posts">
        <div>
            <label>
                Title:
                <input type="text" name="title" required>
            </label>
        </div>
        <div>
            <label>
                Content:
                <textarea name="content" required></textarea>
            </label>
        </div>
        <div>
            <label>
                Which tarot card best matches your post:
                <select id="url" name="imageUrl">
                    <option value="maket2.png">Влюбленные</option>
                    <option value="maket3.png">Звезда</option>
                    <option value="maket4.png">Солнце</option>
                    <option value="maket5.png">Луна</option>
                    <option value="maket6.png">Рыцарь пентаклей</option>
                    <option value="maket7.png">Тройка мечей</option>
                    <option value="maket8.png">Королева кубков</option>
                    <option value="maket9.png">Дьявол</option>
                    <option value="maket10.png">Пятерка кубков</option>
                    <option value="maket11.png">Сила</option>
                    <option value="maket12.png">Башня</option>
                    <option value="maket13.png">Туз мечей</option>
                    <option value="maket14.png">Десятка мечей</option>
                    <option value="maket15.png">Жрица</option>
                    <option value="maket16.png">Маг</option>
                    <option value="maket17.png">Туз кубков</option>
                    <option value="maket18.png">Повешенный</option>
                    <option value="maket19.png">Король кубков</option>
                    <option value="maket20.png">Колесница</option>
                    <option value="maket21.png">Двойка мечей</option>
                    <option value="maket22.png">Восьмерка мечей</option>
                    <option value="maket23.png">Девятка мечей</option>
                    <option value="maket24.png">Смерть</option>
                    <option value="maket25.png">Императрица</option>
                    <option value="maket26.png">Король пентаклей</option>
                    <option value="maket27.png">Королева пентаклей</option>
                    <option value="maket28.png">Туз жезлов</option>
                    <option value="maket29.png">Туз пентаклей</option>
                    <option value="maket30.png">Четверка пентаклей</option>
                    <option value="maket31.png">Рыцарь кубков</option>
                    <option value="maket32.png">Шут</option>
                    <option value="maket33.png">Фортуна</option>
                    <option value="maket34.png">Восьмерка жезлов</option>
                    <option value="maket35.png">Пятерка мечей</option>
                    <option value="maket36.png">Королева жезлов</option>
                    <option value="maket37.png">Мир</option>
                    <option value="maket38.png">Королева мечей</option>
                    <option value="maket39.png">Король мечей</option>
                    <option value="maket40.png">Суд</option>
                    <option value="maket41.png">Девятка пентаклей</option>
                    <option value="maket42.png">Пятерка пентаклей</option>
                    <option value="maket43.png">Шестерка пентаклей</option>
                    <option value="maket44.png">Восьмерка кубков</option>
                    <option value="maket45.png">Семерка жезлов</option>
                    <option value="maket46.png">Шестерка мечей</option>
                    <option value="maket47.png">Справедливость</option>
                    <option value="maket48.png">Десятка кубков</option>
                    <option value="maket49.png">Тройка кубков</option>
                    <option value="maket50.png">Жрец</option>
                    <option value="maket51.png">Император</option>
                    <option value="maket52.png">Умеренность</option>
                    <option value="maket53.png">Двойка пентаклей</option>
                    <option value="maket54.png">Рыцарь мечей</option>
                    <option value="maket55.png">Четверка мечей</option>
                    <option value="maket56.png">Двойка кубков</option>
                    <option value="maket57.png">Восьмерка пентаклей</option>
                    <option value="maket58.png">Король жезлов</option>
                    <option value="maket59.png">Десятка жезлов</option>
                    <option value="maket60.png">Семерка мечей</option>
                    <option value="maket61.png">Четверка кубков</option>
                    <option value="maket62.png">Семерка кубков</option>
                    <option value="maket63.png">Десятка пентаклей</option>
                    <option value="maket64.png">Двойка жезлов</option>
                    <option value="maket65.png">Тройка жезлов</option>
                    <option value="maket66.png">Шестерка жезлов</option>
                    <option value="maket67.png">Четверка жезлов</option>
                    <option value="maket68.png">Тройка пентаклей</option>
                    <option value="maket69.png">Девятка кубков</option>
                    <option value="maket70.png">Пятерка жезлов</option>
                    <option value="maket71.png">Шестерка кубков</option>
                    <option value="maket72.png">Рыцарь жезлов</option>
                    <option value="maket73.png">Девятка жезлов</option>
                    <option value="maket74.png">Семерка пентаклей</option>
                    <option value="maket75.png">Паж мечей</option>
                    <option value="maket76.png">Паж кубков</option>
                    <option value="maket77.png">Паж пентаклей</option>
                    <option value="maket78.png">Паж жезлов</option>
                    <option value="maket1.png">Отшельник</option>
                </select>
            </label>
        </div>
        <div>
            <input type="submit" value="Add Post">
        </div>
    </form>
    <div id="errorMessage" class="error" style="display: none;"></div>
</div>

</body>
</html>