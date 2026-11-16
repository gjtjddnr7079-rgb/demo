
# 2주차 실습: 개발환경 설정 및 Spring Boot 기본 테스트

> **수업명:** 자바웹프로그래밍(2)   
> **주요 내용:** VS Code 기반 Spring Boot 개발 환경 구축, MVC 구조 이해, Controller 및 Thymeleaf 연동 기초  

---

## 🛠️ 실습 내용 요약

### 1. 개발 환경 구축 (Tools & JDK)
* **VS Code 설치 및 확장 모듈 구성:**
  * `Extension Pack for Java` (IntelliSense, Debugger, Maven 등) 설치
  * `Spring Boot Extension Pack` (Tools, Initializr, Dashboard 등) 설치
* **Java Development Kit (JDK) 연동:**
  * JDK 25(또는 17 이상) 설치
  * VS Code `settings.json` 내 `java.jdt.ls.java.home` 및 `spring-boot.ls.java.home` 경로 설정

---

### 2. Spring Boot 프로젝트 생성 및 구조 파악
* **Spring Initializr 프로젝트 생성:**
  * Build tool: **Maven**, Packaging: **Jar**, Java Version: **25**[cite: 2]
  * **주요 의존성(Dependencies) 추가:**  
    `Spring Web`, `Thymeleaf`, `Spring Data JPA`, `MySQL Driver`, `Lombok`, `Spring Boot DevTools`, `Spring Web Services`[cite: 2]
* **프로젝트 폴더 구조:**
  * `src/main/java`: 루트 패키지 및 자바 소스 파일 (`DemoApplication.java`)[cite: 2]
  * `src/main/resources/templates`: HTML 템플릿 파일 저장소[cite: 2]
  * `src/main/resources/static`: 정적 자원 (CSS, JS, 이미지 등)[cite: 2]
  * `pom.xml`: 빌드 및 라이브러리 의존성 관리 설정 파일[cite: 2]

---

### 3. Controller 매핑 및 Thymeleaf 데이터 전달 테스트
* **첫 번째 뷰 템플릿 생성 (`index.html` & `hello.html`):**
  * `src/main/resources/templates/` 하위에 HTML 파일 생성 및 Thymeleaf 네임스페이스 선언[cite: 2]
* **컨트롤러 구현 (`DemoController.java`):**
  * `@Controller` 어노테이션 적용[cite: 2]
  * `@GetMapping("/hello")` 요청 처리 매핑[cite: 2]
  * `Model` 객체를 활용한 데이터 바인딩 (`model.addAttribute("data", "반갑습니다.");`) 및 View 이름 리턴[cite: 2]

---

### 4. 연습문제: 추가 URL 매핑 (`/hello2`) 구현
* **`DemoController.java` 매핑 추가:**
  * `@GetMapping("/hello2")` 매핑 메서드 구현[cite: 2]
  * `Model` 객체에 5개의 속성(변수) 추가 전달[cite: 2]
* **`hello2.html` 뷰 작성:**
  * 전달받은 5개의 속성 변수를 Thymeleaf 문법(`th:text="${...}"`)으로 출력[cite: 2]

---

## 🔗 관련 소스 코드 링크


-----------------------------------------------------------------------------------------------------------------------------------------

# 3주차 실습: 프론트엔드 포트폴리오 작성 및 Spring Boot 연동

> **수업명:** 자바웹프로그래밍(2)   
> **주요 내용:** Bootstrap 5 템플릿 활용, Thymeleaf 경로 설정, 정적 페이지 구성 및 Lighthouse 성능 분석  

---

## 🛠️ 실습 내용 요약

### 1. 템플릿 다운로드 및 프로젝트 구조 설정
* **템플릿 적용:** Bootstrap 5 기반의 `First Portfolio (TemplateMo 578)` 단일 페이지(One-page) 템플릿 다운로드 및 압축 해제[cite: 1].
* **파일 이동 및 경로 정리:**
  * `index.html` → `src/main/resources/templates/` 경로로 이동 (기존 파일 백업)[cite: 1].
  * `css/`, `js/`, `images/`, `fonts/` 폴더 → `src/main/resources/static/` 하위로 이동[cite: 1].

