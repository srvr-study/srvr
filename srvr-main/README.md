# SRVR - main Server

## 기능 및 역할

front - clinet의 메인 페이지의 데이터를 CRUD를 담당합니다. 
메인 페이지는 구현되어가는 서버의 리스트를 실시간으로 데이터를 받아서 업데이트하는 기능을 가지고 있습니다. 

## 프로젝트 패키지 구조

```text
├── docs
│   └── asciidoc                            # 스프링 rest doc
└── main
    ├── java
    │   └── kr
    │       └── kro
    │           └── srvrstudy
    │               └── srvr_main
    │                   ├── config          # 스프링 설정관련 패키지
    │                   ├── domain          # 비지니스 로직계층 객체모델과 서비스 패키지   Layer-2
    │                   │   ├── model
    │                   │   └── service
    │                   ├── helper          # 레이어 아키텍쳐 전반에 활용할 유틸 패키지
    │                   ├── persist         # 데이터 계층 엔티티와 레포지토리 패키지      Layer-3
    │                   │   ├── entity
    │                   │   └── repository
    │                   └── presentation    # 표현 계층 모든 스타트 포인트 패키지        Layer-1
    │                       ├── controller
    │                       │   └── advisor
    │                       └── scheduler
    └── resources
        ├── db
        │   ├── migration
        │   └── seed
        └── static
            └── docs
```

### 이런 패키지 구조로 나타낸 이유

이 프로젝트에서는 3-Layer 아키텍처를 패키지 단에서부터 확실히 표현했습니다.
기존의 controller, server, repository 패키지로 하는 구조에서는 3-layer 외에도 같은 레벨에 다양한 패키지들이 있습니다. 
helper, config, scheduler, model, aop, filter, interceptor 등 이러한 패키지 들이 같은 패키지 레벨에 있다보니 응집성이 떨어지고 프로젝트 코드와 패키지 의존성을 파악하는데 방해한다고 생각이 들었습니다.
그래서 이러한 문제점을 해결하기 위해서 다음과 같이 presentation, domain, persist라는 3-tier 패키지를 앞단에 두고 각 layer에 연관된 패키지를 같이 두어 응집성과 패키지 의존성 관리를 쉽게 하고자했습니다.
레이어 끼리의 의존성은 자신의 레이어 혹은 바로 아래 계층의 레이어까지 접근이 가능하다. (단방향)

```text
┌──────────┬───────────────────────────────┐
│          │            1-layer            │
│          │          presentation         │
│          │                               │
│          │───────────────────────────────┤
│  global  │            2-layer            │
│  helper  │             domain            │
│          │                               │
│          │───────────────────────────────┤
│          │            3-layer            │
│          │            persist            │
│          │                               │
└──────────┴───────────────────────────────┘
```

* presentation - 모든 start 포인트 혹은 end 포인트 들
* domain - 비지니스 로직과 모델
* persist - entity, repository 그리고 관련된 모든 것들(컨버터 등)
* helper - 전반적으로 모든 레이어에서 사용되는 유틸성 클래스들

## 실시간 서버 데이터 구조

front-client와 실시간으로 데이터를 주고 받기 위해서 websocket을 사용했고 stomp을 사용해서 pub/sub 구조로 데이터를 받아오도록 했습니다.
