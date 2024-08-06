# URL 단축 서비스
> original url을 넣은 후 단축 URL을 생성하면 단축된 URL이 생성되는 애플리케이션 입니다.

## 📚 목차
- [팀원소개](#-팀원-소개)
- [타임라인](#-타임라인)
- [시각화 구조](#-시각화-구조)
- [실행화면](#-실행화면)

## 🧑‍💻 팀원 소개
| <img src="https://github.com/devKobe24/BranchTest/blob/main/IMG_5424.JPG?raw=true" width="200" height="200"/> |
| :-: |
| [<img src="https://hackmd.io/_uploads/SJEQuLsEh.png" width="20"/> **Kobe**](https://github.com/devKobe24) |

## ⏰ 타임라인
프로젝트 진행 기간 | 24.08.06.(화) ~ 24.08.06.(화)

## 👀 시각화 구조
```
    .
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── devkobe
    │   │           └── shortenurlservice
    │   │               ├── ShortenUrlServiceApplication.java
    │   │               ├── controller
    │   │               │   └── ShortenUrlRestController.java
    │   │               ├── domain
    │   │               │   ├── ShortenUrl.java
    │   │               │   └── exception
    │   │               │       ├── LackOfShortenUrlKeyException.java
    │   │               │       └── NotFoundShortenUrlException.java
    │   │               ├── dto
    │   │               │   ├── create
    │   │               │   │   ├── CreateShortenUrlRequest.java
    │   │               │   │   └── CreateShortenUrlResponse.java
    │   │               │   └── read
    │   │               │       ├── ReadShortenUrlRequest.java
    │   │               │       └── ReadShortenUrlResponse.java
    │   │               ├── handler
    │   │               │   └── GlobalExceptionHandler.java
    │   │               ├── repository
    │   │               │   ├── MapShortenUrlRepository.java
    │   │               │   └── ShortenUrlRepository.java
    │   │               └── service
    │   │                   └── SimpleShortenUrlService.java
    │   └── resources
    │       ├── application.properties
    │       └── static
    │           └── index.html
    └── test
        ├── controller
        │   └── ShortenUrlRestControllerTest.java
        ├── service
        ├── SimpleShortenUrlServiceTest.java
        └── SimpleShortenUrlServiceUnitTest.java
```

## 📺 실행화면
- URL 단축 서비스 실행화면 <br/>
<img src= "https://github.com/devKobe24/images2/blob/main/ShortenUrlService.png?raw=true">
