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
	<h2>骏马汽车团购会</h2>
	<sf:form class="form-validation" modelAttribute="participantObj" name="hongkiat" id="hongkiat-form" method="post"  accept-charset="utf-8">
		
		<div id="wrapping" class="clearfix">
			<section id="aligned">
			<sf:input path="name" type="text" name="name" id="name" placeholder="您的姓名" autocomplete="off" tabindex="1" class="txtinput" />
			<sf:input path="contact" type="tel" name="telephone" id="telephone" placeholder="手机号码" tabindex="4" class="txtinput" />
			<sf:select  path="car" id="recipient" name="recipient" tabindex="6" class="selmenu">
					<sf:option value="0">请选择意向车型</sf:option>
					<sf:option value="哈弗 H1">哈弗 H1</sf:option>
					<sf:option value="哈弗 H2">哈弗 H2</sf:option>
					<sf:option value="哈弗 H3">哈弗 H3</sf:option>
			</sf:select>
			</section>
		</div>


		<section id="buttons">
			<input type="submit" name="_eventId_save" id="submitbtn" class="submitbtn" tabindex="7" value="提交表格">
			<br style="clear:both;">
		</section>

		<input type="hidden" name="_flowExecutionKey"
			value="${flowExecutionKey}" />
	</sf:form>
</section>
</div>