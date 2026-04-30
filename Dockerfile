FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY recipeBook/gradlew .
COPY recipeBook/gradle gradle
COPY recipeBook/build.gradle .
COPY recipeBook/settings.gradle .
COPY recipeBook/src src

RUN chmod +x gradlew
RUN ./gradlew build -x test

EXPOSE 8080

CMD ["java", "-jar", "build/libs/recipeBook-0.0.1-SNAPSHOT.jar"]