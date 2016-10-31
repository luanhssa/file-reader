@ECHO OFF
javac -d start\ src\App.java
jar -cmf start\manifest.mf App.jar .
