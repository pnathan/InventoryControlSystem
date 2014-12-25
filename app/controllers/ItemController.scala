package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import java.sql.Timestamp
import models.Item
import models.Items

object ItemController extends Controller {
  val itemForm = Form(
      mapping(
          "id" -> number, 
          "name" -> text, 
          "description" -> text, 
          "category" -> text, 
          "date_acquired" -> jodaDate, 
          "sponsoring_member" -> text)(Item.apply)(Item.unapply))
          
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
  
  def add = Action {
      Ok(views.html.item())
  }
  
  def save = Action{implicit request =>
    val user = itemForm.bindFromRequest.get
    Items.create(user)
    Redirect(routes.Application.index)
  }
}