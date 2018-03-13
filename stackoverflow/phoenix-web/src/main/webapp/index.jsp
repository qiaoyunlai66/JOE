
<%@page contentType="text/html" pageEncoding="windows-1252"
%>
<%--import="com.ph.phoenix.service.system.security.RegistryHelper"--%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
    <link rel="shortcut icon" href="favicon.ico"/>
    <title>JSP Page</title>
</head>
<body>
<%
    response.setStatus(HttpServletResponse.SC_TEMPORARY_REDIRECT);
    String contextRoot = request.getContextPath();
    String loc = contextRoot + "/flex.jsf";
    //if (!RegistryHelper.isRegistered()) {
        loc = contextRoot + "/register.jsf";
    //}
    response.sendRedirect(loc);
%>

</body>
</html>
