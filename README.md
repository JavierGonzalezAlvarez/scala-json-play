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

## comprobar endpoint
1. desde postman:
GET: localhost:9000/lista
2. curl -v localhost:9000/lista

http://localhost:9000/


