# ChillStock - 식재료 전문 3PL WMS

> 지역 농민과 상인을 위한 식재료 물류 시스템

---
>velog : https://velog.io/@dlwjdtjq1234/ChillStock식재료-전문-3pl-wms

## 목차

1. 프로젝트 소개  
2. 특징  
3. 기능 설명  
4. 기술 스택  
5. 프로젝트 목표  
6. 프로젝트 구조  
7. 사용 방법  
8. 실행 중 발생할 수 있는 문제 및 해결 방법  
9. 향후 개선 및 기능 추가  
10. 향후 방향성

---

## 1. 프로젝트 소개

ChillStock은 식자재 창고에서 공간 활용을 최적화하고, 효율적인 창고 관리를 지원하는 시스템입니다.  
본 시스템은 창고에 들어오는 식재료의 **입고**, **출고**, **재고 현황**, **창고 가용 공간 확인**을 효율적으로 처리할 수 있도록 설계되었습니다.

본 프로젝트는 식재료 유통과 관련된 다양한 상황을 염두에 두어 모델링되었으며,  
**공간 관리 최적화**와 **온도에 민감한 식품 안전성** 확보에 중점을 두었습니다.  
이 시스템은 식재료 유통업체 및 대형 창고 운영자에게 창고 공간의 최적화된 관리를 제공하여  
운영 효율성을 높이고 불필요한 비용을 절감하는 데 도움을 줍니다.

---

## 2. 특징

### 2-1. 도메인 중심 + 다형성 활용한 유연한 구조

- 초반에는 계층형 구조(Controller → Service → Repository)로 시작했지만, 도메인 간 연관이 많아지며 도메인 기반 구조로 리팩토링  
- 구역(Area), 창고(Warehouse), 상품(Product) 등 도메인별로 모듈 분리  
- 인터페이스 기반 설계로 테스트 및 기능 확장 용이  

