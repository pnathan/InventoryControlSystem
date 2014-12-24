package models

import java.util.Calendar
import scala.slick.driver.PostgresDriver.simple._
import scala.slick.lifted.Tag
import play.api.Play.current
import play.api.data.Forms._

case class Item(
    id: Int, 
    name: String, 
    description: String, 
    category: String, 
    date_acquired: java.sql.Timestamp, 
    sponsoring_member: String)
    
class Items (tag: Tag) extends 
  Table[Item](tag, "Items") {
    def id = column[Int]("id", O.PrimaryKey,  O.AutoInc) 
    def name = column[String]("name",  O.NotNull) 
    def description = column[String]("description",  O.NotNull)
    def category = column[String]("category",  O.NotNull)
    def date_acquired = column[java.sql.Timestamp]("date_acquired",  O.NotNull)
    def sponsoring_member = column[String]("sponsoring_member",  O.NotNull)
    
    def * = (id, name, description, category, date_acquired, sponsoring_member) <> (Item.tupled, Item.unapply)
}

object Items {
  val db = play.api.db.slick.DB
  val items = TableQuery[Items]
  
  def all: List[Item] = db.withSession {      
    implicit session =>
       items.sortBy(_.id.asc).list
  }
  
  def get_item(identifier: Int): Item = db.withSession {
    implicit session =>
      items.filter(_.id === identifier).first
  }
  
  def update_item(identifier: Int) = db.withSession {
    implicit session =>
      items.filter(_.id === identifier).first
  }
}