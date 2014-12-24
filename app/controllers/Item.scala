package controllers

import play.api._
import play.api.mvc._

object Item extends Controller {
  def query = Action {
    Ok(views.html.barebones("OK"))
  } 
  def all = Action {
    Ok(views.html.barebones("OK"))
  }
  def get_item(item_id : Int) = Action {
    Ok(views.html.barebones("OK"))
  }
  def update_item(item_id : Int) = Action {
    Ok(views.html.barebones("OK"))
  }
}