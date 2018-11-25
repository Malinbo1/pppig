<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	if ('${result}' != '') {
    if ('${result}' == 1)
        alert('提交成功！')
        location.href="/list";
    if ('${result}' == 2) {
    	alert('余额不足,请充值！')
    	}
    if ('${result}' == 3) {
    	alert('剩余可投金额不足！')
    	}
	}
</script>
<body>
	<center>
		<h3>提交订单</h3>
		<form action="/addOrder" method="post">
			<input type="hidden" name="gid" value="${good.gid }">
			订单号:<input type="text" readonly="true" name="oid" value="${requestScope.oid }"><br/>
			标的名称:<input type="text" readonly="true" name="gname" value="${good.gname }"><br/>
			借款金额:<input type="text" readonly="true" name="allmoney" value="${good.allmoney }"><br/>
			可投金额:<input type="text" readonly="true" name="gmoney" value="${good.gmoney }"><br/>
			输入金额:<input type="text" name="omoney"><br/>
			<input type="submit" value="即刻投标">
		</form>
	</center>
</body>
</html>