package notification.model;

import java.util.List;
import java.util.Map;

import notification.domain.NotificationDTO;
/*
 * 공지와 관련된 DB 데이터 접근 인터페이스
 */
public interface NotificationDAO {

	/*
	 * 공지사항 리스트 조회 메소드
	 */
	List<NotificationDTO> getNotificationList(boolean isAdmin);

	/*
	 * 공지사항 등록 메소드
	 */
	int registerNotification(Map<String, String> noticeMap);

	/*
	 * 공지사항 상세 조회 메소드
	 */
	NotificationDTO getNotificationDetails(boolean isAdmin, int notificationId);
	
	/*
	 * 공지사항 수정 메소드
	 */
	int updateNotification(Map<String, String> noticeMap);
	
	/*
	 * 공지사항 유무 확인 메소드
	 */
	int selectCountNotification(int notificationId);

	/*
	 * 공지사항 삭제 메소드
	 */
	int deleteNotification(int notificationId);

}
