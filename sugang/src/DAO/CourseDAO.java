package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DBPKG.DBConnection;
import VO.CourseVO;
import VO.lecturerVO;

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
	
	public ArrayList<lecturerVO> getLecutrer() {
		ArrayList<lecturerVO> list = new ArrayList<lecturerVO>();
		
		try {
			conn = DBConnection.getConnection();
			sql = "select idx, name from lecturer_tbl";
			stmt = conn.prepareStatement(sql);
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				lecturerVO vo = new lecturerVO();
				
				vo.setIdx(rs.getInt(1));
				vo.setName(rs.getString(2));
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public int AddCourse(CourseVO vo) {
		int cnt = 0;
		try {
			conn = DBConnection.getConnection();
			
			// sql = "insert into course_tbl values ('10001', '프로그래밍', 2, 1, 1, '0900', '1100')"
			sql = "insert into course_tbl values (?, ?, ?, ?, ?, ?, ?)";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getName());
			stmt.setInt(3, vo.getCredit());
			stmt.setString(4, vo.getLecturer());
			stmt.setInt(5, vo.getWeek());
			stmt.setInt(6, vo.getStart_hour());
			stmt.setInt(7, vo.getEnd_end());
			
			cnt = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
	public CourseVO getCourseById(String id) {
		CourseVO vo = new CourseVO();
		
		try {
			conn = DBConnection.getConnection();
			
			sql = "select * from course_tbl where id = ?";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, id);
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				vo.setId(rs.getString(1));
				vo.setName(rs.getString(2));
				vo.setCredit(rs.getInt(3));
				vo.setLecturer(rs.getString(4));
				vo.setWeek(rs.getInt(5));
				vo.setStart_hour(rs.getInt(6));
				vo.setEnd_end(rs.getInt(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return vo;
	}
	
	public void updateCourse(CourseVO vo) {
		try {
			conn = DBConnection.getConnection();
			
			sql = "update COURSE_TBL set name = ?, credit = ?, lecturer = ?, week = ?, start_hour = ?, end_end = ? where id = ?";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, vo.getName());
			stmt.setInt(2, vo.getCredit());
			stmt.setString(3, vo.getLecturer());
			stmt.setInt(4, vo.getWeek());
			stmt.setInt(5, vo.getStart_hour());
			stmt.setInt(6, vo.getEnd_end());
			stmt.setString(7, vo.getId());
			
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteCourse(String id) {
		try {
			conn = DBConnection.getConnection();
			
			sql = "delete from COURSE_TBL where id = ?";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, id);
			
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
