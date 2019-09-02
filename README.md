# MillionConnections  
supported million TCP connections with multiplexing ports on one computer using Java Netty  
## linux local file handler optimization  
root environment  
`vim /etc/security/limits.conf`  
add the followings:  
`root soft nofile 1000000`  
`root hard nofile 1000000`  
`* soft nofile 1000000`  
`* hard nofile 1000000`  
restart PC  

## linux global file handler optimization  
`cat /proc/sys/fs/file-max`  
`vim  /etc/sysctl.conf`  
add:  
`fs.file-max = 1000000`  
make it work:  
`sysctl -p`  

##Start in Alibaba Cloud:  
set correct server IP in codes  
`mvn install`  
`java -jar millionServer-1.0-SNAPSHOT.jar  -Xms5g -Xmx5g -XX:NewSize=3g -XX:MaxNewSize=3g`  

#I love berber. you ..
