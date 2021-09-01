kill -9  $(ps -ef | grep java | grep -v "grep" | awk '{print $2}')
chmod u+x restart.sh
nohup java -jar target/*.jar >> /opt/logs/buukle-generator/generator.log 2>&1 &