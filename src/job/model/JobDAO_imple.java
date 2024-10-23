package job.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.ProjectDBConnection;
import job.domain.JobDTO;


public class JobDAO_imple implements JobDAO {

	// field, attribute, property, 속성
	private Connection conn = ProjectDBConnection.getConn();
	private PreparedStatement pstmt;
	private ResultSet rs;

	
		
	// method, operation, 기능
	
	// === 자원반납을 해주는 메소드 === //
	private void close() { // 조회, 삽입, 수정, 삭제마다 전부 넣으면 너무 길어지고 쓸데없으니 메소드화 해서 한줄로 끝내자!
		try {
			if(rs != null) { rs.close(); rs = null;} // 확인사살
			if(pstmt != null) { pstmt.close(); pstmt = null; }
		} catch (SQLException e) {e.printStackTrace();}
	} // end of private void close()------------
	
	
	
	// *** 희망직종 목록을 보여주는 메소드 *** //
	@Override
	public List<JobDTO> jobList() {
		
		List<JobDTO> jobList = new ArrayList<>();
		
		try {
			
			String sql = " select job_id, name from TBL_JOB order by 1 ";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) { 
				JobDTO jobdto = new JobDTO();
				jobdto.setJob_id(rs.getInt("job_id"));
				jobdto.setName(rs.getString("name"));
				
				jobList.add(jobdto);
			}
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return jobList;
		
	} // end of public void jobList()-----------
	
	
	
}
