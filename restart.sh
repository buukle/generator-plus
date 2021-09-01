kill -9  $(ps -ef | grep buukle-generator-*.jar | grep -v "grep" | awk '{print $2}')
nohup java -jar target/*.jar >> /opt/logs/buukle-generator/generator.log 2>&1 &