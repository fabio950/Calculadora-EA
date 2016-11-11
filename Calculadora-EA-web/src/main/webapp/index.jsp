<%-- 
    Document   : index
    Created on : 07-nov-2016, 9:13:29
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Calculando áreas</h1>
        <form action="AreaServlet?area=circulo" method="post">
            <fieldset>
                <legend>Área del circulo</legend>
                Radio: <input type="text" name="radio" value="${param.radio}" />
                <input type="submit" value="Calcular"/>
            </fieldset>
        </form>
        <form action="AreaServlet?area=cuadrado" method="post">
            <fieldset>
                <legend>Área del cuadrado</legend>
                Lado: <input type="text" name="lado" value="${param.lado}" />
                <input type="submit" value="Calcular"/>
            </fieldset>
        </form>
        <form action="AreaServlet?area=triangulo" method="post">
            <fieldset>
                <legend>Área del triangulo</legend>
                Altura: <input type="text" name="altura" value="${param.altura}" />
                Base: <input type="text" name="base" value="${param.base}" />
                <input type="submit" value="Calcular"/>
            </fieldset>
        </form>
        <form action="AreaServlet?area=trapecio" method="post">
            <fieldset>
                <legend>Área del trapecio</legend>
                Altura: <input type="text" name="altura" value="${param.altura}" />
                Base 1: <input type="text" name="base1" value="${param.base1}" />
                Base 2: <input type="text" name="base2" value="${param.base2}" />
                <input type="submit" value="Calcular"/>
            </fieldset>
        </form>
    </body>
</html>