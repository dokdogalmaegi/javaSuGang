<%@page import="java.util.ArrayList"%>
<%@page import="VO.CourseVO"%>
<%@page import="DAO.CourseDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	* { margin : 0; padding : 0; }
	#mainPage { margin : 0 auto; width : 1000px; height : 800px; padding : 15px; border: 1px solid black;  }
	#main { height : 630px; border : 1px solid black; margin : 15px 0; padding: 10px; }
	table { border : 1px solid black; width : 100%; height : 80% }
	input { width : 100%; }
	#headerTable { background : #fbceb1; }
	td { border : 1px solid black; }
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
				String weekArr[] = {"월", "화", "수", "목", "금", "토"};
				int cnt = dao.getCourse();
				ArrayList<CourseVO> list = dao.getCourselist();
			%>
			<h3>총 <%=cnt %>개의 교과목이 있습니다.</h3>
			<section>
				<table>
					<tr id="headerTable">
						<th>과목코드</th>
						<th>과목명</th>
						<th>학점</th>
						<th>담당강사</th>
						<th>요일</th>
						<th>시작시간</th>
						<th>종료시간</th>
						<th>관리</th>					
					</tr>
					<%
						for(CourseVO vo : list) {
					%>
					<tr>
						<td><%=vo.getId() %></td>
						<td><%=vo.getName() %></td>
						<td><%=vo.getCredit() %></td>
						<td><%=vo.getL_name() %></td>
						<td><%=weekArr[(vo.getWeek() - 1)] %></td>
						<td><%=vo.getStart_hour() %></td>
						<td><%=vo.getEnd_end() %></td>
						<td><a href="updateGyoCtrl?id=<%=vo.getId() %>">수정</a> / <a href="deleteGyoCtrl?id=<%=vo.getId() %>">삭제</a></td>			
					</tr>
					<% } %>
				</table>
				<button style="float : right;" onclick="location.href = 'AddController'">
					작성
				</button>
			</section>
			
		</div>
		
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>
