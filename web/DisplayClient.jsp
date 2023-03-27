<%-- 
    Document   : DisplayClient
    Created on : 16 mars 2023, 22:09:44
    Author     : asus
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Model.Client"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </head>
    <body>
        <% String username = (String) session.getAttribute("username"); %>
        <div class="container">
            <h1>Welcome <%= username %>!</h1>
            <% ArrayList<Client> clients = (ArrayList<Client>)request.getAttribute("clients"); %>
            <table class="table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Salaire</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (Client client : clients) { %>
                    <tr>
                        <td><%= client.getId() %></td>
                        <td><%= client.getNom() %></td>
                        <td><%= client.getTotal() %></td>
                        <td><a href="deleteServlet?id=<%= client.getId() %>" class="btn btn-danger">Supprimer</a></td>
                    </tr>
                    <% } %>
                    <tr>
                        <form action="AddServlet" method="post">
                            <td></td>
                            <td><input type="text" id="nom" name="nom" class="form-control" placeholder="Nom"></td>
                            <td><input type="text" id="total" name="total" class="form-control" placeholder="Total"></td>
                            <td><input type="submit" value="Ajouter" class="btn btn-primary"></td>
                        </form>
                    </tr>
                </tbody>
            </table>
        </div>
    </body>
</html>
