package controllers

import play.api._
import play.api.mvc._

object StatusController extends Controller {
  def healthz = Action {
    Ok(views.html.barebones("OK"))
  }
  
  def statusz = Action {
    Ok(views.html.barebones("Up"))
  }
  
  def propertiesz = Action {
    Ok(views.html.barebones("1.0"))
  }
}