package review.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.ProjectDBConnection;
import review.domain.ReviewAuthDTO;

public class ReviewAuthDAO_imple implements ReviewAuthDAO {

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
	
	
	// === 회사인증목록 select === //
	@Override
	public List<Map<String, String>> getReviewAuth(String applicantId) {
		List<Map<String, String>> mapList = new ArrayList<>();
		
		try {
			String sql = " select review_auth_id, fk_applicant_id, fk_company_id, name "
					   + "      , decode(is_permitted, 0, '요청중', 1, '완료', '거부됨') AS is_permitted "
					   + "      , decode((select count(*) "
					   + "         from tbl_review "
					   + "         where fk_applicant_id = ? and fk_company_id = RA.fk_company_id "
					   + "         ), 0, '새로작성하기', '작성됨') as is_registerd "
					   + " from tbl_review_auth RA "
					   + " JOIN tbl_company C "
					   + " ON RA.fk_company_id = C.company_id "
					   + " where fk_applicant_id = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, applicantId);
			pstmt.setString(2, applicantId);
			
			rs = pstmt.executeQuery(); // sql문 실행
			
			while(rs.next()) {
				Map<String, String> reviewAuthMap = new HashMap<>();

				reviewAuthMap.put("review_auth_id", rs.getString("review_auth_id"));
				reviewAuthMap.put("fk_applicant_id", rs.getString("fk_applicant_id"));
				reviewAuthMap.put("fk_company_id", rs.getString("fk_company_id"));
				reviewAuthMap.put("company_name", rs.getString("name"));
				reviewAuthMap.put("is_permitted", rs.getString("is_permitted"));
				reviewAuthMap.put("is_registerd", rs.getString("is_registerd"));
				
				mapList.add(reviewAuthMap);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return mapList;
	}

	
	// === 회사인증 insert === //
	@Override
	public int registerReviewAuth(ReviewAuthDTO reviewAuthDTO) {
		int result = 0;
		
		try {
			String sql = " insert into tbl_review_auth(review_auth_id, fk_applicant_id, fk_company_id) "
					   + " values(seq_review_auth_id.nextval, ?, ?) ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  reviewAuthDTO.getFkApplicantId());
			pstmt.setString(2,  reviewAuthDTO.getFkCompanyId());
			
			result = pstmt.executeUpdate(); // sql문 실행
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return result;
	}

}
