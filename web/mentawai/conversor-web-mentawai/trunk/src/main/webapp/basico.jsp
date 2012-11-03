<%@taglib prefix="mtw" uri="http://www.mentaframework.org/tags-mtw/"%>
<html>
<head>
	<title>Conversor Web Mentawai</title>
	<link type="text/css" rel="stylesheet" href="styles/conversor.css" />
</head>
<body>

<div id="title">Conversor Millas a Km: BASICO</div>

	<mtw:form action="ConversorBasicoAction.convertir.mtw" method="post">
	
 	<div class="row">
 		<label class="col1">Millas:&nbsp;&nbsp;</label>
 		<span class="col2">
 			<mtw:input type="text" name="millas" size="30" maxlength="30" />
 		</span>
	</div>
	
	<div class="row">
 		<label class="col1">Km:&nbsp;&nbsp;</label>
 		<span class="col2">
			<b><mtw:out value="kilometros" /></b>
		</span>
	</div>
	
	<div align="center" class="submit"><input type="submit" value="Convertir" alt="send" width="52" height="19" border="0" />
	</div>

	</mtw:form>
	
</div>
 
</body>
</html>