# ITBook-boot

## 스프링 부트를 이용한 ITBook 서비스
- 사용 기술 및 환경  **Spring Boot, Tomcat 9, TILES, AJAX통신, GIT, GRADLE, MySQL, JPA, JSTL, bootstrap**

## 개인 프로젝트
- 개발 서적을 파는 도서 사이트를 **스프링 부트**와 **JPA ORM**방식으로 구현하였습니다.


- 자바 파일 디렉토리 구조는 업무 중심으로 구성하였고, 업무 폴더 안에 Controller, Service, Repository, Model로 나눈 폴더를 구성하였습니다.
여러 업무에서 공통으로 사용하는 클래스는 업무 폴더와 동등한 위치에 domain 폴더 안에 구성하였고, 공통 설정파일은 config 폴더 안에 정리하였습니다.


- 관리자 페이지와 클라이언트 페이지를 나눠서 구성하였는데, 관리자 페이지 관련 디렉토리는 admin폴더 안에 클라이언트 방식과 동일하게 구성하였습니다.

## 포트폴리오 관련 설명
- 주요 기능은 **회원 관리, 도서 관리,마이페이지 관리,일괄 처리,REST API,파일 업로드, AOP** 입니다.
- 또한 해당 서비스마다 **TDD 코드**를 추가적으로 작성하고 있습니다.

- **회원 관리**는 회원 가입과 OAuth2와 스프링 시큐리티를 이용한 로그인 처리 서비스입니다. 자세한 설명은 **[[ITBook-boot/manual/user](https://github.com/jaydenchuljinlee/ITBook-boot/tree/master/manual/user)]** 폴더에 작성하였습니다.

- **도서 관리**는 네이버 책 서비스의 검색을 isbn으로 크롤링해서 가져 와서 등록,조회,수정 할 수 있는 서비스 입니다. 자세한 설명은 **[[ITBook-boot/manual/book](https://github.com/jaydenchuljinlee/ITBook-boot/tree/master/manual/book)]** 폴더에 작성하였습니다.

- **마이페이지** 관리는 장바구니 등록,삭제부터 결제 처리 및 환불 처리를 관리하는 서비스 입니다. 자세한 설명은 **[[ITBook-boot/manual/mypage](https://github.com/jaydenchuljinlee/ITBook-boot/tree/master/manual/mypage)]** 폴더에 작성하였습니다.

- **일괄 처리**는 휴면 유저와 같은 공통적인 다중 처리를 관리하기 위한 서비스 입니다. 본 포트폴리오 에서는 휴면 유저의 일괄 처리를 관리하도록 구현하였습니다. 자세한 설명은 **[[ITBook-boot/manual/batch]](https://github.com/jaydenchuljinlee/ITBook-boot/tree/master/manual/batch)** 폴더에 작성하였습니다.

- **REST API** 관련 서비스는 외부 요청과 처리를 하기위해 Restful하게 데이터를 주고 받기 위하여 유저 정보와 파일 정보 관련해서 구현해봤습니다. 자세한 설명은 **[[ITBook-boot/manual/restapi]](https://github.com/jaydenchuljinlee/ITBook-boot/tree/master/manual/restapi)** 폴더에 작성하였습니다.

- **파일 업로드**는 파일 정보를 업로드하고, 파일을 관리하기 위해 구현해 봤고, 추후 서비스에 기능을 추가할 예정입니다. 자세한 설명은 **[[ITBook-boot/manual/fileupload]]()** 폴더에 작성하였습니다.

- **AOP**는 어떻게 구현을 해볼까 하다가 session정보를 관리해주기 위해 구현해보는 것이 좋을 것 같다고 생각하여 세션을 어노테이션을 통해 쉽게 가져올 수 있도록 구현해봤습니다. 자세한 설명은 **[[ITBook-boot/manual/aop](https://github.com/jaydenchuljinlee/ITBook-boot/tree/master/manual/aop)]** 폴더에 작성하였습니다.

- **TDD** 코드는 테스트 디렉토리 아래 작성 **[[src/test](https://github.com/jaydenchuljinlee/ITBook-boot/tree/master/ITBook/src/test/java/com/example/ITBook)]**

- 추가적으로 **예외처리** 관련해서 **-[src/main/java/ITBook/common/exception](https://github.com/jaydenchuljinlee/ITBook-boot/tree/master/ITBook/src/main/java/com/example/ITBook/common/exception)]** 디렉토리에 Exception Handler와 Exception Class들을 
따로 모아 놨고, 발생할 수 있는 예외에 대해서 에러를 처리하기 위한 페이지를 별도로 작성했습니다.

문의 : asddqe111@gmail.com
