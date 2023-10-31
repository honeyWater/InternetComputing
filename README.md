InternetComputing
-
인터넷 컴퓨팅 프로젝트 과제 배포를 위한 repository

--------------------------------------------
1. 웹 서버 환경
- 제가 사용한 웹 서버는 안전하고 크기 조정이 가능한 컴퓨팅 용량을 클라우드에서 제공하는 웹 서비스인 AWS의 EC2(Elastic Compute Cloud)입니다.
--------------------------------------------
2. 외부 접속 Domain Name / ip:port
- 외부 접속은 퍼블릭 IPv4 주소와 퍼블릭 IPv4 DNS를 통해 할 수 있습니다.
- 링크 1: http://aws-public-ip:8080/post/list.do 
- 링트 2: http://aws-public-DNS:8080/post/list.do 

- 지금은 닫아놓은 상태입니다.
--------------------------------------------
3.	웹 페이지 작성에 대한 설명 및 중요 코드
-	화면 처리는 JSP를 대신해서 HTML5 기반의 자바 템플릿 엔진인 타임리프(Thymeleaf)를 사용했습니다.
-	프로젝트의 각 설정은 XML 설정을 대신해서 자바(JAVA) 기반의 설정을 사용했습니다.
-	데이터베이스는 MySQL을 사용했습니다.
-	퍼시스턴스 프레임워크로는 마이바티스(MyBatis)를 사용했습니다.

- 개발을 진행하는 데 있어 필수적인 설정들의 처리가 되어있거나, 간편하게 설정이 가능하기에 비즈니스 로직 작성에 더욱 집중할 수 있는 환경을 제공해 주는 Spring Boot를 사용하였습니다. 제 프로젝트의 패키지 구조는 다음과 같습니다.
![image](https://github.com/honeyWater/InternetComputing/assets/99648793/c273beb6-50f3-4d0d-be18-a3fba1d1f933)

- 프로젝트는 Controller에서 Get 혹은 Post 방식으로 요청 받은 링크에 따라서 해당 Controller를 실행하게 되고 내부적으로 DB와의 연동을 통해 데이터를 Model에 담고 View(html)로 뿌려주는 방식입니다.

 
3-1. 게시글 리스트 페이지와 관련된 코드
![image](https://github.com/honeyWater/InternetComputing/assets/99648793/15f6f080-4ff7-4139-bd11-d1259de8634f)
<PostController – openPostList>


![image](https://github.com/honeyWater/InternetComputing/assets/99648793/22ad3def-c9b8-4aff-a97f-9f825b17a3df)
<PostService – findAllPost>


![image](https://github.com/honeyWater/InternetComputing/assets/99648793/0f2ef83b-ab4f-4aa5-a155-a95111effb45)
<PostMapper – findAll 와 count 메소드>


![image](https://github.com/honeyWater/InternetComputing/assets/99648793/9db38119-1d9f-4ca1-9f5b-107de6077e94)
<실질적으로 데이터를 가져오는 xml 구문 (PostMapper.xml)>

 
![image](https://github.com/honeyWater/InternetComputing/assets/99648793/120eac74-21cd-4022-bdf9-ab821aff34b5)
![image](https://github.com/honeyWater/InternetComputing/assets/99648793/7358e698-b37c-4e3a-87ca-ce65b786aaf9)
<Controller에서 최종적으로 반환하는 list.html의 일부>

-	프로젝트의 방식은 전체적으로 위와 비슷한 맥락입니다.
-	게시글에 대한 기본적인 CRUD와 페이지네이션 기능을 합니다. 각 페이지 버튼을 누르면 해당 페이지의 게시글이 출력되며, ‘>’, ‘<’ 버튼을 누르면 1, 11, 21 등 그 다음과 이전의 1페이지가 출력되고 ‘<<’, ‘>>’ 버튼을 누르면 맨 앞 페이지와 맨 뒤 페이지로 이동합니다.
--------------------------------------------
4. 개인적 소감 / 어려웠던 점 및 해결 과정

4-1. 개인적 소감
프로젝트 관련 경험이 많지 않아서 헤매기도 했지만, 결국 해결해 나가면서 좋은 경험이 될 수 있었던 프로젝트 였다고 생각합니다. 프로젝트를 만드는 것 조차 쉽지 않은 일이지만 웹 서버를 구축해 보는 것도 정말 좋은 경험입니다. 구글링을 한다고 해서 모든 것이 나와 있는 대로 되지는 않는데, 프로그램 별로 호환되는 버전, 내가 작성한 코드의 오류 등을 해결하는 능력도 나름 상승한 것 같은 기분입니다. 한 학기 동안 이 프로젝트를 경험하게 돼서 좋았습니다. 사실 후배들이 다른 과목에서도 이런 프로젝트를 할 일이 많았으면 하는 바램입니다.


4-2. 어려웠던 점 및 해결 과정
-	처음에 회원가입, 로그인 관련해서 시도하려고 했으나 spring boot 버전과 spring security 버전 사이에 의존성이 맞지 않아 다른 방법을 찾다가 결국 security를 이용한 회원가입 및 로그인은 포기하게 되었습니다.
-	시간이 촉박해서 결국 구현하지는 못했지만 웹 서버를 구축하는 과정에서 spring boot 버전을 낮추게 되었는데, 현재는 spring security와 버전 호환이 되는지 의문이라 프로젝트 제출이 끝나고도 한 번 시도해보려고 합니다.
-	초반에 프로젝트 실행이 되는지 테스트 해볼 때, static 파일들을 header.html에 명시 후 write.html에서 사용되도록 했는데, 레이아웃이 적용 안되는 경우가 있었습니다.
	여러 방법을 시도해 보다가 결국 파일 경로가 잘못된 것을 알게 되고 해결하였습니다.
사소한 것 하나만으로도 큰 문제가 된다는 것을 깨달은 때였습니다..
-	웹 서버를 구축 후 배포하는 과정에서 제 로컬 서버에서는 실행이 되는데 구축한 서버에서는 실행은 되는데 html파일을 불러오지 못하는 경우가 있었습니다. Putty 내에서도 Error Log가 출력이 되지 않아서 해결 방법을 찾지 못했었습니다.
	Spring boot의 application.properties 파일에서
	Logging.level.org.springframework = debug 와
	Logging.level.org.springframework.web = debug를 추가한 뒤 프로젝트를 실행하니 basic.html 파일의 구문 중 경로 지정이 잘못됐다는 것을 알게 되었습니다. ‘/’ 하나를 빼고 나니 실행되는 것을 보고 참 많은 감정이 오가는 순간이였습니다..
--------------------------------------------
5. 클론코딩한 사이트
https://congsong.tistory.com/13

-> 원래는 구성이 MySQL이였으나, 현재는 MariaDB로 바뀐 상태입니다. 위 사이트 외에 클론하면서 발생했던 문제는 따로 찾아보면서 해결했습니다.
