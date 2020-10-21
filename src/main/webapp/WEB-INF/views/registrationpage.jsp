<!DOCTYPE html>

<head>
    <title>Registration</title>
</head>
<body>
<h2>Registration</h2>
    <form action="save_user.php" method="post">
    <!-- save_user.php - is a handler (method "post" sends data from the fields to the page save_user.php) -->
        <p>
            <label>Login:<br></label>
            <input name="login" type="text" size="15" maxlength="15">
        </p>
        <p>
            <label>Password:<br></label>
            <input name="password" type="password" size="15" maxlength="15">
        </p>
        <p>
            <input type="submit" name="submit" value="Registration">
        </p>
    </form>
</body>
</html>