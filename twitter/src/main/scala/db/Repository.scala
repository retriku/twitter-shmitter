package db

import db.Tables.TweetTable
import db.components.DBComponent
import domain.TwitterDomain
import slick.jdbc.GetResult
import tweets.Dao

import scala.concurrent.Future

trait Repository extends Dao with TweetTable {
  this: DBComponent =>

  import TwitterDomain._
  import driver.api._

  implicit val tweetResult = GetResult { rs =>
    Tweet(Some(rs <<), rs <<, rs <<, rs.nextDate())
  }

  override def create(tweet: Tweet): Future[Int] = db.run {
    (tweetTable.map(f => (f.user, f.text)) returning tweetTable.map(_.id)) +=(tweet.user, tweet.text)
  }

  override def getByUser(user: String): Future[Tweets] = db.run {
    sql"""SELECT "id", "user", "text", "created_date"
          FROM "twitter_message"
          WHERE "user" = $user;""".as[Tweet].map(_.toList)
  }

  override def getAll: Future[Tweets] = db.run {
    sql"""SELECT "id", "user", "text", "created_date"
          FROM "twitter_message";""".as[Tweet].map(_.toList)
  }
}
