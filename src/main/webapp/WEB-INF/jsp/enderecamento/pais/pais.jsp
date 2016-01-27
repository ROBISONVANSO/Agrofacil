<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="titulo.cadastro.pais" /></title>
</head>

<%-- <script type="text/javascript" src="<c:url value='/js/i18n/messages_pt_BR.js'/>"></script> --%>
<!-- <script type="text/javascript"> -->
<!-- // alert ( $ .msg( "you.key.of.propertie.file" ) ) -->
<!-- </script> -->
<body>
	<h1><fmt:message key="titulo.cadastro.pais" /></h1>
	<label><fmt:message key="campo.codigo" /></label>
	<input type="text" id="pais.paisCod" name="pais.paisCod"/>
	<br/>
	<label><fmt:message key="campo.nome"/></label>
	<input type="text" id="pais.paisNome" name="pais.paisNome">
	<br/>
	<label><fmt:message key="campo.sigla" /></label>
	<input type="text" id="pais.sigla" name="pais.sigla"  />
	<br/>
	<label><fmt:message key="campo.sigla_alternativa" /></label>
	<input type="text" id="pais.siglaAlternativa" name="pais.siglaAlternativa" />
	 <br/>
	 <%@include file="/WEB-INF/html/botoes/btnNovo.html" %>
</body>
</html>