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

## 각 레이어별 요구 클래스 정리
 - XXXCommand == 명령 성격
 - XXXCriteria == 조회 성격
 - XXXInfo == 객체에 대한 리턴

## map struct 라이브러리
- mapping 라이브러리
- 보통 복잡한 애플리케이션을 만들 때 각 레이어 별로 각자의 관심 분야만을 집중하게 관리하도록 관심사를 분리하여 개발해야지만 레이어별로 로직을 갈아 끼우기 쉽고, 각 레이어의 독립성이 보장됩니다.
- 그렇게 관심사를 나누어 개발을 하다 보면 레이어에서 다른 레이어로 요청을 넘기고 받을 때 해당 레이어가 요구하는 형태의 클래스 객체로 변환해야합니다. 예를 들어 interfaces 레이어의 Controller에서 facade나 domain 레이어로 넘길 때 dto를 command나 criteria를 변환해서 넘겨야 하고 반대의 경우도 domain에서도 원본인 Entity를 Info 계열의 정해진 반환 객체 형태로 변환해서 넘기는데 이런식의 컨퍼트 맵핑 로직이 많습니다.
- 근데 일련의 변환 과정을 사람이 매번 코드로 치는 것은 실수를 동반할 수 있고 불필요한 시간이 소요됩니다. 그럴 때 사용하는 맵핑 라이브러리 입니다.
- 왜 model mapper가 아니라 map struct인가?
  - 동작 방식과 성능에 차이가 있습니다.
  - model mapper는 리플렉션 방식입니다. 그래서 뭔가 코드가 명확하게 눈에 보이지 않고 뒷단에서 리플렉션 로직이 돌면서 source와 target을 변환해주는 매커니즘을 사용합니다.
  - 반면에 map struct는 개발자가 명시적으로 인터페이스를 선언하고 source와 target을 지정하고 별도의 특정한 규칙이 있다면 해당 규칙만 지정해주면 뒷단의 map struct 라이브러리가 해당 인터페이스를 보고 코드를 구현해줍니다.
  - 여기서 나오는 차이점이 성능입니다. 당연하게도 리플렉션 기반으로 동작하는 라이브러리(model mapper) 보다 코드를 만들어서 만들어진 코드가 동작하는 라이브러리(map struct)가 훨씬 성능이 빠릅니다.
  - 또한 model mapper는 개발중에 의도와 다르게 매핑되는 경우(a -> b가 되어야 하는데 a -> c가 되는 경우 등)나 맵핑이 되지 않는 경우가 생겼을 때 그 이유를 찾아야 하는데 리플렉션 방식은 찾기가 생각보다 쉽지 않습니다.
  - 반면에 map struct는 빌드시에 코드가 생성되기 때문에 제너레이트 된 코드를 보면서 원인을 찾아갈 수 있어서 좀 더 유리하다고 할 수 있습니다.
- map struct를 사용할 때 주의점
  - 변환 선언한 그 클래스 내에 컬렉션 계열이 있으면 그 컬렉션 자체의 맵핑도 한번 더 해줘야 합니다.
  - 무슨 이야기냐 하면 Dto를 command로 변환하는 기본 매퍼(itemDto -> itemCommand) 이외에도 itemDto 내의 collection 요소, 즉 ItemOptionGroupDto 정보에 대한 맵핑도 별도로 선언을 해줘야 에러가 발생하지 않습니다.(ItemOptionGroupDto -> ItemOptionGroupCommand)
  - ex:
```java
    // itemDto -> itemCommand
    @Mappings({@Mapping(source = "request.itemOptionGroupList", target = "itemOptionGroupRequestList")})
    ItemCommand.RegisterItemRequest of(ItemDto.RegisterItemRequest request);

    // itemDto안에 collection 형태의 itemOptionGroupList가 있으므로 추가로 매핑 선언
    @Mappings({@Mapping(source = "itemOptionList", target = "itemOptionRequestList")})
    ItemCommand.RegisterItemOptionGroupRequest of(ItemDto.RegisterItemOptionGroupRequest request);

    // itemOptionGroupList 안에도 itemOptionList가 collection 형태로 있으니까 추가로 매핑 선언
    ItemCommand.RegisterItemOptionRequest of(ItemDto.RegisterItemOptionRequest request);
```

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
