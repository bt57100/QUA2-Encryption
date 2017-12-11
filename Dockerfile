FROM java:8-jdk

RUN apt-get update && apt-get install -y --no-install-recommends openjfx=8u60-b27-4  && rm -rf /var/lib/apt/lists/*

COPY JavaFXProject2.jar JavaFXProject2.jar
CMD ["java","-jar","JavaFXProject2.jar"]
