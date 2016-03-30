package tweets

import domain.TwitterDomain

import scala.concurrent.Future

trait Dao {

  import TwitterDomain._

  def create(tweet: Tweet): Future[Int]

  def getByUser(user: String): Future[Tweets]

  def getAll: Future[Tweets]
}
