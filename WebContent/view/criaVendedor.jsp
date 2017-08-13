<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.*"%>
<%@page import="database.*" %>
<%@page import="java.util.ArrayList" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CriaVendedor - LDXPC</title>
    
    <!--<link href="~/Content/bootstrap.min.css" rel="stylesheet" type="text/css" />-->
    <link href="../css/site.css" rel="stylesheet" type="text/css" />
    <script src="../js/script.js"></script>
    <link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="../bootstrap/js/bootstrap.min.js"></script>
    
</head>
<body>
    
    <header>
        
        <nav>
            <a href="#home"><img src="../imagem/logo.png" /></a>
            <ul class="menu">
                <li><a href="../Index.jsp">Home</a></li>
                <li class="active"><a href="criaVendedor.jsp">Criar Vendedor</a></li>
                <li><a href="criaCliente.jsp">Criar Cliente</a></li>
            </ul>
        </nav>
    </header>

    <section class="container">
    	<%if(request.getParameter("editar") == null) {%>
	    	<h1>Cadastrar Vendedor</h1>
	        <form class="form" action="../VendedoresControle" method="POST">
	        	<p>Nome: <input class="form-control" type="text" name="dsnome"> </p>
	        	<p>Cód. tab:<input class="form-control" type="text" name="cdtab"> </p>
	        	<p>Data Nascimento: <input class="form-control" type="text" name="dtnasc"></p>
	        	<button class="btn btn-default" type="submit">Enviar</button>
	        </form>
	        
	        
	    <%}else{%>
	    	<h1>Editar Vendedor</h1>
	    	
	    	<% Vendedores v = DBvendedores.pegarVendedor(request.getParameter("editar"));%>
	        <form class="form" action="../VendedoresControle" method="POST">
	        	<input type="hidden" name="update" value="<%=v.getCdvend() %>">
	        	<p>Nome: <input class="form-control" class="form-control" type="text" name="dsnome" value="<%=v.getDsnome() %>"> </p>
	        	<p>Cód. tab:<input class="form-control" type="text" name="cdtab" value="<%=v.getCdtab() %>"> </p>
	        	<p>Data Nascimento: <input class="form-control" type="text" name="dtnasc" value="<%=v.getDtnasc() %>"></p>
	        	<p>Clientes:</p>
	        	<%ArrayList<Clientes> clientes = DBclientes.pegarClientes(); %>
	        	<div>
	        		<%for(Clientes c : clientes){ %>
	        			<div class="list-group" id="left-<%=c.getCdcl()%>">
	        				<a class="list-group-item" href="#" onclick="addCliente('<%=c.getCdcl()%>')"> + <%=c.getDsnome() %></a>
	        			</div>
	        		<%}%>
	        	</div>

	        	<div>
	        		<%for(Clientes c : clientes){ %>
	        			<div id="right-<%=c.getCdcl()%>" style="display:none;">
	        				<a href="#" onclick="removeCliente('<%=c.getCdcl()%>')"> - <%=c.getDsnome() %></a>
	        			</div>
	        		<%}%>
	        	</div>
	        	<button class="btn btn-default" type="submit">Enviar</button>
	        </form>
	        <form action="../VendedoresControle" method="POST">
	        	<input type="hidden" name="excluir" value="<%=v.getCdvend()%>" > 
	        	<button class="btn btn-default" type="submit">Excluir</button>
	        </form>
	    <%} %>
    </section>
    <footer class="container">
    	<hr>
    	Arthur Fernandes Ribeiro - 2017
    </footer>

    
    <!--<script src="~/Scripts/bootstrap.min.js"></script>-->
</body>
</html>