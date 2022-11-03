# TeleMedicine_Project - 원격의료프로그램_졸업작품
<br>
<hr>

## 1. 프로젝트 개요 
> - 2020 펜데믹 시대에 맞서 환자들이 많아지는 가운데 비대면으로 환자들이 진료를 받아볼 수 있게하고 의사는 환자를 진료하고 처방전을
  프로그램을 개발한다.
> - 코로나 19(COVID-19)의 지속적인 영향에 따라 사람이 많이 몰리는 밀집 지역을 최대한 피하여 예방하여야 하는 사회적 분위기가 조성되고 있다. 직장이나 학교 내에서도 사회적 거리두기로 자리를 띄어 앉거나 원격 수업, 원격 업무 등이 시행되고 있으며 그 중 특히 병원은 기본적으로 의료행위를 하는 곳이자 병을 앓고 있는 사람들이 방문하여야 하는 곳이므로 인구 밀집 장소를 따져 보았을 때 가장 위험하고 예민한 장소라고 판단하였다. <br>
> - 따라서 병원 진료 또한 원격으로 진행할 수 있게 하도록 해당 프로젝트 주제를 선정하게 되었다.
  
## 2. 개발 환경
| 목록 | 내용 |
| ------------ | ------------- |
| 개발환경 | 안드로이드 스튜디오 4.1  |
| SDK |  SDK : Android 10.0 (Q)  |
| Java | 1.8.0_271  |
| 에뮬레이터 DPI|1440 x 2960, 560dpi |
 | 테스팅 단말기 |  Galaxy A8, Galaxy S8 |
 
 
 ## 3. ERD
 ![image](https://user-images.githubusercontent.com/110041859/199663651-ef35bbe8-c537-4948-bff3-e64d313fa33d.png)


## 4. 기능 별 시퀀스 다이어그램
   ### 4.1 로그인 ,회원가입 시퀀스 다이어그램
![로그인,회원가입 시퀀스 다이어그램](https://user-images.githubusercontent.com/110041859/199663762-711d2c8b-f4d2-4ecf-a9f8-b1131a32c8c1.png)
  <br>
  ### 4.2 예약 시퀀스 다이어그램
  ![예약 기능 시퀀스 다이어그램](https://user-images.githubusercontent.com/110041859/199663922-8703b2f0-05a3-493d-b10a-6bc7327cd2b4.png)
 <br>
  4.3 진료 시퀀스 다이어그램
  ![진료 하기 시퀀스 다이어그램](https://user-images.githubusercontent.com/110041859/199664090-5579a853-4415-489e-b4eb-b19827a0bcc1.png)
 
## 5. 상세 화면 
### 5.1 메인화면
![image](https://user-images.githubusercontent.com/110041859/199664692-336d0455-4819-4b86-a312-b8df24da73c2.png)
<br><br>
---
### 5.2 로그인 화면
![image](https://user-images.githubusercontent.com/110041859/199664760-82eefc39-73f9-44d0-b93a-6ae92759a5e0.png)
<br><br>
![image](https://user-images.githubusercontent.com/110041859/199664811-aebd67e2-3c44-48a7-aa9d-32dd7e86751a.png)
<br><br>
---
### 5.3 회원 건강정보 기재
![image](https://user-images.githubusercontent.com/110041859/199664850-87d22b4d-4db1-44b8-a02d-517ade74461c.png)
---
### 5.4 예약하기 /의료진 목록
![image](https://user-images.githubusercontent.com/110041859/199665403-cd3a3e53-f921-4740-8e08-dd92c01f1be1.png)
<br>
---
### 5.5 예약화면 
![image](https://user-images.githubusercontent.com/110041859/199665471-d7a6deca-6888-4464-9c11-4fbd3e21857c.png)
<br><br>
![image](https://user-images.githubusercontent.com/110041859/199665527-f9b59d88-a447-4175-9d62-54ee75c9d3eb.png)
---

### 5.6 예약 현황
![image](https://user-images.githubusercontent.com/110041859/199665728-24e6c795-f0dc-4d1a-a2b6-1cd83224d772.png)
<br>
---
### 5.7 진료
![image](https://user-images.githubusercontent.com/110041859/199665829-d0b91c77-7478-4f2b-a3f2-da57d4ba2ca4.png)
<br><br>
![image](https://user-images.githubusercontent.com/110041859/199665879-14c2e609-8d75-4daf-9c60-09f3b4120c91.png)
--- 
### 5.8 처방전 작성
![image](https://user-images.githubusercontent.com/110041859/199666093-bcffdc0d-7bf8-457e-877e-fa466b020b8a.png)
<br><br>
![image](https://user-images.githubusercontent.com/110041859/199666125-5c6f795b-c5d8-4eb9-8505-99821e539093.png)
--- 
### 5.9 마이페이지
![image](https://user-images.githubusercontent.com/110041859/199666181-30aec7bf-dc0e-4c10-8377-0222533b8d36.png)
---
---

## 6. 역할
| 이름 | 내용 |
| ------------ | ------------- |
| 주환오 | - 환자 예약하기 기능<br> - 회원가입 제약조건 구성 <br> - 의사 리스트 리사이클러뷰<br> - 신규 가입 회원 건강기록 작성<br> - Foreground를 활용한 예약 시간 알람 <br> - 테이블 기술서, ERD 작성 <br> - PHP Myadmin 데이터베이스 설정 <br> - 쓰레드를 활용한 시계 사용 <br> |
| 김덕훈 | - 채팅을 활용한 진료하기<br> - 뉴스 기능구현 <br> - 처방전 작성 및 열람, 이미지, pdf 저장 <br> - 예약 현황 리사이클러뷰  <br> - 파이어 베이스 데이터베이스 설정 <br> - 비밀번호 변경 <br>  - 영상통화 기능을 활용한 진료하기 |
| 이원준 | - 메인 레이아웃 UI 구성<br> - 예약 레이아웃 UI 구성<br> - 진료 레이아웃 UI 구성<br> - 개인정보 확인 및 수정<br> - 로그인, 로그아웃 기능 구현<br>  - 건강기록 확인 및 수정<br>|

## 7. 기타 
> 기타사항은 최종보고서에 기록하였음. 
