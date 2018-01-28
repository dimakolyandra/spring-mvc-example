<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/input.css"/>"/>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js" ></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<title>Home</title>
</head>

<body>
<div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
  </ol>
    
  <!-- Wrapper for slides -->
  <div class="carousel-inner">
    <div class="item active">
      <img src="resources/images/4.jpg" alt="Удобство работы!">
      <div class="carousel-caption">
        <h3>Удобство работы!</h3>
      </div>
    </div>

    <div class="item">
      <img src="resources/images/2.jpg" alt="Множество партнёров!">
      <div class="carousel-caption">
        <h3>Множество партнёров!</h3>
      </div>
    </div>

    <div class="item">
      <img src="resources/images/3.jpg" alt="Возможность работы с несколькими брокерами!">
      <div class="carousel-caption">
        <h3>Возможность работы с несколькими брокерами!</h3>
      </div>
    </div>
  </div>

  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right"></span>
    <span class="sr-only">Next</span>
  </a>
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
        
        <form:form id="registration" action="registration" method="GET">
            <p class="submit">
              <input class="registration" type="submit" value="Регистрация">
            </p>
        </form:form>
  
</div>
        
</body>
</html>