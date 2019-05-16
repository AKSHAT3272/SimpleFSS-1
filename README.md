# SimpleFSS
Simple File Sharing System in Java

# Introduction
## 1.1 Purpose

The purpose of this project is to create a simple file-sharing system in 
which the clients can access files from a pre-determined directory.

## 1.2 Scope  

The scope of the Simple File-Sharing System (FSS) is for it to be simple
and provide the ability for a client to access the website and services 
hosted by the Server through a Web Server. The Server also runs a logger
which logs connections made and records the files accessed. The system 
has no login systemas it meant to be open to public.

# Design Overview  
## 1.1 Overall class structure  
![Class structure](https://github.com/lynoska/SimpleFSS/blob/master/img/class-architecture.PNG)

## 1.2 Logs structure
```
May 14, 2019 9:38:21 PM LoggerClient connection
INFO: Lynoska/192.168.0.6 - connection established

May 14, 2019 9:38:21 PM LoggerClient HTTPRequest
INFO: Lynoska/192.168.0.6 - HTTP Request 
GET /index.html HTTP/1.1
Filename: Home\/index.html
Host: localhost:4444
Connection: keep-alive
Cache-Control: max-age=0
Upgrade-Insecure-Requests: 1
User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.131 Safari/537.36
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3
Referer: http://localhost:4444/Videos/Videos.html
Accept-Encoding: gzip, deflate, br
Accept-Language: en-US,en;q=0.9
```

## 1.3 Website structure  
![Website structure](https://github.com/lynoska/SimpleFSS/blob/master/img/web-structure.PNG)
