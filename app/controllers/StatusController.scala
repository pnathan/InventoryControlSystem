package controllers

import scala.io.Source

import play.api.Play.current
import play.api._
import play.api.mvc._

/*
 * The StatusController is an automated method to determine the health of the service.
 */
object StatusController extends Controller {
  // the server is healthy
  def healthz = Action {
    Ok(views.html.barebones("OK"))
  }

  // the server is alive
  def statusz = Action {
    Ok(views.html.barebones("Up"))
  }

  // versions and any other information. Should be text/json
  def propertiesz = Action {

    val source = Play.current.classloader.getResource("build-data")
    var info = "build version data unknown"
    if (source != null) {
      info = Source.fromURL(source).mkString.replaceAll("\\s+$", "")
    }

    Ok(views.html.barebones(info))
  }
}
