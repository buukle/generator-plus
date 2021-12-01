#基础镜像，如果本地没有，会从远程仓库拉取。
FROM openjdk:8-jdk-alpine
#工作目录
WORKDIR /app/
EXPOSE 80
#拷贝本地文件到镜像中
COPY target/*.jar .
#指定容器启动时要执行的命令，但如果存在CMD指令，CMD中的参数会被附加到ENTRYPOINT指令的后面
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","generator-plus-web-RELEASE.jar","--spring.profiles.active=prod"]
