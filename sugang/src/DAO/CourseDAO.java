package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DBPKG.DBConnection;

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
}
