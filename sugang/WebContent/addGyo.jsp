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
			<table>
				<tr>
					<td>교과목 코드</td>
					<td><input type="text" name="id"/></td>
				</tr>
				<tr>
					<td>과목명</td>
					<td><input type="text" name="name"/></td>
				</tr>
				<tr>
					<td>담당강사</td>
					<td>
						<select name="l_name">
							<option>김아무개</option>
							<option>이아무개</option>
						</select>
					</td>
				</tr>		
				<tr>
					<td>학점</td>
					<td><input type="text" name="credit"/></td>
				</tr>
				<tr>
					<td>요일</td>
					<td>
						<label for="mon">월</label>
						<input type="radio" name="week" id="mon"/>
						<label for="화">화</label>
						<input type="radio" name="week" id="화"/>
						<label for="수">수</label>
						<input type="radio" name="week" id="수"/>
						<label for="목">목</label>
						<input type="radio" name="week" id="목"/>
						<label for="금">금</label>
						<input type="radio" name="week" id="금"/>
						<label for="토">토</label>
						<input type="radio" name="week" id="토"/>
					</td>
				</tr>	
				<tr>
					<td>시작</td>
					<td><input type="text" name="start_hour"/></td>
				</tr>
				<tr>
					<td>종료</td>
					<td><input type="text" name="end_end"/></td>
				</tr>
				<tr>
					<td><button>목록</button></td>
					<td><button type="submit">완료</button></td>
				</tr>
			</table>
		</div>
		
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>
