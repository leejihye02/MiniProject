package job.model;

import java.util.List;

import job.domain.JobDTO;

public interface JobDAO {

	// 희망직종 목록
	List<JobDTO> jobList();

}
