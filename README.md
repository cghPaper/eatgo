# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.3.RELEASE/gradle-plugin/reference/html/)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.2.3.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.2.3.RELEASE/reference/htmlsingle/#using-boot-devtools)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

### Take Notes
This is restaurant reservation site project repository For study.
1. shortcut
    - find file: shift + shift 
    - move method: ctrl + shift + allow key
    - delete not used import: ctrl+ alert + o  
2. Topic
    - How work.
    - What do.
3. What to do
    - Why, How next
    - Observe
    - What mean
    - Try it
    - I must have done something wrong
    - Regret: What do, What hard, How next
    - Mistake record
4. What generate
    - (User) can (Function) For (Value)
5. How generate
    - Domain modeling: Restaurant, Menu Item, User, Favorite, Review, Reservation, 
    - System Architecture (3 tier Architecture: Presentation(Front-end/HTML,CSS,JS), Business(Back-end/REST API), Data Source(Database/DBMS))
      - Constraints: Web (access browser), Mobile Application(access mobile app)
6. Focus Business(Back-end)
    - Layered Architecture:
        - UI Layer
        - Application Layer
        - Domain Layer
        - Infrastructure Layer
    - **The lower layer can't use the upper layer.**
7. Technique
    - Java
    - Spring Boot
    - REST API
8. Hello, world
    - [Spring initalizr] https://spring.io/ -> Tab: Project -> Spring boot -> Spring initalizr -> Gradle Project, Java, 2.2.3(stable), Group: kr.co.fastcampus, Artifact(project name): eatgo, Description: eatgo project, packaging: Jar, Java: 8, Dependencies: Spring Web, devtools, lombok -> Button: Generate
    - [Execute project] IntellriJ -> Open -> eatgo folder click -> if Mac, use **auto-import** check, Gradle JVM: Use Project JDK
    - [Change Multi project] create folder eatgo-api, move src folder and move build.gradle file to eatgo-api
    
9. TDD: Test Driven Development
    - 목표 주도 개발: test를 통과하면 목표 달성, 그렇지 못하면 목표 달설 실패
        - 테스트 주도 개발의 목표: 사용자 중심 개발, 인터페이스 중심 개발, 올바르게 작동, 깔끔한 코드
            - Refactoring : 작동하는 것은 그대로 두고 내부 구현 즉, 코드만 변경하는 것
                - 그러므로 Test Code 가 필요함
        - Test code를 먼저 작성한다.
    - TDD 사이클
        - Red : 실패하는 test
        - Green : 성공하는 test
        - Refactoring : 여러 data 를 넣어도 작동되는 test 가 되도록 변경

10. REST API
    - 의미: 표현 상태를 전달, Resource 를 처리 = CRUD -> POST, GET, PUT/PATCH, DELETE
    - Resource 지정: 
        - URI: 식별자
        - URL: 지사자
    - Resource 분류
        - Collection: Read(List), Create
            - http://host/restaurants
              프로토콜 :// 도메인 또는 IP / 복수형
        - Member: Read(Detail), Update, Delete
            - http://host/restaurants/1
              프로토콜 :// 도메인 또는 IP / 복수형 / 개별 리소스의 Id
    - JSON: JavaScript Object Notation
    - APIs
        - 가게 목록: GET /restaurants
        - 가게 상세: GET /restaurants/{id}
        - 가게 추가: POST /restaurants
        - 가게 수정: PATCH /restaurants/{id}
        - 가게 삭제: DELETE /restaurants/{id}
        - Restaurants 라는 하나의, 리소스에 접근하는 방법만 알고 있다면 Collection 으로 쓰거나 /{id} 붙어여서 Member 접근 가능
        
11. Dependency Injection(의존성 주입)
    - DI 는 객체들 간의 의존 관계를 Spring을 이용해서 직접 관리하는 것을 의미
        - 어노테이션 지원: @Component, @Autowired
    - 의존성 = 의존 관계 = 둘 이상의 객체가 서로 협력하는 관계
        - A 는 B에 의존 = A 는 B를 사용 = B 의 변화가 A 에 영향 -> 관리 필요
        - Controller는 Repository에 의존
    - Spring IoC Controller: 객체를 만들어 주고 연결해주는 역할
    - 의존성 주입 시 장점
        - 사용해야 되는 객체를 다양하게 변경해야 된다는 점
        - 기존의 Controller 가 직접적으로 Respository 에 의존하고 있었는데 이런 의존성을 분리해주는 것을 DI를 통해서 분리해 
          줄 수 있다.
        - 각 객체들이 강하게 엮여 있는 관계들을 유연하게 변경해 줄 수 있다.
        - 객체를 직접 생성하고 관리하는 것을 Spring 이 해줌으로써 코드가 간단해진다.
        
12. Layered Architecture
    - UI Layer(Interfaces Package:Controller), Domain Layer(Domain Package: Restaurant, Repository)
    - Application Layer: 복잡한 로직을 모아서 처리
    - Controller 는 web에 대한 동작을 위해 처리되는 작업에 집중
    - Service는 web이 어떻게 작동해야하는지 알 필요가 없고 단순히 repository들를 이용해서 어떤 결과를 돌려줘야 한다는 application 에 대한 본질적인 작업에 집중