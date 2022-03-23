FROM maven:3.8-openjdk-8-slim

WORKDIR /home
RUN mkdir coinanalyst
COPY coinanalyst/ coinanalyst

WORKDIR coinanalyst
RUN mkdir -p target

# ENTRYPOINT ["mvn"]

# CMD ["package", "install", "-DskipTests"]
