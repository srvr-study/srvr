### local Database 세팅 하는 방법

1. docker desktop install
   * [mac](https://docs.docker.com/desktop/mac/install/)
   * [window](https://docs.docker.com/desktop/window/install/)
2. 프로젝트 루트에서 `cd docker`
3. docker desktop 실행 후 터미널에 `docker-compose up -d` 명령어 실행.

#### 주의사항
* user, password - root
* local 개발용으로만 사용
* feature 서버가 늘어남에 따라 database 늘려야할땐 init 안의 01-databasees.sql에 추가 작성

### 기능 서버들

#### main

srvr의 엔트리 페이지를 담당하는 서버. 각각의 기능 서버의 대한 데이터를 담당하고 있습니다. 

* [ERD](https://www.erdcloud.com/d/htMw4QEQwPe8CpwFW)
