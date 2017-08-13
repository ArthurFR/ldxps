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
    <title>CriaCliente - LDXPC</title>
    
    <!--<link href="~/Content/bootstrap.min.css" rel="stylesheet" type="text/css" />-->
    <link href="../css/site.css" rel="stylesheet" type="text/css" />
    <script src="script/script.js"></script>
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
    
</head>
<body>
    
    <header>
        
        <nav>
            <a href="#home"><img src="" /></a>
            <ul class="menu">
                <li><a href="../Index.jsp">Home</a></li>
                <li><a href="criaVendedor.jsp">Criar Vendedor</a></li>
                <li class="active"><a href="criaCliente.jsp">Criar Cliente</a></li>
            </ul>
        </nav>
    </header>

    <section class="container">
    	<%if(request.getParameter("editar") == null) {%>
	        <h1>Cadastrar cliente</h1>
	        <form action="../ClientesControle" method="POST">
	        	<p>Nome: <input class="form-control" type="text" name="nome"> </p>
	        	<p>
	        		Cód. tab:
	        		<select class="form-control" name="tipo">
	        			<option value="PF" selected>PF - Pessoa Física</option>
	        			<option value="PJ">PF - Pessoa Jurídica</option>
	        		</select>
	        		<select class="form-control" name="vendedor">
	        			<%ArrayList<Vendedores> vendedores = DBvendedores.pegarVendedores(); %>
						<option value="NenhumVendedor">
						Nenhum Vendedor
					</option>
	        			<%for(Vendedores v : vendedores){ %>
	        				<option value="<%=v.getCdvend()%>">
        					<%=v.getDsnome() %>
        				</option>
	        			<%}%>
	        		</select>
	        	</p>
	        	<p>Limite de Crédito: <input class="form-control" type="text" name="limite"/></p>
	        	<button class="btn btn-default" type="reset">Limpar</button>
	        	<button class="btn btn-default" type="submit">Cadastrar</button>
	        </form>
		<%}else{%>
			<h1>Editar cliente</h1>
			<% Clientes c = DBclientes.pegarCliente(request.getParameter("editar"));%>
	        <form action="../ClientesControle" method="POST">
	        	<input class="form-control" type="hidden" name="update" value="<%=c.cdcl%>">
	        	<p>Nome: <input class="form-control" type="text" name="nome" value="<%=c.dsnome%>"> </p>
	        	<p>
	        		Cód. tab:
	        		<select class="form-control" name="tipo">
	        			<%if(c.getIdtipo().equals("PF") ) {%>
	        				<option class="form-control" value="PF" selected>PF - Pessoa Física</option>
	        				<option class="form-control" value="PJ">PF - Pessoa Jurídica</option>
	        			<%}else{ %>
	        				<option value="PF">PF - Pessoa Física</option>
	        				<option value="PJ" selected>PF - Pessoa Jurídica</option>
	        			<%} %>
	        		</select>
	        		<select class="form-control" name="vendedor">
	        			<%ArrayList<Vendedores> vendedores = DBvendedores.pegarVendedores(); %>
						<option value="NenhumVendedor">
						Nenhum Vendedor
					</option>
	        			<%for(Vendedores v : vendedores){ 
	        				if(c.getCdvend().equals(v.getCdvend())){%>
	        					<option value="<%=v.getCdvend()%>" selected>
        						<%=v.getDsnome() %>
							<%}else{%>
								<option value="<%=v.getCdvend()%>" >
        						<%=v.getDsnome() %>
							<%}%>
        				</option>
	        			<%}%>
	        		</select>
	        	</p>
	        	<p>Limite de Crédito: <input type="text" name="limite" value="<%=c.getDslim()%>"/></p>
	        	<button class="btn btn-default" type="submit">Cadastrar</button>
	        </form>
	        <form action="../ClientesControle" method="POST">
	        	<input type="hidden" name="excluir" value="<%=c.getCdcl()%>" > 
	        	<button class="btn btn-default" type="submit">Excluir</button>
	        </form>
		<%}%>
	   
    </section>

    
    <!--<script src="~/Scripts/bootstrap.min.js"></script>-->
</body>
</html>