<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="/js/jquery-1.8.2.min.js"></script>
<link href=/css/css.css rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
<center>
<table>
  <tr>
    <td>
    	<form action="selList" method="post">
    		<input type="text" name="sname" value="${store.sname}">
    		<input type="submit" value="查询">
    	</form>
    </td>
  </tr>
</table>
<table border="1">
  <tr>
    <th>
    	<input type="checkbox" onclick="selAll(this.checked)">
    </th>
    <th>编号</th>
    <th>店铺名称</th>
    <th>创建日期</th>
    <th>销货商品</th>
    <th>
    	操作
    </th>
  </tr>
  <c:forEach items="${pg.list}" var="store">
  <tr>
    <td>
    	<input type="checkbox" value="${store.sid}" class="ck">
    </td>
    <td>${store.sid}</td>
    <td>${store.sname}</td>
    <td>${store.datea}</td>
    <td>
    	<c:forEach items="${store.goodes}" var="g">
    		${g.gname}
    	</c:forEach>
    </td>
    <td>
    	<a href="getGoodsBySid?sid=${store.sid}" target="_blank"> <input type="button" value="详情"> </a>
    </td>
  </tr>
  </c:forEach>
</table>
<form action="selList" method="post">
	<button name="pageNum" value="1">首页</button>
	<button name="pageNum" value="${pg.prePage==0?1:pg.prePage}">上一页</button>
	当前${pg.pageNum}页/共${pg.pages}页
	<button name="pageNum" value="${pg.nextPage==0?pg.pages:pg.nextPage}">下一页</button>
	<button name="pageNum" value="${pg.pages}">尾页</button>
</form>
	<a href="toAdd"> <input type="button" value="添加"> </a>
	 <input type="button" value="批量删除" onclick="delMore()">
</center>
</body>
<script type="text/javascript">

	// 全选/全不选
	function selAll(flag) {
		$(".ck").attr("checked",flag);
	}

	// 批删
	function delMore() {
		var sids = [];
		$(".ck:checked").each(function () {
			sids.push($(this).val());
		});
		if(sids.length > 0){
			if(confirm("确认要删除吗?")){
				alert("删除成功!");
				location.href="delMore?sids="+sids;
			}
		}else{
			alert("请至少选择一条数据!");
		}
	}
</script>
</html>