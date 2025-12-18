# 인터페이스
자동 로그인에서 쓰이는 서비스 설계도(인터페이스)
-> 이런 기능들은 꼭 있어야 해! 라는 약속만 해놓은 것

특징
1. 실제 동작X
2. 메서드 목록만 정의
3. 구현은 PersistenceLoginsServiceImpl
-- 비유 --
햄버거 주문 시
어떻게 만드는지 주방에서 알아서!!

역할 요약
자동 로그인용 토큰을
만들고 -> 조회하고 -> 수정하고 -> 만료 확인하고 -> 삭제하는 역할
즉, 자동 로그인 토큰 관리자

# 메서드 한눈에
insert -> 자동 로그인 처음 등록
select -> 아이디로 토큰 조회
selectByToken -> 토큰으로 사용자 찾기
update -> 토큰 변경
refresh -> 있으면 수정 / 없으면 등록
isValid -> 토큰 사용 가능?
delete -> 로그아웃

# LoginFilter 연결
PersistenceLoginspersistenceLogins=
    persistenceLoginsService.selectByToken(token);

booleanisValid=
    persistenceLoginsService.isValid(token);
- 해당 서비스로 인해,
- 필터는 확인만 / DB로직은 서비스가 담당
    