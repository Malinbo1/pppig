<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h3>提交订单</h3>
		<form action="/addOrder" method="post">
			<input type="hidden" name="gid" value="${good.gid }">
			订单号:<input type="text" readonly="true"name="oid" value="${order.oid }"><br/>
			标的编号:<input type="text" readonly="true" name="gname" value="${order.gid }"><br/>
			标的总金额:<input type="text" readonly="true" name="all_money" value="${order.all_money }"><br/>
			投标金额:<input type="text" name="omoney" value="${order.omoney }"><br/>
			交易密码
			<input type="submit" value="即刻投标">
		</form>
</body>
</html>