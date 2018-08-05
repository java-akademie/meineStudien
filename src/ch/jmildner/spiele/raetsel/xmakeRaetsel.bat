set comp=javac
set comp=jikes

set jar=raetsel
set pcks=ch\jmb\spiele\raetsel
set pckp=ch.jmb.spiele.raetsel

del *.zip
del *.jar
del *.class 

jar cfM %jar%.zip *.*

%comp% -d . Raetsel.java

pause

jar -cf  %jar%.jar %pcks%\*.class 

rd /s ch


set classpath=.\%jar%.jar;%classpath%
java %pckp%.Raetsel

pause