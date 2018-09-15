## File Box Transfer

File Box Transfer is a tool for moving files between computers using only HTTP from web browsers.

> These operations should normally be completed with `scp`. There is a Windows version of `scp`
> named `pscp` which is part of `PuTTY`. Use those tools in preference if possible.

File Box Transfer (ftb) does not provide any security. 
- Any computer that can access the web application can upload and download files.
- The traffic to and from the web application is not encrypted.

It is intended for use when:
- Security is not required.
- An operating system does not the protocols to use `scp`.
- An operating system man not be configured to use the protocols for `scp`.

## Overview

File Box Transfer is a web application.  Once running a web browser may be used to connect to
the application, and files may be uploaded from the source computer, and then downloaded to the
destination computer. 

![application screenshot in Firefox](https://github.com/OliverPavey/file-transfer-box/blob/master/img/screenshot.png)

## Building

To build the application requires Java 8 and Apache Ant.  From the root of the project (which 
contains `build.xml`) run the command `ant`.  The web application JAR will be built and can then
be found as `docker\ftb.jar`.

## Running in Tomcat on Docker

Before running the application it must be downloaded and built, as above.

To host the application on a Tomcat 8 docker image (on a machine with Docker installed) open
a quick start docker terminal, change to the local folder `docker` folder containing `ftb.sh`
and run `./ftb.sh`.  The address of the application should appear in the output, e.g.

```
Browse to: http://192.168.99.100:8888/ftb/
```

When you are finished press CTRL+C.  The docker container will be removed.  Once the docker
container is deleted the files uploaded will no longer be available.

> `ftb.sh` is intended for running a local docker image only.
