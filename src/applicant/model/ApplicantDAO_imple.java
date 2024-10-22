package applicant.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import applicant.domain.ApplicantDTO;
import common.ProjectDBConnection;

public class ApplicantDAO_imple implements ApplicantDAO {

	// field
	private Connection conn = ProjectDBConnection.getConn();
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	// method
	// === 자원반납 === //
	private void close() {
		try {
			if(rs != null) { rs.close(); rs = null; }
			
			if(pstmt != null) { pstmt.close(); pstmt = null; }
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}// end of close()-------------------------
	
	
	// === 회원가입 === //
	@Override
	public int register(ApplicantDTO applicantDTO) {
		
		int result = 0;
		
		try {
			String sql = " insert into tbl_applicant(applicant_id, passwd, email, name, birthday, gender, tel) "
					   + " values(?, ?, ?, ?, to_date(?, 'yyyymmdd'), ?, ?) ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  applicantDTO.getApplicantId());
			pstmt.setString(2,  applicantDTO.getPasswd());
			pstmt.setString(3,  applicantDTO.getEmail());
			pstmt.setString(4,  applicantDTO.getName());
			pstmt.setString(5,  applicantDTO.getBirthday());
			pstmt.setInt(6,  applicantDTO.getGender());
			pstmt.setString(7,  applicantDTO.getTel());
			
			result = pstmt.executeUpdate(); // sql문 실행
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return result;
	}// end of public int memberRegister(MemberDTO member)------------------
	
	
	// === 로그인 === //
	@Override
	public ApplicantDTO login(Map<String, String> paraMap) {
		
		ApplicantDTO applicantDTO = null;
		
		try {
			String sql = " select applicant_id, email, name, birthday, gender, tel "
					   + " from tbl_applicant "
					   + " where status = 1 and applicant_id = ? and passwd = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paraMap.get("applicantId"));
			pstmt.setString(2, paraMap.get("passwd"));
			
			rs = pstmt.executeQuery(); // sql문 실행
			
			if(rs.next()) {
				
				applicantDTO = new ApplicantDTO();
				
				applicantDTO.setApplicantId(rs.getString("applicant_id"));
				applicantDTO.setEmail(rs.getString("email"));
				applicantDTO.setName(rs.getString("name"));
				applicantDTO.setBirthday(rs.getString("birthday"));
				applicantDTO.setGender(rs.getInt("gender"));
				applicantDTO.setTel(rs.getString("tel"));
				
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return applicantDTO;
	}

}
