# practice


## 실수
1. 기본 홈 화면에 접근할때 404에러 발생
  - 원인 : jsp 파일 경로가 main 아래 있지 않음
  - 해결 : webapp 하위 폴더를 모두 src/main 아래로 옮김
  
  - 원인2 : Board model의 content는 Long으로 되어있지만 annotation은 @Lob으로 붙어있어 충돌
  - 해결 
    - 에러 분석을 위해 Exception Handler 생성
    - error message를 이용해 구글링하였을때 Board model에 문제가 있는것을 확인
    - Board model 의 return type을 String으로 변경
