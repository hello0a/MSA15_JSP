package shop.DTO;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Data -> getter, setter, toString, equals, hashCode 자동 생성
 * @NoArgsConstructor -> 값 없이도 객체 생성 가능
 * 	ex) persistenceLogins = new PersistenceLogins();
 * @AllArgsConstructor -> 모든 필드를 한 번에 넣는 생성자 자동 생성
 * 	ex) new PersistenceLogins(
 * 			no, id, username, token, expiryDate, createdAt, updatedAt
 *			);
 * @Builder -> 중요! 객체를 가독성 좋게 만드는 방법 제공
 *  ex) PersistenceLogins pl = PersistenceLogins.builder()
 *   		.id("user01")
 *   		.username("user01")
 *   		.token("abc123")
 *   		.expiryDate(new Date())
 *  		.build();
 *  -> 순서 상관 없음, 필요한 것만 골라서 세팅 가능
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

/**
 * DAO가 다루던 PersistenceLogins 객체의 정체
 * - DB 테이블 persistence_logins 한 줄을, 자바 객체로 표현한 설계도
 */

// 클래스 선언
// PersistenceLogins 라는 자료 묶음(객체)
// 자동 로그인 정보 한 세트로 담은 것!
public class PersistenceLogins {
	private int no;				// 번호
	private String id;			// ID
	private String username;	// 회원 아이디
	private String token;		// 인증 토큰
	private Date expiryDate;	// 만료 기간
	private Date createdAt;		// 등록 일자
	private Date updatedAt;		// 수정 일자
}
