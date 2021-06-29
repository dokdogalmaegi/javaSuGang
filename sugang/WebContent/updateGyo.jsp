<%@page import="VO.lecturerVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="VO.CourseVO"%>
<%@page import="DAO.CourseDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 내용 가져오기
	CourseVO vo = (CourseVO) request.getAttribute("course");
	
	// 교수 이름 가져오기
	ArrayList<lecturerVO> list = (ArrayList<lecturerVO>) request.getAttribute("list");
	
	String weekArr[] = {"월", "화", "수", "목", "금", "토"};
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	* { margin : 0; padding : 0; }
	#mainPage { margin : 0 auto; width : 1000px; height : 800px; padding : 15px; border: 1px solid black;  }
	#main { height : 630px; border : 1px solid black; margin : 15px 0; padding: 10px; text-align : center; }
	#main h2 { text-align : center; }
	table { border : 1px solid black; width : 100%; height : 80%  }
	
	#headerTable { background : #fbceb1; }
	td { border : 1px solid black; }
</style>
<title>Insert title here</title>
</head>
<body>
	<div id="mainPage">
		<jsp:include page="header.jsp"></jsp:include>
		
		<div id="main">
			<h2>교과목 추가</h2>
			<form action="updateGyoCtrl" method="post">
			<table>
				<tr>
					<td>교과목 코드</td>
					<td><input type="text" name="id" value="<%=vo.getId() %>"/></td>
				</tr>
				<tr>
					<td>과목명</td>
					<td><input type="text" name="name" value="<%=vo.getName() %>"/></td>
				</tr>
				<tr>
					<td>담당강사</td>
					<td>
						<select name="lecturer">
							<%
								for (lecturerVO vo1 : list) {
							%>
							<%if(vo.getLecturer().equals(String.valueOf(vo1.getIdx()))) { %>
							<option value="<%=vo1.getIdx()%>" selected="selected"><%=vo1.getName() %></option>
							<% }else { %>
							<option value="<%=vo1.getIdx()%>"><%=vo1.getName() %></option>
							<% } %>
							<% } %>
						</select>
					</td>
				</tr>		
				<tr>
					<td>학점</td>
					<td><input type="text" name="credit" value="<%=vo.getCredit() %>"/></td>
				</tr>
				<tr>
					<td>요일</td>
					<td>
						<% for(int i = 1; i <= 6; i++) { %>
							<label for="<%=i %>"><%=weekArr[i-1] %></label>
							<% if(vo.getWeek() == i) { %> 
							<input type="radio" name="week" id="mon" value="<%=i %>" checked="checked"/>
							<% }else { %>
							<input type="radio" name="week" id="mon" value="<%=i %>"/>							
							<% } %>	
						<% } %>
					</td>
				</tr>	
				<tr>
					<td>시작</td>
					<td><input type="text" name="start_hour" value="<%=vo.getStart_hour() %>"/></td>
				</tr>
				<tr>
					<td>종료</td>
					<td><input type="text" name="end_end" value="<%=vo.getEnd_end() %>"/></td>
				</tr>
				<tr>
					<td><a href="index.jsp">목록</a></td>
					<td><button type="submit">완료</button></td>
				</tr>
			</table>
			</form>
		</div>
		
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>
