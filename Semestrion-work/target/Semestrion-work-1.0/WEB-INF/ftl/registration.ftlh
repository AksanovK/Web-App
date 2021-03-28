<!doctype html>
<html lang="en">
<#import "spring.ftl" as spring>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Registration</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<h2><a href="?lang=ru">РУ</a></h2>
<h2><a href="?lang=en">EN</a></h2>
<h1><@spring.message 'sign_up_page.registration.title'/></h1>
<@spring.bind "userReg"/>
<@spring.showErrors '*', 'errors' />
<form method="post" action="/registration">
    <label><@spring.message 'sign_up_page.registration.firstName'/></label>
    <#--<input type="text" name="firstName">-->
    <@spring.formInput "userReg.firstName"/>
    <@spring.showErrors "<br>" "error"/>

    <label><@spring.message 'sign_up_page.registration.lastName'/></label>
    <#--<input type="text" name="lastName">-->
    <@spring.formInput "userReg.lastName"/>
    <@spring.showErrors "<br>" "error"/>

    <label><@spring.message 'sign_up_page.registration.email'/></label>
    <#--<input type="text" name="email">-->
    <@spring.formInput "userReg.email"/>
    <@spring.showErrors "<br>" "error"/>

    <label><@spring.message 'sign_up_page.registration.password'/></label>
    <#--<input type="text" name="password">-->
    <@spring.formPasswordInput "userReg.password"/>
    <@spring.showErrors "<br>" "error"/>

    <input type="submit" value="Add">
</form>
</body>
</html>