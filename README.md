# quickshare2 or how to deploy Clojure to Elastic Beanstalk

generated using Luminus version "2.9.11.44"

## Either use +war and select Tomcat 8 at Beanstalk

`lein uberwar`

and upload the .war file.

If you want it on toplevel, rename it to ROOT.war

If you keep the name, it will be installed at /quickshare2/

See https://docs.aws.amazon.com/elasticbeanstalk/latest/dg/java-tomcat-platform.html

## or skip +war and get a .jar and select Java 8 at Beanstalk

`lein uberjar`

and upload the .jar file

Verify by making sure

java -jar foo.jar

works.

See http://stackoverflow.com/questions/28120130/how-to-deploy-an-embedded-server-to-elastic-beanstalk

https://docs.aws.amazon.com/elasticbeanstalk/latest/dg/java-se-platform.html

## How to script deployment

https://github.com/weavejester/lein-beanstalk

https://docs.aws.amazon.com/elasticbeanstalk/latest/dg/eb-cli3.html
