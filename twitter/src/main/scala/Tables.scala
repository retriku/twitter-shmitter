import slick.driver.PostgresDriver.api._

class Tweets(tag: Tag) extends Table[(Int, String, Int)](tag, "TWEETS") {
  def tweetID = column[Int]("TWEET_ID", O.PrimaryKey)
  def text    = column[String]("TEXT")
  def shmitID = column[Int]("SHMIT_ID")
  
  def * = (tweetID, text, shmitID)
  
  // TODO: foreign key?
}


// TODO: define the table from shmits



// bloody example
class Coffees(tag: Tag) extends Table[(String, Int, Double, Int, Int)](tag, "COFFEES") {
  def name = column[String]("COF_NAME", O.PrimaryKey) // :D
  def supID = column[Int]("SUP_ID")
  def price = column[Double]("PRICE")
  def sales = column[Int]("SALES", O.Default(0))
  def total = column[Int]("TOTAL", O.Default(0))
  def * = (name, supID, price, sales, total)
}