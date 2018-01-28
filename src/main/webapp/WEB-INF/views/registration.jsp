<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js" ></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/input.css"/>"/>
	<title>Start registration</title>
</head>

<body>

    <div id="myModal" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header"><button class="close" type="button" data-dismiss="modal">×</button>
                    <h4 class="modal-title">Ошибка регистрации</h4>
                </div>
                <div class="modal-body">Такой логин уже существует!</div>
                <div class="modal-footer"><button class="btn btn-default" type="button" data-dismiss="modal">Закрыть</button></div>
            </div>
        </div>
    </div>

	<div>
	<p class="greeting"> Заполните поля для регистрации </p>
	<form:form class="form" action="choose-broker" method="POST" commandName="newUser">
		<p class="login"> 
        		<form:input type="text" id="log" path="login" placeholder="Введите ваш логин" /> 
    			<label>Логин</label>
    	</p>

		<p class="passwd"> 
        		<form:input type="password" id="password" path="password" placeholder="Введите ваш пароль" /> 
    			<label>Пароль</label>
    	</p>

		<p class="name"> 
        		<form:input type="text" id="name" path="firstName" placeholder="Введите ваше имя" /> 
    			<label>Имя</label>
    	</p>
    	<p class="secname"> 
        		<form:input type="text" path="secondName" placeholder="Введите вашу фамилию" /> 
    			<label>Фамилия</label>
    	</p>
    	
    	<p class="bdate"> 
        		<form:input type="date" path="bDate" placeholder="Введите дату рождения" /> 
    			<label>Дата рождения</label>
    	</p>
    	
    	<p class="phone"> 
        		<form:input type="text" path="phone" placeholder="Введите телефон" /> 
    			<label>Моб. телефон</label>
    	</p>
    	
    	<p class="phone"> 
        		<form:input type="text" path="passportData" placeholder="Серия и номер паспорта" /> 
    			<label>Пасспортные данные</label>
    	</p>
    	 
    	<p class="submit">
    		<input type="button" value="Далее" onclick="validate_form(this.form)">
    	</p>
	
	</form:form> 
	</div>
    	<script type="text/javascript">
    	     $(document).ready(function(){ 
        	     if (!${isFirst}) {
            	     $('#myModal').modal('show');}
        	     })
    	     
	       
			function validate_form(form)
			{
				var submit = true;
				var inputs = form.querySelectorAll('input:not([type="button"])');
				for (var i = 0; i < inputs.length; i++){
					if (inputs[i].value == ""){ 
						inputs[i].style.borderColor = "red";
						inputs[i].setAttribute("placeholder", "Неправильный ввод");
						submit = false;
					}
					else{
						inputs[i].style.borderColor = "black";
					}				
				}
				if (submit){
					form.submit();
				}
			}
		</script>
</body>
</html>