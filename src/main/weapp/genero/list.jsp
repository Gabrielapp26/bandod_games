<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Gêneros</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    </head>
    <body>
        <main class="container">
            <h1>Gêneros</h1>
            <a href="/genero/insert" class="btn btn-primary">Novo Gênero</a>
            <hr />
            <table class="table">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Nome</th>
                        <th>&nbsp;</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="g" items="${generos}">
                        <tr>
                            <td>${g.id}</td>
                            <td>${g.nome}</td>
                            <td>
                                <a href="/genero/update/${g.id}" class="btn btn-primary">Editar</a>
                                <a href="/genero/delete/${g.id}" class="btn btn-danger">Remover</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </main>

        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js" integrity="sha384-SR1sx49pcuLnqZUnnPwx6FCym0wLsk5JZuNx2bPPENzswTNFaQU1RDvt3wT4gWFG" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.min.js" integrity="sha384-j0CNLUeiqtyaRmlzUHCPZ+Gy5fQu0dQ6eZ/xAww941Ai1SxSY+0EQqNXNE6DZiVc" crossorigin="anonymous"></script>
    </body>
</html>