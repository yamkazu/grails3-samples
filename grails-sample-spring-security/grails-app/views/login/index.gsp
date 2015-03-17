<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Login Page</title>
</head>

<body>
<h1>Login:</h1>

<form name="form" action="/login" method="POST">
    <fieldset>
        <input type="text" name="username" value="" placeholder="Username"/>
        <input type="password" name="password" placeholder="Password"/>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </fieldset>
    <input type="submit" id="login" value="Login" class="btn btn-primary"/>
</form>
</body>
</html>
