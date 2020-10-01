<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <header>
        <h3 align="center">Авторизация</h3>
    </header>

    <main>
        <form action="" method="get" style="text-align: center">
            <input type="hidden" name="command" value="authorize_user">
            <input type="text" value="" placeholder="Логин" name="login" required style="display: block; margin-left: auto; margin-right: auto;">
            <input type="password" value="" placeholder="Пароль" name="password" style="display: block; margin-left: auto; margin-right: auto; margin-top: 15px" required>
            <input type="submit" value="Войти" style="display: block; margin-left: auto; margin-right: auto; margin-top: 15px">
        </form>
        <form action="" method="get" id="go_to_reg_form" style="text-align: center">
            <input type="hidden" name="command" value="go_to_registration_page">
            <a href="#" onclick="document.getElementById('go_to_reg_form').submit(); return false;">Зарегистрироваться?</a>
        </form>
    </main>

    <footer></footer>
</body>
</html>
