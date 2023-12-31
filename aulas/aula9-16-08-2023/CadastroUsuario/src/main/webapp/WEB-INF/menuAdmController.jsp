
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page  import="model.Usuario" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Barra de Navegacao - JSP</title>
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
</head>
<body>
	<% 
		HttpSession sessao = request.getSession();
		Usuario usuarioLogado = (Usuario) sessao.getAttribute("UsuarioSessao");
	%>

    <ul class="navbar">
        <li><a href="#">Inicio</a></li>
        <li><a href="#">Sobre</a></li>
		
		<% 
			String administrarValor;
			String link;
		%>
		<%
			if(usuarioLogado.getPerfil().equals("ADM")){
				administrarValor = "Administrar";
				link = "cadastroUsuarioController";
			}else{
				administrarValor = "";
				link = "acessoNegado";
				
			}
		%>	
		
			<li><a href="<%= link %>"><%= administrarValor %></a></li>
		
	</ul>
	
	 
		<p>Bem-vindo, <%= usuarioLogado.getUsuario() %>!</p>
	
	
	
</body>
</html>