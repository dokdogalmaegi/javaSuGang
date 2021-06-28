package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CourseDAO;
import VO.CourseVO;
import VO.lecturerVO;

/**
 * Servlet implementation class AddController
 */
@WebServlet("/AddController")
public class AddController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// DB에서 강사이름을 가져오기
		CourseDAO dao = new CourseDAO();
		ArrayList<lecturerVO> list = dao.getLecutrer();
		
		request.setAttribute("list", list);
		
		// 추가화면 열기
		request.getRequestDispatcher("addGyo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CourseDAO dao = new CourseDAO();
		CourseVO vo = new CourseVO();
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int credit = Integer.parseInt(request.getParameter("credit"));
		String lecturer = request.getParameter("lecturer");
		int week = Integer.parseInt(request.getParameter("week"));
		int start_hour = Integer.parseInt(request.getParameter("start_hour"));
		int end_end = Integer.parseInt(request.getParameter("end_end"));
		
		vo.setId(id);
		vo.setName(name);
		vo.setCredit(credit);
		vo.setLecturer(lecturer);
		vo.setWeek(week);
		vo.setStart_hour(start_hour);
		vo.setEnd_end(end_end);
		
		dao.AddCourse(vo);
		
		response.sendRedirect("AddController");
	}

}
