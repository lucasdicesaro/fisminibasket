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

<html:html locale="true">
	<head>
		<title>MiniBasket Administrador</title>
		<html:base />
	</head>
	<body bgcolor="white">
	    ABMs <BR />
		<a href="/MB/aviso.do?action=listAll">Aviso</a> <BR />
		<a href="/MB/categoria.do?action=listAll">Categoria</a> <BR />
		<a href="/MB/club.do?action=listAll">Club</a> <BR />
		<a href="/MB/federacion.do?action=listAll">Federacion</a> <BR />
		<a href="/MB/fichamedica.do?action=listAll">Ficha Medica</a> <BR />
		<a href="/MB/jugador.do?action=listAll">Jugador</a> <BR />
		<a href="/MB/medico.do?action=listAll">Medico</a> <BR />
		<a href="/MB/permiso.do?action=listAll">Permiso</a> <BR />
		<a href="/MB/rol.do?action=listAll">Rol</a> <BR />
		<a href="/MB/rolpermiso.do?action=listAll">Rol-Permiso</a> <BR />
		<a href="/MB/usuario.do?action=listAll">Usuario</a> <BR />

	    Reportes <BR />
		<a href="/MB/today.do?action=listAvisosFaltantes">Today Avisos Faltantes</a> <BR />
		<a href="/MB/today.do?action=listFichasMedicas">Today Fichas Medicas</a> <BR />

		Falta<BR />
		 - Darle estilo (diseño)<BR />
	</body>
</html:html>
