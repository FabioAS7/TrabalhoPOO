rmdir /S /Q ".\build\"
mkdir build
javac -d ./build -cp .;./lib/mariadb-java-client-3.5.1.jar ./src/utils/*.java ./src/service/*.java  ./src/model/*.java  ./src/controll/*.java  ./src/view/*.java
java -cp .;./build;./lib/mariadb-java-client-3.5.1.jar %1