FROM openjdk:17
LABEL authors="LaaLkA"

COPY out/artifacts/JavaJunior_lesson04_homework_jar/JavaJunior_lesson04_homework.jar /tmp/JavaJunior_lesson04_homework.jar
WORKDIR /tmp

CMD ["java", "-jar", "/tmp/JavaJunior_lesson04_homework.jar"]