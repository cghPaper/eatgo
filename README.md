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
1. Topic
    - How work.
    - What do.
2. What to do
    - Why, How next
    - Observe
    - What mean
    - Try it
    - I must have done something wrong
    - Regret: What do, What hard, How next
    - Mistake record
3. What generate
    - (User) can (Function) For (Value)
4. How generate
    - Domain modeling: Restaurant, Menu Item, User, Favorite, Review, Reservation, 
    - System Architecture (3 tier Architecture: Presentation(Front-end/HTML,CSS,JS), Business(Back-end/REST API), Data Source(Database/DBMS))
      - Constraints: Web (access browser), Mobile Application(access mobile app)
5. Focus Business(Back-end)
    - Layered Architecture:
        - UI Layer
        - Application Layer
        - Domain Layer
        - Infrastructure Layer
    - **The lower layer can't use the upper layer.**
6. Technique
    - Java
    - Spring Boot
    - REST API
7. Hello, world
    - [Spring initalizr] https://spring.io/ -> Tab: Project -> Spring boot -> Spring initalizr -> Gradle Project, Java, 2.2.3(stable), Group: kr.co.fastcampus, Artifact(project name): eatgo, Description: eatgo project, packaging: Jar, Java: 8, Dependencies: Spring Web, devtools, lombok -> Button: Generate
    - [Execute project] IntellriJ -> Open -> eatgo folder click -> if Mac, use **auto-import** check, Gradle JVM: Use Project JDK
        - shortcut
            - find file: shift + shift 
    - [Change Multi project] create folder eatgo-api, move src folder and move build.gradle file to eatgo-api
     