package db

import db.components.DBComponent
import domain.TwitterDomain.Tweet

object Tables {

  trait TweetTable {
    this: DBComponent =>

    import driver.api._

    final class TweetTable(tag: Tag) extends Table[(Int, String, String, java.sql.Date)](tag, "twitter_message") {

      def id = column[Int]("id", O.AutoInc, O.PrimaryKey)

      def user = column[String]("user")

      def text = column[String]("text")

      def createdDate = column[java.sql.Date]("created_date")

      override def * = (id, user, text, createdDate)
    }

    protected val tweetTable = TableQuery[TweetTable]
  }

}
