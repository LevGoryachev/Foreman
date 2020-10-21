<!DOCTYPE html>

<head>
     <title>Login</title>
</head>
<body>
<h2>Sign in</h2>
    <form action="check_user.php" method="post">
        <!-- check_user.php - is a handler (method "post" sends data from the fields to the page check_user.php) -->
        <p>
            <label>Enter your Login:<br></label>
            <input name="login" type="text" size="15" maxlength="15">
        </p>
        <p>
            <label>Enter your Password:<br></label>
            <input name="password" type="password" size="15" maxlength="15">
        </p>
        <p>
            <input type="submit" name="submit" value="Sign in">
        </p>
    </form>
</body>
</html>