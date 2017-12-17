<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/table.css"/>"/>
<title>Finish registration</title>
</head>

<body>
	<p class="greeting">Завершите регистрацию</p>
	
		<a href="${licence}">Ознакомиться с лицензией брокера</a>
		
		
		<table>
			<caption><label>Вас будет обслуживать</label></caption>
  			<tr>
    			<td> <label>Имя брокера:</label> </td>
        		<td><label> ${worker.getFirstName()}</label></td>
  			</tr>
  			<tr>
  				<td><label>Фамилия брокера:</label>
        		<td><label> ${worker.getSecondName()}</label></td>
  			</tr>
  			<tr>
  				<td><label>Моб. телефон:</label>
  				<td><label>${worker.getPhone()}</label>
  			</tr>
		</table>
		
		<form:form class="form" action="submit-registration" method="GET">
			<input type="submit" class="submit_reg" value="Подтвердить регистрацию">
		</form:form>
		
</body>

</html>