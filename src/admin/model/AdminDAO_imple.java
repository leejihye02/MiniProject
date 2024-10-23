package admin.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import admin.domain.AdminDTO;
import common.ProjectDBConnection;
/*
 * 관리자와 관련된 DB 데이터 접근 클래스
 */
public class AdminDAO_imple implements AdminDAO {
	
	private final Connection conn = ProjectDBConnection.getConn(); // DB Connection 객체
	
	private PreparedStatement pstmt; // 쿼리 실행 객체
	
	private ResultSet rs; // 쿼리 결과를 담을 객체

	/*
	 * 자원 해제
	 */
	private void close() {
		try {
			if (pstmt != null) {
				pstmt.close();
				pstmt = null;
			}

			if (rs != null) {
				rs.close();
				rs = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 관리자 로그인 메소드
	 */
	@Override
	public AdminDTO login(Map<String, String> loginMap) {
		AdminDTO adminDTO = new AdminDTO(); // 반환될 AdminDTO 객체 초기화
		
		String sql 	= " select admin_id, passwd, name "
					+ " from tbl_admin "
					+ " where admin_id = ? and passwd = ? and status = 1 ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, loginMap.get("adminId"));
			pstmt.setString(2, loginMap.get("passwd"));
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				adminDTO.setAdminId(rs.getString("admin_id"));
				adminDTO.setPasswd(rs.getString("passwd"));
				adminDTO.setName(rs.getString("name"));
			} else {
				adminDTO = null;
			}
			
		} catch (SQLException e) {
			// TODO SQL 공통 예외처리 구상 필요
			e.printStackTrace();
		} finally {
			close();
		}

		return adminDTO;
	}
}
