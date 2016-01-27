<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Teste Aplicação</title>
</head>
<body>
	<h1><fmt:message key="titulo.pagina.teste.aplicacao"/></h1>
	<form action="testeAplicacao/salvar" method="post" >
		<label><fmt:message key="campo.data"/></label>
		<input type="text" id="test.testData" name="test.testData"/>
		<br/>
		<label><fmt:message key="campo.nome"/></label>
		<input type="text" id="test.testNome" name="test.testNome"/>
		<br/>
		<label><fmt:message key="campo.descricao"/></label>
		<textarea id="test.testDescricao" name="test.testDescricao" rows="2" cols="100"></textarea>
		<br/>
		<input type="submit" value="<fmt:message key="btn.salvar"/>"/>
	</form>
</body>
</html>