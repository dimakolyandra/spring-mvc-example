<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/table.css"/>"/>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js" ></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<title>choose-broker</title>
</head>
<body>

<div class="container-fluid">
  <p class="greeting"> Выберите брокера, с которым хотите сотрудничать </p>
  <div id="jsaAboutCarousel" class="carousel slide" data-ride="carousel" data-interval="false">
    <div class="carousel-inner">

      <div class="item active">
        <form:form id="subm" method="GET" action="finish-registration">
        		<input type="image" src="${firmList.get(0).getAvatarFirmUrl()}" name="id" value="${firmList.get(0).getId()}"/>
        </form:form>
      </div>
      
	<c:forEach var="broker" items="${firmList.subList(1, firmList.size())}" varStatus="loopStatus">
      <div class="item">
        <form:form id="subm" method="GET" action="finish-registration">
        		<input type="image" src="${broker.getAvatarFirmUrl()}" name="id" value="${broker.getId()}"/>
        </form:form>
      </div>
	</c:forEach>
    </div>
	
    <!-- Left and right controls -->
    <a class="left carousel-control" href="#jsaAboutCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#jsaAboutCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
 </div>
</body>
</html>