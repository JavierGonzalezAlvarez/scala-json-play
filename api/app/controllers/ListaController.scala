package controllers

import javax.inject._
import play.api._
import play.api.mvc._

//importar json formatter
import play.api.libs.json._
/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class ListaController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  //the model. GET
  case class ListaItem(id: Long, name: String, isOk: Boolean, address: String)
  //json
  implicit val todoListaJson = Json.format[ListaItem]
  val Lista = List(ListaItem(1, "javier", true, "oxford street"),
              ListaItem(2, "juan", false, "alfonso X street"),
              ListaItem(3, "ana", false, "uria street")
              )

  def getAll(): Action[AnyContent] = Action {
    if (Lista.isEmpty) {
      NoContent
    } else {
      Ok(Json.toJson(Lista))
    }
  }

  def getId(id: Long) = Action {
    val foundId = Lista.find(_.id == id)
    foundId match {
      case Some(id) => Ok(Json.toJson(id))
      case None => NotFound(Json.obj("Lo siento" -> s"No hay id: $id"))
      //case None => NotFound
      //case None => NoContent
    }
  }

  //the model. POST
  //case class NewListaId(id: Long, name: String, isOk: Boolean, address: String)
  case class NewListaId(name: String, isOk: Boolean, address: String)
  implicit val newListaJson = Json.format[NewListaId]
  //crear objeto del json
  def addNewId() = Action { implicit request =>
    val content = request.body
    val jsonObject = content.asJson
    val todoListItem: Option[NewListaId] =
      jsonObject.flatMap(
        Json.fromJson[NewListaId](_).asOpt
      )
    //añadir objeto
    todoListItem match {
      case Some(newItem) =>
        val nextId = Lista.map(_.id).max + 1
        val toAdd = ListaItem(nextId, newItem.name, newItem.isOk, newItem.address)
        val y = toAdd :: Lista  //se añade de derecha a izquierda
        Ok(Json.toJson(y))
        //Ok(Json.toJson(toAdd))
        //Created(Json.toJson(toAdd))
      case None => BadRequest
    }

  }

}
