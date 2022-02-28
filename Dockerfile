FROM openjdk:17-alpine
RUN apk add curl jq
WORKDIR /usr/share/udemy

ADD healthcheck.sh healthcheck.sh

ENTRYPOINT sh healthcheck.sh