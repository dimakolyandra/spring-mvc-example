<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/input.css"/>"/>
<title>Home</title>
</head>

<body>
    <p class="greeting"> Пожалуйста, войдите в систему </p>
        <form:form id="enter" class="form" action="enter-system" method="POST" commandName="user">
            
            <p class="login">
                <form:input class="user_data" type="text" path="login" placeholder="Ваш логин" />
            </p>

            <p class="pass">
                <form:input class="user_data" type="password" path="password" placeholder="Ваш пароль"/>
            </p>
            
            <p class="submit">
				<input class="enter" type="submit" value="Войти"/>
			</p>
		</form:form>
		
		<form:form action="registration" method="GET">
    		<p class="submit">
    	      <input class="registration" type="submit" value="Регистрация">
        	</p>
        </form:form>
        

		
</body>
</html>