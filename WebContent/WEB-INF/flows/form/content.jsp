<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<head>

<script type="text/javascript"> 
function checkField(){ 
	var name = document.hongkiat.name.value;
	var contact = document.hongkiat.contact.value;
    var recipient = document.hongkiat.recipient.value;
    
    if (name.length == 0){
    	  alert("姓名不能为空！");
    	  return false;
   	}
    
    if(!(/^1[3|5｜7｜8][0-9]\d{4,8}$/.test(contact))){ 
        alert("不是完整的11位手机号或者正确的手机号前七位"); 
        document.hongkiat.contact.focus(); 
        return false; 
    } 
    
    if (recipient == "0"){
  	  alert("请选择意向车型！");
  	  return false;
 	}
} 

</script> 
</head>
<div class="main-content">
<section id="container">
	<h2>骏马汽车团购会</h2>
	<div style="text-align:center; margin:20px"><img src="<c:url value="/resources/img/H6.jpg" />" style="vertical-align:middle;" width="100%"></div>
	<sf:form class="form-validation" modelAttribute="participantObj" name="hongkiat" id="hongkiat-form" method="post"  accept-charset="utf-8" onSubmit="return checkField()">
		
		<div id="wrapping" class="clearfix">
			<section id="aligned">
			<sf:input path="name" type="text" name="name" id="name" placeholder="您的姓名" autocomplete="off" tabindex="1" class="txtinput" />
			<sf:input path="contact" type="tel" name="telephone" id="telephone" placeholder="手机号码" tabindex="4" class="txtinput" />
			<sf:select  path="car" id="recipient" name="recipient" tabindex="6" class="selmenu">
					<sf:option value="0">请选择意向车型</sf:option>
					<sf:option value="哈弗 H1">哈弗 H1</sf:option>
					<sf:option value="哈弗 H2">哈弗 H2</sf:option>
					<sf:option value="哈弗 H5">哈弗 H5</sf:option>
					<sf:option value="哈弗 H6">哈弗 H6</sf:option>
					<sf:option value="哈弗 H6 Coupe">哈弗 H6 Coupe</sf:option>
					<sf:option value="哈弗 H8">哈弗 H8</sf:option>
					<sf:option value="哈弗 H9">哈弗 H9</sf:option>
					<sf:option value="长城 M4">长城 M4</sf:option>
					<sf:option value="长城 C50">长城 C50</sf:option>
					
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