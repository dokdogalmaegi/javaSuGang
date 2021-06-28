<%@page import="DAO.CourseDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	#mainPage { margin : 0 auto; width : 1000px; height : 800px; padding : 15px; border: 1px solid black; }
	#main { height : 630px; border : 1px solid black; margin : 15px 0; }
</style>
<title>Insert title here</title>
</head>
<body>
	<div id="mainPage">
		<jsp:include page="header.jsp"></jsp:include>
		
		<div id="main">
			<%
				// 원래는 Controller가 DAO를 불러서 데이터베이스를 처리한다.
				// 여기에서는 직접 DAO를 불러서 처리하도록 할것임.
				CourseDAO dao = new CourseDAO();
				int cnt = dao.getCourse();
			%>
			<h3>총 <%=cnt %>개의 교과목이 있습니다.</h3>
		</div>
		
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>
