<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<head>

<script type="text/javascript" class="init">


function submitForm() {
    document.getElementById("hongkiat-form")._eventId_save.click();
}
    $(document).ready(function() {
		
    	var field = $('.name');
    	if(field.value == ""){
    		field.addClass('form-invalid-data');
    		field.find('.form-invalid-data-info').text('请输入您的姓名');
    	}else{
    		field.addClass('form-valid-data');
    	}
    	
    });

</script>
</head>
<div class="main-content">
<section id="container">
	<h2>Hongkiat Stylish Form Elements</h2>
	<sf:form class="form-validation" modelAttribute="participantObj" name="hongkiat" id="hongkiat-form">
		
		<div id="wrapping" class="clearfix">
			<section id="aligned">
			<input type="text" name="name" id="name" placeholder="Your name" autocomplete="off" tabindex="1" class="txtinput">
		
			<input type="email" name="email" id="email" placeholder="Your e-mail address" autocomplete="off" tabindex="2" class="txtinput">
		
			<input type="url" name="website" id="website" placeholder="Website URL" autocomplete="off" tabindex="3" class="txtinput">
		
			<input type="tel" name="telephone" id="telephone" placeholder="Phone number?(optional)" tabindex="4" class="txtinput">
		
			<textarea name="message" id="message" placeholder="Enter a cool message..." tabindex="5" class="txtblock"></textarea>
			</section>
		</div>


		<section id="buttons">
			<input type="reset" name="reset" id="resetbtn" class="resetbtn" value="Reset">
			<input type="submit" name="submit" id="submitbtn" class="submitbtn" tabindex="7" value="Submit this!">
			<br style="clear:both;">
		</section>
		
		
		<div class="form-title-row">
			<h1>骏马汽车团购会</h1>
		</div>

		<div class="form-row name">

			<label> <span>Full name</span> <sf:input path="name"
					maxlength="10" size="12" />
			</label>

			<!--
                    Add these three elements to every form row. They will be shown by the
                    .form-valid-data and .form-invalid-data classes (see the JS for an example).
                -->

			<span class="form-valid-data-sign"><i class="fa fa-check"></i></span>

			<span class="form-invalid-data-sign"><i class="fa fa-close"></i></span>
			<span class="form-invalid-data-info"></span>

		</div>

		<div class="form-row contact">

			<label> <span>Contact</span> <sf:input path="contact"
					maxlength="10" size="12" />
			</label> <span class="form-valid-data-sign"><i class="fa fa-check"></i></span>

			<span class="form-invalid-data-sign"><i class="fa fa-close"></i></span>
			<span class="form-invalid-data-info"></span>

		</div>

		<div class="form-row">

			<label> <span>Car</span> <sf:select path="car">
					<sf:option value="0">0</sf:option>
					<sf:option value="1">1</sf:option>
					<sf:option value="2">2</sf:option>
				</sf:select>
			</label>

		</div>

		<div class="form-row">
			<input type="submit" name="_eventId_save" value="Submit" />
		</div>

		<input type="hidden" name="_flowExecutionKey"
			value="${flowExecutionKey}" />
	</sf:form>
</section>
</div>