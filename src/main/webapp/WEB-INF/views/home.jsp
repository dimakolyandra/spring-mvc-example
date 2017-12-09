<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/home.css"/>"/>
<title>Home</title>
</head>

<body>
		<p class="greeting"> Пожалуйста, войдите в систему </p> 
		<form:form class="form" action="enter-system" method="POST" commandName="user">
    		<p class="name"> 
        		<form:input type="text" path="name" placeholder="Ваш логин" /> 
        		<label>Name</label> 
    		</p>
   
    		<p class="email"> 
        		<form:input path="email" placeholder="Ваш пароль" type="password"/> 
        		<label>Password</label> 
    		</p> 
  
    		<p class="submit"> 
        		<input type="submit" value="Войти"/> 
  	  		</p> 	
		</form:form>
		
		<form:form action="registration" method="GET">
			<p class="submit">
				<input type="submit" value="Регистрация"/>
			</p> 
		</form:form>
		
</body>
</html>
