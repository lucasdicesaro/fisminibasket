<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<%@ page contentType="text/html;charset=ISO-8859-1"%>

<%
    response.setDateHeader("Expires", 0);
    response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Cache-Control", "no-store");
    response.setHeader("Pragma", "no-cache");
%>


<%@ include file="/log/log.inc"%>

<html:html>
	<head>
		<title></title>
		<html:base />
		<link rel="stylesheet" href="css/layout.css" type="text/css" media="screen, print"/>
		<link rel="stylesheet" href="css/menu.css" type="text/css" media="screen, print"/>
	</head>
	<body  align="center" background="images/fondobody.gif" text="#000000" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" >

	<table width="100%" bgcolor="#ffffff" class="homePageBorderTable" height="100%">
		<tr>
		<td background="images/fondomenu.JPG" width="152" valign="top">				
		<table width="100%" cellpadding="0" cellspacing="0">
			<tr>
				<td class="moduloVinieta"><img src="images/vinietamodulo.JPG"/></td>
				<td class="moduloTexto"><a href="" class="moduloTextoLink" >Club</a></td>
			</tr>
			<tr>
				<td class="itemModuloVinieta"><img src="images/vinietaitemmodulo.JPG"/></td>
				<td class="itemModuloTexto"><a href="/MB/club.do?action=listAll" class="itemModuloTextoLink" target="showframe">Club</a></td>
			</tr>
			<tr>
				<td class="itemModuloVinieta"><img src="images/vinietaitemmodulo.JPG"/></td>
				<td class="itemModuloTexto"><a href="/MB/federacion.do?action=listAll" class="itemModuloTextoLink" target="showframe">Federacion</a></td>
			</tr>
			<tr><td colspan="2" height="3" ></td></tr>
		</table>	
		
		<table width="100%" cellpadding="0" cellspacing="0">
			<tr>
				<td class="moduloVinieta"><img src="images/vinietamodulo.JPG"/></td>
				<td class="moduloTexto"><a href="" class="moduloTextoLink">Jugador</a></td>
			</tr>
			<tr>
				<td class="itemModuloVinieta"><img src="images/vinietaitemmodulo.JPG"/></td>
				<td class="itemModuloTexto"><a href="/MB/jugador.do?action=listAll" class="itemModuloTextoLink" target="showframe">Jugador</a></td>
			</tr>
			<tr>
				<td class="itemModuloVinieta"><img src="images/vinietaitemmodulo.JPG"/></td>
				<td class="itemModuloTexto"><a href="/MB/categoria.do?action=listAll" class="itemModuloTextoLink" target="showframe">Categoria</a></td>
			</tr>
			<tr><td colspan="2" height="3" ></td></tr>
		</table>	
		
		<table width="100%" cellpadding="0" cellspacing="0">
			<tr>
				<td class="moduloVinieta"><img src="images/vinietamodulo.JPG"/></td>
				<td class="moduloTexto"><a href="" class="moduloTextoLink">Medico</a></td>
			</tr>
			<tr>
				<td class="itemModuloVinieta"><img src="images/vinietaitemmodulo.JPG"/></td>
				<td class="itemModuloTexto"><a href="/MB/medico.do?action=listAll" class="itemModuloTextoLink" target="showframe">Medico</a></td>
			</tr>
			<tr>
				<td class="itemModuloVinieta"><img src="images/vinietaitemmodulo.JPG"/></td>
				<td class="itemModuloTexto"><a href="/MB/fichamedica.do?action=listAll" class="itemModuloTextoLink" target="showframe">Ficha Medica</a></td>
			</tr>
			<tr>
				<td class="itemModuloVinieta"><img src="images/vinietaitemmodulo.JPG"/></td>
				<td class="itemModuloTexto"><a href="/MB/aviso.do?action=listAll" class="itemModuloTextoLink" target="showframe">Aviso</a></td>
			</tr>
			<tr><td colspan="2" height="3" ></td></tr>
		</table>		
		
		<table width="100%" cellpadding="0" cellspacing="0">
			<tr>
				<td class="moduloVinieta"><img src="images/vinietamodulo.JPG"/></td>
				<td class="moduloTexto"><a href="" class="moduloTextoLink">Configuracion</a></td>
			</tr>
			<tr>
				<td class="itemModuloVinieta"><img src="images/vinietaitemmodulo.JPG"/></td>
				<td class="itemModuloTexto"><a href="/MB/permiso.do?action=listAll" class="itemModuloTextoLink" target="showframe">Permiso</a></td>
			</tr>
			<tr>
				<td class="itemModuloVinieta"><img src="images/vinietaitemmodulo.JPG"/></td>
				<td class="itemModuloTexto"><a href="/MB/rol.do?action=listAll" class="itemModuloTextoLink" target="showframe">Rol</a></td>
			</tr>
			<tr>
				<td class="itemModuloVinieta"><img src="images/vinietaitemmodulo.JPG"/></td>
				<td class="itemModuloTexto"><a href="/MB/usuario.do?action=listAll" class="itemModuloTextoLink" target="showframe">Usuario</a></td>
			</tr>
			<tr><td colspan="2" height="3" ></td></tr>
		</table>

		<table width="100%" cellpadding="0" cellspacing="0">
			<tr>
				<td class="moduloVinieta"><img src="images/vinietamodulo.JPG"/></td>
				<td class="moduloTexto"><a href="" class="moduloTextoLink">Reportes</a></td>
			</tr>
			<tr>
				<td class="itemModuloVinieta"><img src="images/vinietaitemmodulo.JPG"/></td>
				<td class="itemModuloTexto"><a href="/MB/today.do?action=listAvisosFaltantes" class="itemModuloTextoLink" target="showframe">Today Avisos Faltantes</a></td>
			</tr>
			<tr>
				<td class="itemModuloVinieta"><img src="images/vinietaitemmodulo.JPG"/></td>
				<td class="itemModuloTexto"><a href="/MB/today.do?action=listFichasMedicas" class="itemModuloTextoLink" target="showframe">Today Fichas Medicas</a></td>
			</tr>
			<tr><td colspan="2" height="3" ></td></tr>
		</table>

		Falta<BR />
		 1)Drill down en los reportes, 2)Crear un registro por cada operacion en la tabla y asignarlos por roles,
		 3)Completar la validacion de javascript en los jsp, 4)Hacer los css's, 5)Tests
		</td>
		</tr>
	</table>	
		 
	</body>
</html:html>
