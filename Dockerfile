# JDK 17 버전의 Docker 이미지 사용
FROM bellsoft/liberica-openjdk-alpine:17

# Gradle로 빌드할 jar파일의 위치를 변수로 설정
ARG JAR_FILE=build/libs/*.jar

# JAR_FILE 변수에 지정된 파일을 app.jar라는 이름으로 컨테이너에 추가
COPY ${JAR_FILE} app.jar

# 컨테이너가 실행될 때 기본적으로 실행될 명령어 - Java 어플리케이션 실행 명령어
ENTRYPOINT ["java","-jar","/app.jar"]