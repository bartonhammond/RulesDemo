rm -rf c:\tools\tomcat\webapps\ROOT
rm -rf c:\tools\tomcat\webapps\RulesDemo
rm -rf c:\tools\tomcat\webapps\RulesDemo.war

cp -r target\site c:\tools\tomcat\webapps
mv c:\tools\tomcat\webapps\site c:\tools\tomcat\webapps\ROOT

cp target\RulesDemo.war c:\tools\tomcat\webapps