---

### 2. Thymeleaf 문법 및 정적 자원 경로 수정
* **Thymeleaf 네임스페이스 선언:** `<html xmlns:th="http://www.thymeleaf.org">` 추가[cite: 1].
* **경로 변환:** 상대 경로로 작성된 자원 링크를 Thymeleaf 문법(`@{...}`)으로 절대 경로화 처리[cite: 1].
  * 예시: `th:href="@{/css/bootstrap.min.css}"`, `th:src="@{/images/profile.png}"`[cite: 1]

---

### 3. 포트폴리오 메인 화면 수정 & 웹 접근성 개선
* **네비게이션 바 한글화 및 폰트 크기 조정:**
  * 메뉴 한글화 (홈페이지, 소개, 기술, 프로젝트, 연락처)[cite: 1].
  * `css/templatemo-first-portfolio-style.css`에서 글꼴 크기 변수 조정[cite: 1].
* **Hero 섹션 프로필 구성:**
  * 자기소개 텍스트 수정 및 프로필 이미지(`profile.png`) 교체[cite: 1].
* **웹 접근성(Accessibility) 및 폼(Form) 버그 수정:**
  * `<label for="...">`와 `<input id="...">` 간의 ID 불일치 문제 해결로 라벨 클릭 포커싱 및 자동완성 힌트 개선[cite: 1].

---

### 4. 기술/경험 섹션 & 상세 페이지 생성
* **기술 카드 구성:** 웹(Web), 인공지능(AI), 보안(Security), 게임(Game) 4개 영역 작성[cite: 1].
* **Bootstrap Icons 교체:** 필요한 아이콘 CDN/클래스 적용[cite: 1].
* **정적 상세 페이지 구현:**
  * `src/main/resources/public/detailed_web.html` 생성 (별도 컨트롤러 매핑 없이 정적 제공)[cite: 1].
  * 보안 옵션 적용: 외부 링크 연결 시 `target="_blank" rel="noopener noreferrer"` 사용[cite: 1].

---

### 5. 모바일 반응형 검수 & Lighthouse 성능 분석
* **반응형 테스트:** Chrome 개발자 도구 Device Toolbar(`Ctrl` + `Shift` + `M`)를 이용해 모바일/디바이스별 비율 검수[cite: 1].
* **Lighthouse 측정:**
  * Mobile / Desktop 성능 점수 측정 및 차이 분석[cite: 1].
  * Performance 항목 하락 원인 분석 (이미지 용량/크기, 외부 리소스 로딩 등)[cite: 1].

-----------------------------------------------------------------------------------------------------------------------------------------

# 4주차 실습: Spring Boot와 MySQL 데이터베이스 연동 및 계층형 구조 적용 

> **수업명:** 자바웹프로그래밍(2)    
> **주요 내용:** MySQL DB 연동, Spring Data JPA/Hibernate 활용, MVC 계층별 패키지 분리(Controller-Service-Repository-Domain), Thymeleaf 반목문 연동  

---

## 🛠️ 실습 내용 요약

### 1. 데이터베이스 환경 구축 및 연동
* **MySQL 서버 설치 및 설정:**
  * MySQL 8.x 설치 및 데이터베이스 생성 (`create database spring;`)[cite: 74, 75]
  * VS Code MySQL 확장 모듈 설치를 통한 DB 커넥션 관리[cite: 78, 79]
* **의존성(Dependencies) 및 연동 설정:**
  * `pom.xml` 내 `spring-boot-starter-data-jpa` 및 `mysql-connector-j` 의존성 주석 해제/추가[cite: 71, 73]
  * `application.properties` 파일에 DB 접속 정보(URL, 계정, ddl-auto update 설정) 명시[cite: 76]

---

### 2. 프로젝트 계층 구조(Architecture) 분리
* 기존 단일 패키지 구조에서 계층별 역할에 맞는 패키지 분리 적용[cite: 80, 81, 82]:
  * `controller`: 요청 처리 및 뷰 반환 (`DemoController.java`)[cite: 82]
  * `model.domain`: DB 테이블과 매핑되는 엔티티 클래스[cite: 82, 84]
  * `model.repository`: JPA 데이터 접근 인터페이스[cite: 82, 85]
  * `model.service`: 비즈니스 로직 처리 및 데이터 가공 계층[cite: 82, 86]

