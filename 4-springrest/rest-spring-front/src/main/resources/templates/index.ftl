<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Spring rocks the web</title>
</head>
<body>
Spring rocks the web
<#if name??>
<h1>Hola ${name!"yuhu"}</h1>
</#if>
<#if list??>
<ul>
    <#list list as item>
        <li>${item.content!""}</li>
    </#list>
</ul>
</#if>
</body>
</html>