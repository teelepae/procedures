ARG NODE_VERSION=20.15.1

FROM node:${NODE_VERSION}-alpine

RUN mkdir /src
WORKDIR /src

RUN npm install -g @angular/cli@18.1.1

COPY package.json package-lock.json ./
RUN npm ci

COPY . .
CMD ["ng", "serve", "--host", "0.0.0.0"]
