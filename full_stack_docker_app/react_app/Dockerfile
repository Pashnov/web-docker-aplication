# Base Image ubuntu
FROM ubuntu:18.04

# Installing dependencies
RUN apt-get update
RUN apt-get install -y curl

#RUN curl -sL https://deb.nodesource.com/setup_12.x | bash
# RUN apt-get install -y nodejs

RUN apt update
RUN apt -y install curl dirmngr apt-transport-https lsb-release ca-certificates
RUN curl -sL https://deb.nodesource.com/setup_12.x | bash

#RUN apt -y install curl dirmngr apt-transport-https lsb-release ca-certificates
#RUN curl -sL https://deb.nodesource.com/setup_10.x | bash
RUN apt update
RUN apt -y install gcc g++ make
RUN apt -y install nodejs

# coping the required application files
COPY . /react_app
WORKDIR /react_app/react_app

# building the spring boot app
RUN npm install

# running the spring boot app
CMD ["npm", "run", "prod"]
