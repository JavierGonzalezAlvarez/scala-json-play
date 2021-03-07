# Play Framework en Scala - MVC

## instalar sbt en linux
https://www.scala-sbt.org/download.html

## crear proyecto
$ sbt new playframework/play-scala-seed.g8
name [play-scala-seed]: api (nombre de la app)

## crear controller
app/controllers/listaController

## crear carpeta models
api/app

## run proyecto
cd api
$ sbt run

## GET. comprobar endpoint
1. desde postman:
GET: localhost:9000/lista
2. curl -v localhost:9000/lista

http://localhost:9000/lista
http://localhost:9000/lista/1
http://localhost:9000/lista/4

## POST. comprobar endpoint
curl --location --request POST 'localhost:9000/lista' \
--header 'Content-Type: application/json' \
--data-raw '
{    
"name": "ana",
"isOk": false,
"address": "uria street"
}
'

## postman
{    
"name": "ana",
"isOk": false,
"address": "uria street"
}