---

### 3. JPA Entity / Repository / Service 구현
* **Entity 생성 (`TestDB.java`):**
  * `@Entity`, `@Table(name = "testdb")`, `@Data` (Lombok) 적용[cite: 84]
  * `@Id`, `@GeneratedValue(strategy = GenerationType.IDENTITY)`로 PK 자동 증가 설정[cite: 84]
* **Repository 생성 (`TestRepository.java`):**
  * `JpaRepository<TestDB, Long>` 인터페이스 상속을 통한 기본 CRUD 메서드 확보[cite: 85]
* **Service 생성 (`TestService.java`):**
  * `@Autowired`를 통한 Repository 의존성 주립(DI) 처리[cite: 86]
  * `findAll()` 메서드를 호출하여 전체 사용자 리스트 조회 로직 구현[cite: 86, 91]

---

### 4. Controller 연동 및 Thymeleaf 뷰 렌더링
* **Controller 처리 (`DemoController.java`):**
  * `@GetMapping("/testdb")` 매핑 구현[cite: 87]
  * `TestService`에서 조회한 데이터를 `Model` 객체에 저장 후 `testdb.html`로 전달[cite: 87, 91]
* **View 구현 (`testdb.html`):**
  * Thymeleaf의 `th:each` 구문을 활용하여 조회된 사용자 리스트를 HTML 테이블 형태로 출력[cite: 88, 92]

---

### 5. [연습문제] 사용자 정보 컬럼 확장 및 데이터 출력
* **Entity 수정:** `TestDB.java`에 나이(`age`), 성별(`gender`) 필드 추가[cite: 95]
* **JPA DDL Auto 연동:** 서버 재시작 시 `ddl-auto=update` 옵션에 의해 DB 테이블 컬럼 자동 생성 확인[cite: 76, 89]
* **데이터 직접 작성 및 검수:** VS Code MySQL 확장의 INSERT 기능으로 다수의 데이터 입력 후, 화면 테이블에서 정상 출력 검증[cite: 90, 92, 95]



-----------------------------------------------------------------------------------------------------------------------------------------




# 5주차 실습: Spring Security 기반 로그인/로그아웃 및 비밀번호 암호화

> **수업명:** 자바웹프로그래밍(2)  
> **강사:** 최도현  
> **주요 내용:** Spring Security 필터 체인 설정, BCrypt 단방향 해시 암호화, 세션 기반 로그인/로그아웃, 민감 정보 분리(`application-secret.properties`)  

---

## 🛠️ 실습 내용 요약

### 1. Spring Security 의존성 추가 및 보안 아키텍처 설정
* **의존성 추가 (`pom.xml`):**
  * `spring-boot-starter-security` (보안 및 인증/인가 프레임워크)[cite: 106]
  * `thymeleaf-extras-springsecurity6` (Thymeleaf 내 시큐리티 태그 확장)[cite: 106]
* **보안 설정 클래스 구현 (`config/SecurityConfig.java`):**
  * `@Configuration`, `@EnableWebSecurity` 적용[cite: 109]
  * `BCryptPasswordEncoder` 빈(Bean) 등록을 통한 비밀번호 해시 암호화 지원[cite: 109]
  * `SecurityFilterChain` 람다 DSL 구성[cite: 109]:
    * **URL 접근 제어:** 메인(`/`, `/hello`, `/detailed_web.html`), 인증 페이지(`/login`, `/signup`), 정적 자원(`/css/**`, `/js/**` 등)은 `permitAll()`, 나머지 요청은 `authenticated()` 처리[cite: 109, 110]
    * **커스텀 로그인/로그아웃:** 커스텀 로그인 페이지(`/login`) 연동 및 로그아웃(`/logout`) 시 세션 무효화, `JSESSIONID`·`remember-me` 쿠키 삭제 설정[cite: 109, 121]

---

