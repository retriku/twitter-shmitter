package db

import db.components.DBComponent
import domain.Tweet

import scala.concurrent.Future

trait DAO {
  this: DBComponent =>

  def create(tweet: Tweet): Future[Int]

  def getByUser(user: String): Future[Tweet]
}
