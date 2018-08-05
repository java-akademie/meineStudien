call clear
set path=c:\utils\Java\jdk1.5.0_05\bin;%path%

set frame=LottoFrame
set applet=LottoApplet
set archivName=lotto
set pckSName=ch\jmildner\spiele\lotto
set pckPName=ch.jmildner.spiele.lotto

jar cfM %archivName%.zip *.*

javac -d . *.java

java %pckPName%.%frame%

appletviewer %applet%1.html

jar -cmf  manifest.mf %archivName%.jar .\%pckSName%\*.class 

rd /s ch

appletviewer %applet%2.html

set classpath=.\%archivName%.jar;%classpath%

java %pckPName%.%frame%