**기존 구조**  
![Image](https://github.com/user-attachments/assets/ed3b4f1a-e366-4e24-892c-7b6d0699b5c5)


**도메인 구조**  
![Image](https://github.com/user-attachments/assets/44a622cd-edb3-4645-9770-989307df879f)
---

### 2-2. 함수형 프로그래밍과 람다 스트림의 활용

- 반복되는 조건문 추상화(runIfTrue), 스트림 기반 데이터 가공, Optional 활용  
- Function, Supplier, Consumer 등의 함수형 인터페이스 활용  
- 코드 가독성과 유지보수성 향상  

![Image](https://github.com/user-attachments/assets/8f47b9b8-d3be-444f-baf4-35ebd3b27b4b)

---

### 2-3. 협업 도구와 이슈 기반 개발

- GitHub 기반 협업 환경 구축  
  - Issue 생성 → 브랜치 생성 → PR → Merge 흐름 유지  
- 코드 리뷰를 통한 품질 개선  
- Notion을 통해 일정 및 역할 분담 관리  

![Image](https://github.com/user-attachments/assets/3788acdf-92d8-4996-b58f-883cca1409bb)

---

## 3. 기능 설명

### 3-1. 주요 기능

- 입고, 출고, 재고관리 자동화  
- 입고 / 출고 시 관리자 승인 기능  
- 관리자 / 화주 인증 및 권한 분리  

### 3-2. 상세 기능

#### 1) 로그인
- 총관리자 / 일반 회원 인증 및 인가

#### 2) 회원 관리 (총관리자)
- 전체 회원 목록 조회  
- 특정 회원 상세 조회  
- 회원 정보 수정 및 삭제  
- 탈퇴 회원 조회  

#### 3) 회원 관리 (화주)
- 내 정보 조회 / 수정 / 탈퇴 / 로그아웃

#### 4) 입고 관리
- 입고 요청 승인 / 취소  
- 대기 입고 요청 목록 조회  
- 사업체 및 등록 제품 목록 확인  
- 재고 변경 이력 확인  

#### 5) 출고 관리
- 출고 요청 승인 / 취소  
- 출고 대기 목록 / 전체 목록 조회  
- 출고 요청 / 출고 요청 조회  

#### 6) 재고 히스토리 관리 (관리자)
- 전체 재고 변경 이력 조회  

#### 7) 창고 관리 (관리자)
- 전체 / 도시별 창고 정보 조회  
- 창고 상세 조회  
- 창고 생성  
- 창고별 구역 생성 (가용 공간 고려)  
- 실시간 남은 공간 확인  
- 구역 가용 공간 기준 입고 승인 여부 판단  

---

## 4. 기술 스택

- **Language**: Java  
- **Database**: MySQL  
- **연동 기술**: JDBC  
- **IDE**: IntelliJ  

---

## 5. 프로젝트 목표

- SOLID 원칙 적용  
- 3계층 구조 설계 (Repository, Service, Controller)  
- Database 모델링 (3정규화)  
- GitHub를 활용한 협업 (GitFlow 전략, Pull Request, Issue Board)  
- Notion 기반 문서화 및 일정 관리  

---

## 6. 프로젝트 구조

### 8-1. 아키텍처  
![Image](https://github.com/user-attachments/assets/7b624559-e697-4be4-9d9e-d0ead675664f)


### 8-2. ERD  
관계형 데이터베이스 구조 설계 (3정규화 적용)
![Image](https://github.com/user-attachments/assets/54887793-7dca-401e-8a3e-791f82eb888f)

### 8-3. 클래스 다이어그램  
도메인 객체 간 상호작용 시각화
![Image](https://github.com/user-attachments/assets/0084b2aa-b2cc-4186-958a-33289c08e132)

![Image](https://github.com/user-attachments/assets/1e4f47be-3dd6-40c4-b35a-493101308860)

![Image](https://github.com/user-attachments/assets/9273a717-f835-4a00-a4ec-45a4cb505206)

---

## 7. 사용 방법

1. **Javadoc 확인**  
   `/javadoc/index.html` 파일을 열어 API 문서 확인

2. **데이터베이스 구성**  
   아래 SQL 파일을 순서대로 실행
sql/SchemaUser.sql
sql/Table.sql
sql/Constraint.sql
sql/Procedure.sql
sql/Trigger.sql
sql/data.sql
3. **DB 연결 설정**  
`/common/Ignore` 파일에서 사용자 환경에 맞는 DB 주소 및 비밀번호 설정

---

## 8. 실행 중 발생할 수 있는 문제 및 해결 방법

| 번호 | 문제 | 원인 | 해결 방법 |
|------|------|------|------------|
| 1 | DB 연결 실패 | DB 주소 또는 계정 정보 오류 | `/common/Ignore` 내 설정값 확인 |
| 2 | 테이블/프로시저 미생성 | SQL 스크립트 실행 누락 | 아래 명령어 root 계정에서 실행  
`SET GLOBAL log_bin_trust_function_creators = 1;` |
| 3 | JDBC 드라이버 오류 | 드라이버 미설치 또는 인식 불가 | JDBC 드라이버를 프로젝트에 추가 및 경로 확인 |

---

## 9. 향후 개선 및 기능 추가

- 아이디 / 비밀번호 찾기 기능  
- 콘솔 기반 → Web 기반(CSR 또는 SSR) 리팩토링  
- 배송지 거리 계산 API 연동으로 Micro Fulfillment 구현  
- 함수형 프로그래밍 기반 리팩토링 지속 진행  

---

## 10. 향후 방향성

- 코드 스타일 가이드 작성 및 팀 내 공유  
- Atomic Commit 전략 적용  
- 브랜치 전략 / 코드 리뷰 / 이슈 관리 체계 강화  
- 구체적인 리뷰 룰 정립  
- 신뢰 기반 협업 문화 유지 및 고도화  

---
