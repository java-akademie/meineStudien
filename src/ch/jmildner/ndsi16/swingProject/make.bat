del *.jar

javac -d . *.java

jar -cmf  manifest.mf swingProject.jar ch\jmildner\swingProject\*.class 

rd ch /s

set classpath=.;..\oracle.zip;.\swingProject.jar
java ch.jmildner.swingProject.AdressVerwaltungMain

pause


