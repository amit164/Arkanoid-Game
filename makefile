compile: bin
	javac -d bin -cp biuoop-1.4.jar src/*.java src/animations/*.java src/backgrounds/*.java src/gamearkanoid/*.java src/gameobject/*.java src/geometry/*.java src/graphics/*.java src/interfaces/*.java src/levels/*.java src/listeners/*.java

jar:
	jar cfm0 Arknoid.jar MANIFEST.MF -C bin .
run:
	java -jar Arknoid.jar
bin:
	mkdir bin
