FROM flink:1.14.3-scala_2.12-java8

ENV DISABLE_JEMALLOC true
# COPY ./*.jar .

ENTRYPOINT ["tail", "-f", "/dev/null"]