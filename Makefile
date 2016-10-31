MAIN_CLASS=App
JAR=App

all:
	javac -d start/ src/$(MAIN_CLASS).java
	jar -cmf start/manifest.mf $(JAR).jar .
