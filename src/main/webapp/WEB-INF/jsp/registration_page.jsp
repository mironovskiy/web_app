<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Low Cost перевозчик</title>
</head>
<body>
<header>
    <h3 align="center">Регистрация</h3>
</header>

<main>
    <form action="authorization" method="post" style="text-align: center">
        <input type="hidden" name="command" value="save_new_user">
        <input type="text" value="" placeholder="Логин" name="login" required style="display: block; margin-left: auto; margin-right: auto;">
        <input type="password" value="" placeholder="Пароль" name="password" style="display: block; margin-left: auto; margin-right: auto; margin-top: 15px" required>
        <input type="password" value="" placeholder="Повт. пароль" name="rep_password" style="display: block; margin-left: auto; margin-right: auto; margin-top: 15px" required>
        <input type="submit" value="Зарегистрироваться" style="display: block; margin-left: auto; margin-right: auto; margin-top: 15px">
    </form>
</main>

<footer></footer>
</body>
</html>
