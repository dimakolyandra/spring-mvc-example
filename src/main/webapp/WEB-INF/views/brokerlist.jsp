<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/table.css"/>"/>

<title>choose-broker</title>
</head>
<body>
	<p class="greeting"> Выберите брокера, с которым хотите сотрудничать </p>
	<div class="wrapp">
    <div class="imagesBox">
        <form:form action="enter-into-contract" method="POST" commandName="chosenBroker">
        	<img src="https://upload.wikimedia.org/wikipedia/ru/f/fb/Tks-bank-logo.png">
        </form:form>
    </div>
    <div class="imagesBox">
        <img src="http://fx-binar.ru/wp-content/uploads/2017/10/2-4.png">
    </div> 
    <div class="imagesBox">
        <img src="http://coolstuff.com.ua/image/data/alfabank.png">
    </div>
</div>
</body>
</html>