### 2. 회원 도메인(Entity) 및 회원가입 기능 구현
* **회원 엔티티 및 리포지토리 (`Member.java`, `MemberRepository.java`):**
  * `username`(중복 불가), `password`(BCrypt 60자 해시), `name`, `role`(기본 권한 `USER`) 필드 매핑[cite: 112]
  * `findByUsername()`, `existsByUsername()` 쿼리 메서드 작성[cite: 113]
* **가입 데이터 DTO (`MemberForm.java`):**
  * 엔티티 직접 노출 및 권한(`role`) 조작 방지를 위한 화면 전용 데이터 객체 분리[cite: 114]
* **회원가입 서비스 및 컨트롤러 (`MemberService.java`, `MemberController.java`):**
  * 아이디 중복 검증 후 `passwordEncoder.encode()`로 비밀번호 암호화 저장[cite: 115]
  * `th:action`을 통한 CSRF 토큰 자동 삽입 및 예외 처리(`IllegalArgumentException`)[cite: 116]

---

### 3. 세션 기반 로그인 연동 및 Thymeleaf 인증 상태 분기
* **사용자 인증 조회 (`UserDetailsService` 구현):**
  * `MemberService`에 `loadUserByUsername()` 오버라이딩을 통해 DB 회원 정보를 시큐리티 `UserDetails` 객체로 변환[cite: 117]
  * `PasswordEncoder.matches()`를 활용한 안전한 비밀번호 해시 비교 및 세션(`JSESSIONID`) 발급 확인[cite: 118, 119]
* **뷰 동적 렌더링 (`index.html`):**
  * `sec:authorize="isAnonymous()"` / `isAuthenticated()` 및 `sec:authentication="name"`을 활용해 로그인 전후 네비게이션 버튼 분기 처리[cite: 120]

---

### 4. GitHub 보안 관리: DB 접속 정보 분리
* **민감 정보 분리 및 `.gitignore` 등록:**
  * `application-secret.properties` 파일을 별도 생성하여 DB 계정 및 비밀번호 이동[cite: 123]
  * `application.properties`에 `spring.config.import=optional:application-secret.properties` 설정 추가[cite: 123]
  * `.gitignore`에 `application-secret.properties`를 추가하여 원격 저장소(GitHub) 노출 차단[cite: 123]

---

### 5. [연습문제] 로그인 상태 유지 및 비밀번호 확인 검증
* **자동 로그인 (`remember-me`) 구현:**
  * `SecurityConfig`에 `.rememberMe()` 체이닝 설정(비밀키 및 유효기간 7일 설정)을 추가하여 브라우저 재시작 후에도 로그인 유지 검증[cite: 125]
* **회원가입 비밀번호 일치 검증:**
  * `MemberService.signup()`에서 `password`와 `passwordConfirm` 일치 여부를 비교하여 불일치 시 예외 메시지 출력 처리[cite: 125]



-----------------------------------------------------------------------------------------------------------------------------------------


# 6주차 실습: RBAC 기반 권한 관리 및 관리자 페이지 이중 잠금 구현

> **수업명:** 자바웹프로그래밍(2)  
> **강사:** 최도현  
> **주요 내용:** 역할 기반 접근 제어(RBAC), URL/메서드 수준 이중 잠금(`hasRole`, `@PreAuthorize`), 커스텀 403 에러 페이지, 관리자 전용 회원 관리 페이지  

---

## 🛠️ 실습 내용 요약

### 1. 마이페이지(`/mypage`) 구현 및 IDOR 방지
* **내 정보 조회 (`MemberService.java`, `MemberController.java`):**
  * URL 파라미터(`?id=...`) 대신 시큐리티의 `Principal` 객체를 통해 현재 로그인된 사용자의 아이디(`principal.getName()`)로 직접 조회하여 번호 조작 취약점(IDOR) 차단[cite: 137]
  * DB에 저장된 실제 `role` 값과 현재 로그인 세션의 권한(`[ROLE_USER]` 등) 일치 여부 검증[cite: 137, 139]

---

### 2. 관리자 페이지 분리 및 회원 관리 기능 구현
* **관리자 계정 생성 및 권한 부여:**
  * 회원가입으로 비밀번호가 BCrypt 암호화된 `admin` 계정을 생성한 뒤, DB `UPDATE` 쿼리로 `role`을 `ADMIN`으로 부여[cite: 140]
