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

  case class ListaItem(id: Long, name: String, isOk: Boolean, address: String)
  //json
  implicit val todoListJson = Json.format[ListaItem]
  val Lista = List(ListaItem(1, "javier", true, "oxford street"),
              ListaItem(2, "juan", false, "alfonso X street"),
              ListaItem(2, "ana", false, "uria street")
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


}
