<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center><h1>Sentence Analysis using Tokenize and FindPersonName NLP Methods</h1></center>
<br><br><br>
<h3>Please enter the sentence:</h3>
<%
String sentence1=(String)request.getAttribute("sentence1");
String token[]=(String[])request.getAttribute("token");
String name[]=(String[])request.getAttribute("names");
%>
<form method="post" action="MainController">
<input type="text" name="sentence" id="sentence" value=<%=sentence1%>></input>
<input id="submit" type="submit"  value="Submit">
</form>
<br><br><br>
<h3>Tokens obtained using Tokenize method:
<br><% for(int i=0;i<token.length;i++)
	{
	%>
	${token[i]}<br>
	<% 	}%>
<br><br><br>
<h3>Names obtained using findPersonName method:
<br><% for(int i=0;i<name.length;i++)
	{
	%>
	${name[i]}<br>
	<% 	}%>

</body>
</html>