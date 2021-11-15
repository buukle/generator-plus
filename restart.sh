kill -9  $(ps -ef | grep java | grep -v "grep" | awk '{print $2}')
nohup java -jar target/*.jar --spring.profiles.active=prod >/dev/null 2>&1 &