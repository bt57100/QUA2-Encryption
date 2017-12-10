FROM java:latest

RUN apt-get update && apt-get install -y --no-install-recommends openjfx && rm -rf /var/lib/apt/lists/*

COPY JavaFXProject2.jar JavaFXProject2.jar
CMD ["java","-jar","JavaFXProject2.jar"]