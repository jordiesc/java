#!/bin/bash
if [ "$1" != "" ]; then
    SERVERNAME=$1
else
    SERVERNAME="testjee"
fi
export SERVERNAME
PATH_SERVER_XML="./src/main/liberty/config/server.xml"

export VERSION="18.0.0.4"
export INSTALL_DIR="."
export SERVER="openliberty-javaee8"
URLs="http://central.maven.org/maven2/io/openliberty/${SERVER}/${VERSION}/${SERVER}-${VERSION}.zip"
echo "download file ..."
echo $URLs

echo $URLs
curl -O ${URLs}

 
unzip ${SERVER}-${VERSION}.zip 
#rm ${SERVER}-${VERSION}.zip 

./wlp/bin/server create $SERVERNAME
cp -f $PATH_SERVER_XML wlp/usr/servers/$SERVERNAME/

#cd wlp/usr/servers/$SERVERNAME/

source wlp/usr/servers/$SERVERNAME/server.env

sed -i -e "s/keystore_password/${keystore_password}/g" wlp/usr/servers/$SERVERNAME/server.xml
sed -i -e "s/SERVERNAME/${SERVERNAME}/g" build.gradle

shopt -s expand_aliases

alias serverstart='wlp/bin/server start $SERVERNAME'
alias serverstop='wlp/bin/server stop $SERVERNAME'



