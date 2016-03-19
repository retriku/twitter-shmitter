// TODO: that shit is crazy
import slick.driver.H2Driver.api._

//import scala.concurrent.ExecutionContext.Implicits.global

// TODO: define the tables for twitter-shmitter (tweets, shmits)
class Coffees(tag: Tag) extends Table[(String, Int, Double, Int, Int)](tag, "COFFEES") {
  def name = column[String]("COF_NAME", O.PrimaryKey) // :D
  def supID = column[Int]("SUP_ID")
  def price = column[Double]("PRICE")
  def sales = column[Int]("SALES", O.Default(0))
  def total = column[Int]("TOTAL", O.Default(0))
  def * = (name, supID, price, sales, total)
}