<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<table>
    <h1>Your profile:</h1>
    <tr>
        <td>${user.getFirstName()}</td>
    </tr>
    <tr>
        <td>${user.getLastName()}</td>
    </tr>
    <tr>
        <td>${user.username}</td>
    </tr>
</table>
</body>
</html>
