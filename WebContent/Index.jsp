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
    <title>Home - LDXPC</title>
    
    <!--<link href="~/Content/bootstrap.min.css" rel="stylesheet" type="text/css" />-->
    <link href="css/site.css" rel="stylesheet" type="text/css" />
    <script src="script/script.js"></script>
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
    
</head>
<body>
    
    <header>
        
        <nav>
            <a href="#home"><img src="" /></a>
            <ul class="menu">
                <li class="active"><a href="Index.jsp">Home</a></li>
                <li><a href="view/criaVendedor.jsp">Criar Vendedor</a></li>
                <li><a href="view/criaCliente.jsp">Criar Cliente</a></li>
            </ul>
        </nav>
    </header>

    <section>
        <div>
        	<h1>Vendedores</h1>
	        <%ArrayList<Vendedores> vendedores = DBvendedores.pegarVendedores(); %>
	       	<%for(Vendedores v : vendedores){ %>
	        	<div>
	        		<p>
	        			<a href="Index.jsp?vendedor=<%=v.getCdvend()%>" ><%=v.getDsnome() %></a>
	        			<a href="view/criaVendedor.jsp?editar=<%=v.getCdvend()%>">Editar</a>
	        		</p>
	        	</div>
	       	<%}%>
       	</div>
       	
       	<%if(request.getParameter("vendedor")!=null){ %>
       		<div>
       			<h1>Clientes</h1>
		        <%ArrayList<Clientes> clientes = DBclientes.pegarClientes(request.getParameter("vendedor")); %>
		       	<%for(Clientes c : clientes){ %>
		        	<div>
		        		<p>
		        			<%=c.getDsnome() %>
		        			<a href="view/criaCliente.jsp?editar=<%=c.getCdcl()%>">Editar</a>
		        		</p>
		        	</div>
		       	<%}%>
       		</div>
        <%} %>
        
    </section>

    
    <!--<script src="~/Scripts/bootstrap.min.js"></script>-->
</body>
</html>