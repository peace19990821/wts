<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fm" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript" src="/js/jquery-1.8.2.min.js"></script>
<link href=/css/css.css rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
<center>
<h3>详情页面</h3>
<fm:form action="add" method="post" modelAttribute="store">
		<fm:hidden path="sid"/>
	店铺名称:<fm:input path="sname"/><br><br>
	创建日期:<fm:input path="datea"/><br><br>
	销售商品:<c:forEach items="${store.goodes}" var="g">
			${g.gname}
		</c:forEach><br><br>
	<a href="selList"> <input type="button" value="关闭"> </a>
</fm:form>
</center>
</body>
</html>