* **관리자 전용 컨트롤러 및 서비스 (`AdminController.java`, `MemberService.java`):**
  * `@RequestMapping("/admin")`으로 관리자 전용 URL 경로 분리[cite: 141]
  * **회원 목록 조회 (`GET /admin/members`):** `Sort.by("id")` 기준 전체 회원 목록 조회 및 `admin/members.html` 렌더링[cite: 141]
  * **권한 변경 및 회원 삭제 (`POST`):**
    * 허용된 권한 화이트리스트(`ROLES`) 검증 후 권한 수정 및 회원 삭제 처리[cite: 142]
    * `RedirectAttributes`의 `addFlashAttribute()`와 리다이렉트(PRG 패턴)를 적용해 새로고침 중복 전송 방지[cite: 143]

---

### 3. 접근 제어 3단계 및 이중 잠금(URL + 메서드 보안)
* **화면(View) 분기 (`index.html`):**
  * `sec:authorize="hasRole('ADMIN')"`을 사용하여 일반 사용자에게 관리자 메뉴 숨김 처리[cite: 136, 146]
* **1차 잠금 - URL 기반 권한 제어 (`SecurityConfig.java`):**
  * `.requestMatchers("/admin/**").hasRole("ADMIN")` 규칙을 `anyRequest().authenticated()` 상단에 배치하여 비인가 사용자의 URL 직접 접근 시 `403 Forbidden` 차단[cite: 147, 148]
  * `templates/error/403.html` 커스텀 접근 거부 화면 연동[cite: 148, 149]
* **2차 잠금 - 메서드 기반 권한 제어 (`@PreAuthorize`):**
  * `SecurityConfig`에 `@EnableMethodSecurity` 활성화[cite: 150]
  * `MemberService`의 `changeRole()`, `deleteMember()` 메서드에 `@PreAuthorize("hasRole('ADMIN')")`를 적용하여 비즈니스 로직 실행 직전 재검증[cite: 150]

---

### 4. [연습문제] 관리자 본인 보호 및 매니저(`MANAGER`) 권한 확장
* **관리자 본인 계정 보호:**
  * `SecurityContextHolder`로 현재 로그인한 관리자의 아이디를 조회하여, 자기 자신의 권한을 변경하거나 계정을 삭제하려는 요청 차단[cite: 156]
* **매니저(`MANAGER`) 역할 추가 및 접근 세분화:**
  * 허용 권한 목록에 `MANAGER`를 추가하고, `/testdb` 경로는 `hasAnyRole("ADMIN", "MANAGER")`로 설정해 일반 `USER`의 회원목록 열람 제한[cite: 156]
  * 네비게이션 바의 회원목록 메뉴 역시 권한에 따라 동적 노출 처리[cite: 156]




-----------------------------------------------------------------------------------------------------------------------------------------



# 7주차 실습: REST API 설계 및 JSON 기반 회원 관리 구현

> **수업명:** 자바웹프로그래밍(2)  
> **강사:** 최도현  
> **주요 내용:** `@RestController`와 JSON 직렬화, 응답 DTO(`record`)를 통한 민감 정보 차단, HTTP Basic 인증 및 상태 코드(`ResponseEntity`) 제어, 비동기 `fetch` 연동  

---

## 🛠️ 실습 내용 요약

### 1. REST API 기초 및 응답 DTO(`MemberResponse`) 분리
* **JSON 응답 컨트롤러 구현 (`MemberApiController.java`):**
  * `@RestController`를 적용하여 HTML 뷰 대신 객체(JSON 데이터)를 직접 반환하는 엔드포인트(`/api/hello`, `/api/me`) 구축[cite: 167, 168, 169]
* **민감 정보 노출 방지를 위한 응답 DTO (`MemberResponse.java`):**
  * `Member` 엔티티를 그대로 반환할 경우 비밀번호 해시(`password`)까지 JSON으로 노출되는 문제를 해결하기 위해 Java `record` 기반의 응답 전용 DTO 분리[cite: 169, 170, 171]

