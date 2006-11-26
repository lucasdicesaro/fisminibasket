<%
	Integer usuario = (Integer)session.getAttribute("usuario");
	if(usuario == null)
	{
		request.getRequestDispatcher("/log/login.jsp").forward(request, response);
	}
%>