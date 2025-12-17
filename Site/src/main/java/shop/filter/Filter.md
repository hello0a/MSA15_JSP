# LoginFilter
웹 사이트에 요청이 들어올 때마다
-> 로그인했는지 확인하고,
-> 안했으면 쿠키를 보고 자동 로그인 시도
하는 입구 검사원(Filter) 역할
--비유--
놀이공원 입구 직원
-> 손목띠 (세션) 있으면 통과
-> 없으면 자동입장권(쿠키) 확인
-> 있으면 입장 처리

# Filter?
@WebFilter(description = "자동 로그인 등 인증 처리 필터", urlPatterns = { "/*" })
public class LoginFilter extends HttpFilter implements Filter {

모든 요청이 컨트롤러로 가기 전에 거쳐가는 문지기
/* -> 모든 URL 요청
순서 : 브라우저 -> Filter -> Controller -> Service -> DB

# 전체 흐름 요약
요청 -> 세션 확인 -> 이미 로그인? 통과 
			  -> 아니면 쿠키 확인 -> 토큰 유효? 자동 로그인 -> 컨트롤러 이동

# 지금 단계에서 꼭 알아야할 핵심 5개
1. Filter = 요청 입구
2. Session = 서버 로그인 정보
3. Cookie = 브라우저 저장 정보
4. Token = 자동 로그인 열쇠
5. doFilter() = 매 요청마다 실행