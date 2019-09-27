cd $(cd $(dirname $0); pwd)
./mvnw clean package -Dmaven.test.skip=true
