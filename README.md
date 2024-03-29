# PROJECT : APARTMENT-HOW-MUCH

## 아파트 매매 실거래가 조회 프로그램 (개인 프로젝트)
<br><br>
![img.png](assets%2Fimg.png)

### 1. 이 프로그램에 대하여
> 아파트의 사양과 매매 실거래가 정보를 쉽고 빠르게 조회할 수 있는 프로그램입니다.
> 
> 부동산을 매매할 경우 거래 당사자는 30일 이내에 시장, 군수, 구청장에게 반드시 신고를 해야 하며(「부동산 거래신고 등에 관한 법률」 제3조제1항) 정부는 이 정보를 취합하여 공공데이터포털(data.go.kr)을 통해 파일 또는 API 형식으로 제공합니다.
> 
> 본 프로그램은 공공데이터포털에서 제공하는 데이터를 수집하고 정리하여 제작하였습니다.
> 
> <br>
>
> 데이터 범위: 2020년 1월 ~ 2022년 5월 (1661163개의 거레 데이터)<br>
> 현제 데이터 업데이트 자동화 기능 개발을 계획중에 있습니다.
  
<br>

### 2. 다운로드 
> * 프로그램 다운로드 링크
>   * For macOS
>     * [프로젝트 Executable jar file download](https://drive.google.com/file/d/1K1PfX7-yN-BBPBzlVH1mjxQsK3dtnXr0/view?usp=share_link)
>     * JDK 17 이하 환경에서 동작을 보장하지 않습니다.
>   * For Windows
>     * (준비중)

[//]: # (>     * [윈도우용 .exe 실행파일 download]&#40;https://drive.google.com/file/d/1ufpRbkMK4sxXT5i-YzP2TDq0ImPdut-r/view?usp=share_link&#41;)

[//]: # (>     * 윈도우 64bit 환경에서 실행 가능하며 JRE를 포함하고 있어 JDK 환경과 무관하게 실행 가능합니다.)

[//]: # (>     * 실행파일에 인증서가 없어 실행시 경고 메세지가 출력됩니다. 악성 코드는 없으니 강제 실행하셔도 됩니다&#40;악성 코드를 만들 능력이 없습니다&#41;. )
> * 개발문서
>   * [download - dev_document(pdf)](https://drive.google.com/file/d/1uSMxHxRhqIvmre2-DTt-DxtbuGUoBxku/view?usp=sharing)
>   * 프로젝트를 마치며 국비교육과정 강의실에서 진행한 최종 발표 프레젠테이션 자료입니다.
> 
<br>



### 3. 기술 스택
> * oracle open java jdk-17.0.2.jdk (arm64)
> * javafx-sdk-17.0.2 // GUI Framework
> * MySQL 8.0.28 // database
> * docker 20.10.3 // DB container in NAS server


<br>

### 4. 프로젝트에 대하여
> * 국비교육과정에서 진행한 개인 프로젝트
>   * 교육 커리큘럼에서 제시한 목표
>     * Java 와 Database 연동, SQL 쿼리를 사용한 데이터 처리
>     * Graphic User Interface
> * 스스로 공부하고 적용한 추가 기술
>     * JavaFX - 커리큘럼의 AWT 기술이 Apple Silicon 칩을 지원되지 않아 JavaFX 가술 적용 
>     * Docker - 24/7 서비스를 위해 DB를 NAS 서버에 컨테이너로 서비스
>     * MVC 디자인 패턴 - JavaFX가 MVC 디자인 패턴에 특화되어 있어 적용
>     * Git - 첫 프로젝트를 진행하며 git 을 통한 본격적인 형상관리 시스템 경험  
>  

<br>

### 5. 프로젝트를 진행하며 배운점, 문제와 해결
>  * 객제치향 프로그래밍의 본질에 대한 이해와 적용
>    * 캡슐화, 상속, 추상화, 다형성의 특징을 주도적으로 적용하며 프로그램 개발
>  * 기술을 스스로 습득하는 방법 - JavaFX
>    * JavaFX는 한국어 자료가 거의 없으나 영어로 쓰여진 공식 Documentation, Stack Overflow, 외국의 블로그/유투브 등을 참고하여 이해-습득-적용
>    * 교육받은 GUI 프레임워크는 Java AWT 였으나 AWT는 apple silicon MacOS 지원하지 않고 지금은 사용하지 않는 너무 오래된 기술
>    * Java GUI 프레임워크중 최근까지 지속적으로 업데이트/배포 되고 있는 JavaFX를 독학하여 개발
>  * 실용성과 완성도를 위해 찾은 해법 - Docker
>    * 교육과정에서는 개발용 컴퓨터에 DB를 설치하여 연동하는 방법만 제공 -> 따라서 개발 환경 이외의 컴퓨터에서 프로젝트를 실행하지 못하는 문제 발생
>    * 국비교육과정에서 교육한 Oracle DB는 MacOS를 지원하지 않아 DB 대응책으로 Docker 의 전반적인 사용법을 독학(강사님께서 Docker 사용 경험 x)
>    * Oracle 대신 Docker 를 공식 지원하는 MySQL 을 습득하여 사용
>    * 개인 NAS 위에 MySQL Container 을 생성하고 특정 주소와 포트를 개방하여 프로젝트 프로그램이 DB에 접근하는 방법으로 해결  
>    * 호스팅 서비스가 아닌 홈 네트워크를 개방하여 서비스하는 과정에서 기초적인 네트워크 지식과 보안의 중요성에 대한 인식 획득
>  * 보안에 대한 인식 - DB 접속 정보 숨기기
>    * 코드 전체를 github 공개 저장소에 업로드시 DB 접속 정보가 노출이 되고 이는 악의적 접근 가능성이 발생함을 인식
>    * 트위터의 다른 현업 개발자분께서 .gitignore 목록에 포함된 env 파일로 서버 정보를 관리하는 아이디어 조언을 받아 해결
>  * 최적화 고민 - 검색 SQL Query
>    * 16만개가 넘는 레코드를 검색하는 과정에서 Query를 어떻게 작성하는지에 따라 발생하는 지연 시간이 극명하게 차이남을 인식
>    * 수많은 쿼리를 테스트하고 적용해본 결과 Primary Key 기반 검색의 속도가 보다 빠름을 이해
>    * 검색 Query 를 만드는 알고리즘 코드 링크
>      * [TableSearchDAO.java](https://github.com/dpcalfola/apartment_howmuch/blob/main/src/main/java/com/folaSmile/apartSearch/databaseModel/tableModel/TableSearchDAO.java)
>    * 적용하지 못한 최적화 아이디어
>      1. 조인이 발생하지 않는 단순 검색이 많으므로 전통적인 RDBMS 대신 NoSQL 사용
>      2. 검색 기준에 따라 서로 다른 Primary Key 혹은 Index 를 갖는, 별도의 테이블을 여러개 만들어 운영
>    * 이후 RDBMS 이해도를 제고하기 위해 SQLD 자격증 취득(2022년 7월)

<br> 

### 6. 프로젝트 진행 당시 개발 과정을 기록하고 정리하던 노션 페이지

> [![Notion Badge](https://img.shields.io/badge/APARTMENT_HOW_MUCH-808080?style=for-the-badge&logo=NOTION&logoColor=white&link=https://twitter.com/dpcalFola)](https://www.notion.so/PROJECT-APARTMENT-HOW-MUCH-c5e2a8a7cdff4c07ab3452ad95005020)