---

### 2. API 전용 보안 설정 및 Postman 테스트
* **HTTP Basic 인증 및 CSRF 예외 처리 (`SecurityConfig.java`):**
  * 외부 클라이언트(Postman 등) 요청을 위해 `.httpBasic()` 활성화 및 `/api/**` 경로에 대한 CSRF 토큰 검사 제외(`.ignoringRequestMatchers("/api/**")`) 적용[cite: 175]
  * 비로그인 상태에서 `/api/**` 호출 시 로그인 화면 리다이렉트(302) 대신 `401 Unauthorized` 상태 코드를 반환하도록 `HttpStatusEntryPoint` 설정[cite: 175]
  * 관리자 API 경로(`/api/admin/**`)에 `hasRole("ADMIN")` 접근 제어 추가[cite: 178]

---

### 3. 관리자 회원 관리 REST API 구축 (`AdminApiController.java`)
* **HTTP 메서드 및 상태 코드(`ResponseEntity`) 설계:**
  * **전체 목록 조회 (`GET /api/admin/members`):** 회원 엔티티 리스트를 `MemberResponse` DTO 리스트로 변환하여 `200 OK` 반환[cite: 178]
  * **단건 조회 (`GET /api/admin/members/{id}`):** 존재하는 회원은 `200 OK`, 없는 번호는 `404 Not Found` 반환[cite: 178]
  * **회원 등록 (`POST /api/admin/members`):** `@RequestBody`로 JSON 요청 본문을 바인딩하여 등록 성공 시 `201 Created`(Location 헤더 포함), 유효성/중복 오류 시 `400 Bad Request` 반환[cite: 180]
  * **권한 변경 (`PATCH /api/admin/members/{id}/role`):** `RoleRequest` DTO를 통해 권한 변경 후 `200 OK` 반환[cite: 182, 183]
  * **회원 삭제 (`DELETE /api/admin/members/{id}`):** 삭제 처리 후 본문 없이 `204 No Content` 반환[cite: 183]

---

### 4. 비동기 `fetch` 기반 프론트엔드 연동
* **API 연동 관리자 페이지 (`AdminController.java`, `admin/members-api.html`):**
  * `/admin/members-api` 경로를 추가하여 페이지 새로고침 없이 JavaScript `fetch`로 JSON 데이터를 주고받으며 화면을 동적으로 갱신하는 CSR 방식 연동 검증[cite: 166, 185]

---

### 5. [연습문제] 회원 검색 API 및 전역 예외 처리
* **키워드 기반 회원 검색 API:**
  * `GET /api/admin/members?keyword=...` 요청 시 `@RequestParam(required = false)`와 JPA 쿼리 메서드(`Containing`)를 활용해 아이디 또는 이름에 검색어가 포함된 회원 목록 필터링 구현[cite: 189]
* **전역 예외 처리 통합 (`@RestControllerAdvice`):**
  * 컨트롤러마다 중복되던 `try-catch` 블록을 제거하고 `@RestControllerAdvice` 및 `@ExceptionHandler(IllegalArgumentException.class)`를 통해 `400 Bad Request` JSON 에러 응답을 한곳에서 일관되게 처리[cite: 189]



-----------------------------------------------------------------------------------------------------------------------------------------



# 9주차 실습: 게시판 CRUD 구현 및 작성자 본인 확인 보안 적용

> **수업명:** 자바웹프로그래밍(2)  
> **강사:** 최도현  
> **주요 내용:** `@ManyToOne` 연관관계 매핑, 게시판 CRUD(쓰기·목록·상세·수정·삭제), JPA 변경 감지(Dirty Checking), 작성자 본인 확인(`AccessDeniedException`) 및 404/403 예외 처리  

---

## 🛠️ 실습 내용 요약

### 1. 게시글 엔티티 설계 및 연관관계 매핑 (`Post.java`)
* **게시글-회원 다대일(`@ManyToOne`) 매핑:**
  * 게시글(`Post`)과 작성자(`Member`)를 `@ManyToOne(fetch = FetchType.LAZY)` 및 `@JoinColumn(name = "member_id")` 외래 키(FK)로 연결하여 작성자 정보 무결성 유지[cite: 203, 204]
  * 제목(`title`), 본문(`content`, `TEXT`), 작성일(`createdAt`), 수정일(`updatedAt`), 조회수(`viewCount`) 컬럼 구성[cite: 203, 205]

