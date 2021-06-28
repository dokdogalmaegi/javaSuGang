package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DBPKG.DBConnection;
import VO.CourseVO;

public class CourseDAO {
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	String sql;
	
	// 몇개의 과목이 있는지 가져오기
	public int getCourse() throws Exception {
		// DB에서 과목수 가져오기
		int result = 0;
		
		conn = DBConnection.getConnection();
		
		sql = "select count(*) from course_tbl";
		stmt = conn.prepareStatement(sql);
		
		rs = stmt.executeQuery();
		
		if(rs.next()) result = rs.getInt(1);
		
		return result;
	}
	
	public ArrayList<CourseVO> getCourselist() {
		ArrayList<CourseVO> list = new ArrayList<CourseVO>();
		
		try {
			conn = DBConnection.getConnection();
			sql = "select c.*, l.name from course_tbl c, lecturer_tbl l where c.lecturer = l.idx";
			
			stmt = conn.prepareStatement(sql);
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				CourseVO vo = new CourseVO();
				
				vo.setId(rs.getString(1));
				vo.setName(rs.getString(2));
				vo.setCredit(rs.getInt(3));
				vo.setL_name(rs.getString(8));
				vo.setWeek(rs.getInt(5));
				vo.setStart_hour(rs.getInt(6));
				vo.setEnd_end(rs.getInt(7));
				
				list.add(vo);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
}
