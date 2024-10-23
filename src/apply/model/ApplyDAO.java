package apply.model;

import java.util.List;

import apply.domain.ApplyDTO;

//입사지원서
public interface ApplyDAO {

	// 입자지원자 목록
	List<ApplyDTO> applyList();

}
