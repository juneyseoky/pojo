package pkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class StaffModify {
	private String position;
//	private int userid;
	private String userid;
	Connection conn = null;
	PreparedStatement pstmt = null;

	public StaffModify(String userid, String position) {
		this.userid = userid;
		this.position = position;
	}

	public void updateStaff() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@//localhost:1521/xe";
			String uid = "manager01";
			String upw = "1234";
			String sql = "";

			conn = DriverManager.getConnection(url, uid, upw);
			
//			sql = "update staff set position = '"+position+"' ";
//			sql+= "where userid = '"+userid+"'";
//			sql = "update staff set position = trim(?) where num = trim(?)";
			sql = "update staff set position = trim(?) where userid = trim(?)";
//			LogPreparedStatement pstmt = new LogPreparedStatement(conn,sql);	
			pstmt = conn.prepareStatement(sql);
//			System.out.println("Query: "+ pstmt.toString());
//			pstmt.setObject(1, position);
//			pstmt.setObject(2, userid);
			pstmt.setString(1, position);
			pstmt.setString(2, userid);
//			System.out.println("\t @@@@@@@@@sQuery@@@@@@@@@  ? " + pstmt.toString() + "\n");
			int rsNum = pstmt.executeUpdate();
			if (rsNum == 1) {
				System.out.println("수정 완료!");
			} else {
				System.out.println("등록 실패");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("JDBC 드라이버를 찾을 수 없습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL 오류 발생.");
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
