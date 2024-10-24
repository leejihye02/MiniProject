package company.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;

import common.ProjectDBConnection;
import company.domain.CompanyDTO;

public class CompanyDAO_imple implements CompanyDAO {

	//field
	private Connection conn = ProjectDBConnection.getConn();
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	
	//method 기능 
	
	// === 자원을 반납해주는 메소드 === //
	
	private void close() {
		try {
			if(rs != null)    {rs.close();	  rs = null;}
			if(pstmt != null) {pstmt.close(); pstmt = null;}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// end of private void close()----------------
	
	
	
	
	
	// === 구인회사 회원가입 메소드 === //

	@Override
	public int register(CompanyDTO companyDTO) {
		int result = 0;
		
	try {
		
		String sql =" insert into TBL_COMPANY(company_id, passwd, email, name, business_no, address, business_type, tel, industry)  "
				+ "            values(?,?,?,?,?,?,?,?,?) ";
			
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, companyDTO.getCompanyId());
		pstmt.setString(2, companyDTO.getPasswd());
		pstmt.setString(3, companyDTO.getEmail());
		pstmt.setString(4, companyDTO.getName());
		pstmt.setString(5, companyDTO.getBusinessNo());
		pstmt.setString(6, companyDTO.getAddress());
		pstmt.setInt(7, companyDTO.getBusinessType());
		pstmt.setString(8, companyDTO.getTel());
		pstmt.setString(9, companyDTO.getIndustry());
			
		result = pstmt.executeUpdate(); // sql문 실행
		
	} catch (SQLException e) {
	
		e.printStackTrace();
	}	finally {
		close();//자원반납.
	}

	
		return result;
	}//public int register(companyDTO company)



	
	// === 구인회사 로그인 메소드 ==== //
	@Override
	public CompanyDTO login(Map<String, String> paraMap) {
		CompanyDTO company = null;
		
		try {
			String sql = " SELECT company_id, passwd, email, name, business_no, address, tel, industry,  "
					+ "       business_type, "
					+ "       DECODE(business_type,  "
					+ "              0, '대기업',  "
					+ "              1, '중견기업',  "
					+ "              2, '중소기업') AS businessTypeStr "
					+ " FROM tbl_company  "
					+ " WHERE status = 1  "
					+ "  AND company_id = ?  "
					+ "  AND passwd = ?";

		
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, paraMap.get("company_id"));
		pstmt.setString(2, paraMap.get("passwd"));
		
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
		company = new CompanyDTO();
		
		company.setCompanyId(rs.getString("company_id"));
		company.setPasswd(rs.getString("passwd"));
		company.setEmail(rs.getString("email"));
		company.setName(rs.getString("name"));
		company.setBusinessNo(rs.getString("business_no"));
		company.setAddress(rs.getString("address"));
		company.setBusinessType(rs.getInt("business_type"));
		company.setTel(rs.getString("tel"));
		company.setIndustry(rs.getString("industry"));
		company.setBusinessTypeStr(rs.getString("businessTypeStr"));
		}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		
		return company;
	}//public companyDTO login(Map<String, String> paraMap)



	



	//우리회사정보수정하기
	@Override
	public int cpInfoUpdate(CompanyDTO companyDTO) {
		
		int result = 0;
		
		try {
		
		String sql = " update tbl_company set  passwd = ?, email = ?, name = ?, business_no = ?, business_type = ?, address =?, tel = ?, industry = ? "
				   + " where company_id = ? " ;
		
		
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setString(1, companyDTO.getPasswd());
			pstmt.setString(2, companyDTO.getEmail());
			pstmt.setString(3, companyDTO.getName());
			pstmt.setString(4, companyDTO.getBusinessNo());
			pstmt.setInt(5, companyDTO.getBusinessType());
			pstmt.setString(6, companyDTO.getAddress() );
			pstmt.setString(7, companyDTO.getTel());
			pstmt.setString(8, companyDTO.getIndustry());
			pstmt.setString(9, companyDTO.getCompanyId());
			
			result = pstmt.executeUpdate();//sql 실행
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		
		return result;
	}// end of public int cpInfoUpdate(Map<String, String> paraMap) 
	

	

	

}
