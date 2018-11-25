<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
你好:${sessionScope.user.username },可用余额:${sessionScope.user.u_yue }<br/>
	<center>
		<c:forEach items="${list }" var="l">
			<font color="red">${l.gname }</font>&nbsp&nbsp&nbsp&nbsp&nbsp 按月付息，到期还本<br/>
			预计年化利率:${l.glilv }%&nbsp&nbsp借款金额:${l.allmoney }<br/>
			借款期限:<font color="green">${l.gmon }个月</font>&nbsp&nbsp可投金额:${l.gmoney }&nbsp&nbsp
			<input type="button" value="立即出借" onclick="document.location='getGood?id=${l.gid}'">
		</c:forEach>
	</center>
</body>
</html>