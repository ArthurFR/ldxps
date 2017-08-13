<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home - LDXPC</title>
    
    <!--<link href="~/Content/bootstrap.min.css" rel="stylesheet" type="text/css" />-->
    <link href="css/site.css" rel="stylesheet" type="text/css" />
    <script src="script/script.js"></script>
    
</head>
<body>
    
    <header>
        
        <nav>
            <a href="#home"><img src="" /></a>
            <ul class="menu">
                <li class="active">Home</li>
                <li><a href="">Criar Vendedor</a></li>
                <li>Criar Cliente</li>
            </ul>
        </nav>
    </header>

    <section>
        <form>
        	<p>Nome: <input type="text" name="nome"> </p>
        	<p>Cód. tab:<input type="text" name="codTab"> </p>
        	<p>Data Nascimento: <input type="text" name="datNasc"></p>
        	<button type="submit">Enviar</button>
        </form>
    </section>

    
    <!--<script src="~/Scripts/bootstrap.min.js"></script>-->
</body>
</html>