---

### 2. 게시판 CRUD 및 요청 DTO 분리 (`PostForm`, `PostService`, `BoardController`)
* **작성자 조작 방지를 위한 DTO (`PostForm.java`):**
  * 화면에서 `title`, `content`만 입력받고 작성자(`author`)는 서버에서 현재 로그인한 `Principal` 객체로 직접 할당[cite: 206, 207, 208]
* **URL 접근 제어 세분화 (`SecurityConfig.java`):**
  * 목록(`/board`)과 숫자 ID 상세 조회(`/board/{id:\\d+}`)만 `permitAll()`로 개방하고, 글쓰기(`/board/write`)·수정·삭제는 인증된 사용자만 접근하도록 제한[cite: 208]
* **CRUD 기능 구현 (`PostService.java`, `BoardController.java`):**
  * **목록 조회 (`GET /board`):** `Sort.by(Sort.Direction.DESC, "id")` 기준 최신 글 상단 정렬 출력[cite: 207, 208]
  * **글쓰기 (`GET/POST /board/write`):** 빈 값 및 제목 길이(100자) 검증 후 저장 및 상세 페이지 리다이렉트[cite: 207, 208]
  * **상세 조회 (`GET /board/{id}`):** 존재하지 않는 게시글 요청 시 `ResponseStatusException(HttpStatus.NOT_FOUND)` 발생 및 커스텀 `error/404.html` 화면 연결[cite: 210]
  * **수정 및 삭제 (`GET/POST /board/{id}/edit`, `POST /board/{id}/delete`):** 기존 엔티티 조회 후 필드 변경 및 `updatedAt` 갱신으로 `UPDATE` 수행, `board/form.html` 공용 재사용[cite: 211, 212]

---

### 3. 게시글 수정·삭제 시 작성자 본인 확인 (`checkWriter`)
* **서버 측 인가 검증 (`PostService.java`):**
  * 화면에서 수정·삭제 버튼을 숨기는 것 외에 URL 직접 접근(`/board/{id}/edit` 등)을 차단하기 위해 `SecurityContextHolder`의 로그인 사용자와 게시글 작성자(`post.getAuthor().getUsername()`) 일치 여부 검증[cite: 197, 214, 215]
  * **수정:** 작성자 본인만 허용하며 불일치 시 `AccessDeniedException` 발생(`403 Forbidden`)[cite: 214, 215]
  * **삭제:** 작성자 본인 또는 관리자(`ROLE_ADMIN`)만 삭제 가능하도록 권한 분기 처리[cite: 214, 215]

---

### 4. [연습문제] 조회수 증가 및 내가 쓴 글 모아 보기
* **조회수(`viewCount`) 증가 로직:**
  * 게시글 상세 조회(`read(id)`) 호출 시 `viewCount`를 1씩 증가시켜 DB에 반영[cite: 219]
* **내가 쓴 글 필터링 (`GET /board/my`):**
  * `PostRepository`에 `findByAuthor_UsernameOrderByIdDesc()` 쿼리 메서드를 추가하여 로그인한 사용자가 작성한 글만 최신순으로 조회하고 기존 목록 뷰(`board/list.html`) 재사용[cite: 219]


-----------------------------------------------------------------------------------------------------------------------------------------


# 10주차 실습: 게시판 페이징, JPQL 검색 및 댓글 연관관계 구현

> **수업명:** 자바웹프로그래밍(2)  
> **강사:** 최도현  
> **주요 내용:** Spring Data JPA `Page`/`Pageable` 기반 페이징, JPQL 파라미터 바인딩 검색, `Comment` 양방향 매핑 및 `CascadeType.REMOVE`, PRG 패턴, 외래 키 참조 무결성 삭제 제어  

---

## 🛠️ 실습 내용 요약

