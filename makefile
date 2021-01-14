compile: bin
	javac -d bin -cp biuoop-1.4.jar src/*.java
jar:
	jar cfm0 ArknoidGame.jar MANIFEST.MF -C bin .
run:
	java -jar ArknoidGame.jar
bin:
	mkdir bin
