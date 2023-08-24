<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page  import="controller.HelloWorldController" %>
    <%@ page  import="model.HelloWorld" %>
    <%@ page  import="persistence.*" %>
    
<!DOCTYPE html>
<html>

<% 
	DaoHelloWorld daoHelloWorld = new DaoHelloWorld();
	String frase = daoHelloWorld.buscarFrases();

%>
<head>
<meta charset="ISO-8859-1">
<title>Barra de Navegação</title>
</head>

<body>
	  <style>
       ul.navbar {
            list-style-type: none;
            margin: 0;
            padding: 0;
            background-color: #007bff;
            overflow: hidden;
        }

        ul.navbar li {
            float: left;
        }

        ul.navbar li a {
            display: block;
            color: black; 
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        ul.navbar li a:hover {
            background-color: #e0e0e0; 
        }
    </style>
</body>
<% 
		
%>

    <ul class="navbar">
        <li><a href="#">Pagina Inicial</a></li>
 				
	</ul>
	
	
 
		<p>A frase é: , <%=frase %>!</p>
	
	
	
</html>