### 1. 스프링 데이터 JPA 페이징 처리 (`PostService`, `BoardController`)
* **페이지 단위 분할 조회 (`PageRequest`, `Page<Post>`):**
  * 대량 게시글 조회 부하를 줄이기 위해 `PageRequest.of(Math.max(page, 0), 10, Sort.by(Sort.Direction.DESC, "id"))`로 10개씩 최신순 분할 조회 구현[cite: 230, 232]
  * 컨트롤러(`GET /board?page=0`)에서 `posts.getContent()`와 `page` 객체를 뷰(`board/list.html`)에 전달하여 페이지 번호, 전체 페이지 수, 이전/다음 버튼 상태 연동[cite: 233]

---

### 2. JPQL 기반 게시글 검색 (`PostRepository`, `PostService`, `BoardController`)
* **제목·내용 키워드 검색 및 SQL 인젝션 방어:**
  * `PostRepository`에 `@Query("SELECT p FROM Post p WHERE p.title LIKE %:keyword% OR p.content LIKE %:keyword%")` JPQL 메서드를 작성하여 파라미터 바인딩(`:keyword`)으로 SQL 인젝션 차단[cite: 237, 241]
  * 검색어 유무(`keyword == null || keyword.isBlank()`)에 따라 전체 목록과 검색 결과를 분기 처리하고, 페이지 이동 시에도 검색어가 유지되도록 `model`에 `keyword` 전달[cite: 238, 239, 240]

---

### 3. 댓글 기능 및 양방향 연관관계 구현 (`Comment`, `CommentRepository`, `CommentService`, `CommentController`)
* **댓글 엔티티 다대일(`@ManyToOne`) 매핑 (`Comment.java`):**
  * 게시글(`post_id`)과 작성자(`member_id`)를 `@ManyToOne(fetch = FetchType.LAZY)` 외래 키로 연결하고 `content`(최대 500자) 및 `createdAt` 컬럼 구성[cite: 242, 243, 244]
* **댓글 등록·조회·삭제 및 PRG 패턴 적용:**
  * **등록 (`POST /board/{postId}/comments`):** 글자 수(1~500자) 검증 및 `Principal` 기반 작성자 할당 후 `redirect:/board/{postId}#comments` (PRG 패턴)로 새로고침 중복 등록 방지[cite: 248, 250, 252]
  * **삭제 (`POST /board/{postId}/comments/{id}/delete`):** `checkWriter(comment)`와 `isAdmin()` 검증을 통해 댓글 작성자 본인 또는 관리자(`ROLE_ADMIN`)만 삭제 가능하도록 제한[cite: 254, 255]

---

### 4. 연관 데이터 삭제 및 참조 무결성 오류 해결 (`Post`, `MemberService`)
* **게시글 삭제 시 댓글 연쇄 삭제 (`CascadeType.REMOVE`):**
  * `Post` 엔티티에 `@OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)`와 순환 참조 방지 어노테이션(`@ToString.Exclude`, `@EqualsAndHashCode.Exclude`)을 설정하여 게시글 삭제 시 하위 댓글도 함께 삭제되도록 처리[cite: 258, 259]
* **작성 글·댓글 보유 회원 삭제 차단 (`existsByAuthor`):**
  * `PostRepository`와 `CommentRepository`에 `existsByAuthor(Member)`를 추가하고, `MemberService.deleteMember()`에서 DB 외래 키 제약조건 예외(500) 대신 `IllegalArgumentException`(400/안내 메시지)으로 사전에 삭제를 차단[cite: 261, 262, 263]

---

### 5. [연습문제] 내가 쓴 글 페이징 및 작성자 검색 확장
* **내가 쓴 글 페이징 (`GET /board/my?page=0`):**
  * `PostRepository`에 `findByAuthor_Username(String username, Pageable pageable)`을 추가하고 `pageUrl`을 전달하여 내 글 목록에서도 10개 단위 페이지네이션 지원[cite: 268]
* **검색 범위(제목+내용 / 작성자) 선택 기능:**
  * 검색 조건 파라미터(`type`)를 추가하고 JPQL 조건(`p.author.name LIKE %:name%`)을 분기하여 작성자 이름 기준 검색 및 페이지 이동 시 검색 조건 유지 구현[cite: 269]

---





