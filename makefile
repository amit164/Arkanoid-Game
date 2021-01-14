compile: bin
	find src | grep .java > out.txt
	javac -d bin -cp biuoop-1.4.jar @out.txt
	
jar:
	jar cfm arkanoidGame.jar MANIFEST.MF -C bin . -C resources .

run:
	java -cp biuoop-1.4.jar:bin:resources arkanoidGame

bin:
	mkdir bin
