# 패스트캠퍼스 강의 - Java/Spring 기반 서비스 개발과 MSA 구축(주문하기 API).

## 현재 작업중입니다.

## 프로젝트 설명
- 주문하기 서비스
- 패스트캠퍼스에서 Spring 기반 MSA 구축 강의를 들으며 Java17과 Spring3으로 버전업하여 재구축하였습니다.
- 강의 버전: Java11, Spring2.5.4
- 변경 버전: Java17, Spring3.3.0
- 레이어드 아키텍처 방식 채택

## 사용할 레이어드 아키텍처 구조
- interfaces layer
- application layer
- domain layer
  - 업무 개념과 업무 상황에 대한 정보, 업무 규칙을 표현하는 일을 책임진다.(가장 핵심 계층)
  - 이 계층에서는 업무 상황을 반영하는 상태를 제어하고 사용하며 그와 같은 상태 저장과 관련된 기술적인 세부사항은 인프라 스트럭쳐에 위임한다.
  - domain layer의 Service는 해당 domain의 전체적인 흐름을 파악할 수 있도록 구현되어야 한다.(추상화 레벨을 높여야 함)
  - 세세한 기술 구현은 Service가 아니라 infrastructure layer의 impl class에 위임한다.
  - domain layer의 코드들은 infrastructure의 기술 요구사항에 변동이 생겨도 수정하지 않을 수 있도록 작성되어야 한다.
- infrastructure layer


## Skill
<div>
    <div>
        <img src="https://img.shields.io/badge/Java(v17)-000000?style=flat&logo=openjdk&logoColor=white"/>
        <img src="https://img.shields.io/badge/Spring Boot(v3.3.0)-6DB33F?style=flat&logo=springboot&logoColor=white"/>
        <img src="https://img.shields.io/badge/Gradle-02303A?style=flat&logo=gradle&logoColor=white"/>
    </div>
    <div>
        <img src="https://img.shields.io/badge/Spring Data JPA-6DB33F?style=flat&logo=spring&logoColor=white"/>
        <img src="https://img.shields.io/badge/Flyway-CC0200?style=flat&logo=flyway&logoColor=white"/>
        <img src="https://img.shields.io/badge/MySQL-4479A1?style=flat&logo=mysql&logoColor=white"/>
        <img src="https://img.shields.io/badge/Docker-2496ED?style=flat&logo=docker&logoColor=white"/>
    </div>
</div> 
