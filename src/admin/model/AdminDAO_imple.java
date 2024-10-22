package admin.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import admin.domain.AdminDTO;
import admin.domain.AdminLoginDTO;
import common.ProjectDBConnection;

public class AdminDAO_imple implements AdminDAO {
	
	private final Connection conn = ProjectDBConnection.getConn(); // DB Connection 객체
	
	private PreparedStatement pstmt; // 쿼리 실행 객체
	
	private ResultSet rs; // 쿼리 결과를 담을 객체
	

	/*
	 * 관리자 로그인 메소드
	 */
	@Override
	public AdminDTO login(AdminLoginDTO loginDTO) {
		AdminDTO adminDTO = new AdminDTO(); // 반환될 AdminDTO 객체 초기화
		
		String sql 	= " select admin_id, passwd, name "
					+ " from tbl_admin "
					+ " where admin_id = ? and passwd = ? and status = 1 ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, loginDTO.getAdmin_id());
			pstmt.setString(2, loginDTO.getPasswd());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				adminDTO.setAdmin_id(rs.getString("admin_id"));
				adminDTO.setPasswd(rs.getString("passwd"));
				adminDTO.setName(rs.getString("name"));
			} else {
				adminDTO = null;
			}
			
		} catch (SQLException e) {
			// TODO SQL 공통 예외처리 구상 필요
			e.printStackTrace();
		}

		return adminDTO;
	}
}
