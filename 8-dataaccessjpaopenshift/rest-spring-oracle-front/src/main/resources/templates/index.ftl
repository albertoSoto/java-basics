<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Spring rocks the web</title>
</head>
<body>
Spring rocks the web
<div>
<#if restaurantes??>
    <ul>
        <#list restaurantes as item>
            <li>${item.nom!""}</li>
        </#list>
    </ul>
</#if>
</div>
</body>
</html>