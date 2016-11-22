<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
    <title>Start</title>
    <!-- CSS file -->
    <link href="css/start.css" rel="stylesheet">
    <!-- JavaScript -->
    <script src="js/start.js"></script>
</head>
<body>
<div class="startPage">
    <div class="description">
        <h2><strong>Угадай число от 0 до 100</strong></h2>
    </div>

    <div class="input-field">
        <form action="" method="post">
            <%--<label class="active" for="value"><h3>Value</h3></label>--%>
            <input id="value" type="text"  name="count">
        </form>
    </div>
    <div>
        <form action="" method="POST">
            <input type="hidden" name="action" value="start">
            <input type="submit" name="start" value="start">
        </form>
    </div>
</div>
</body>
</html>