FROM resin/rpi-raspbian

#COPY ./sources.list /etc/apt/
#COPY ./sources.list.d /etc/apt/
RUN apt-get update

#RUN apt-get install oracle-java8-jdk
RUN apt-get install openjdk-8-jre

ADD ./tomcat8.tar.gz /opt
RUN (mv /opt/apache-tomcat* /opt/tomcat)
#ENV JAVA_HOME /usr/lib/jvm/java-8-oracle
#RUN wget http://tomcat.apache.org/tomcat-8.0-doc/appdev/sample/sample.war -P /opt/tomcat/webapps
ADD tomcat-users.xml /opt/tomcat/conf/
EXPOSE 8080
CMD ["/opt/tomcat/bin/catalina.sh", "run"]
