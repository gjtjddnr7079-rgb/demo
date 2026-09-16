
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

---

## 🔗 관련 소스 코드 링크
