package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import java.sql.Timestamp
import models.Item
import models.Items
import models.Category
import models.Categories

object ItemController extends Controller {
  val itemForm = Form(
    mapping(
      "id" -> optional(number),
      "name" -> text,
      "description" -> text,
      // https://www.playframework.com/documentation/2.3.x/ScalaForms see nested values
      "category" -> mapping(
        "name" -> text)(Category.apply)(Category.unapply),
      "date_acquired" -> jodaDate,
      "sponsoring_member" -> text)(Item.apply)(Item.unapply))

  def query = Action {
    Ok(views.html.barebones("OK"))
  }

  def all = Action {
    Ok(views.html.item.list_items(Items.all))
  }

  def get(item_id : Int) = Action {
    Ok(views.html.item.show(Items.all, Items.get(item_id)))
  }

  def update(item_id : Int) = Action {
    implicit request =>
    val user = itemForm.bindFromRequest.get
    val item = user.copy(id = Some(item_id))
    Items.update(item)
    Redirect(routes.Application.index)
  }

  def new_form = Action {
    Ok(views.html.item.new_item_form(Items.all, itemForm))
  }

  def save = Action {
    implicit request =>
    val item = itemForm.bindFromRequest.get
    Items.create(item)
    Redirect(routes.Application.index)
  }
}
