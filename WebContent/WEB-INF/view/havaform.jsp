<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>	

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.error { color:red;
		font-weight:bold;
		text-size:12px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hava Durumu</title>
</head>
<body>

<form:form action="getCity" modelAttribute="weather">
Şehir adı giriniz :
<br />
 <form:input type="text" path="city" />
<br />
<form:errors path="city" cssClass="error" />


<br /> <br />

<input type="submit" value="Gonder" />
</form:form>

</body>
</html>