package tweets

import java.util.concurrent.{LinkedBlockingQueue, ThreadPoolExecutor, TimeUnit}

import com.typesafe.config.ConfigFactory
import db.SqlRepository
import db.components.PostgresDBComponent
import domain.TwitterDomain

import scala.concurrent.{ExecutionContext, Future}

class TweetPostgresDB extends Dao {

  import TweetPostgresDB._
  import TwitterDomain._

  override def create(tweet: Tweet): Future[Int] = TweetDataBaseRepository.create(tweet)

  override def getByUser(user: String): Future[Tweets] = TweetDataBaseRepository.getByUser(user)

  override def getAll: Future[Tweets] = TweetDataBaseRepository.getAll
}

object TweetPostgresDB {

  private val config = ConfigFactory.load().getConfig("repository-execution-context.thread-pool-executor")
  private val corePoolSize = config.getInt("core-pool-size")
  private val maximumPoolSize = config.getInt("max-pool-size")
  private val keepAliveTime = config.getDuration("keep-alive-time")
  private val executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize,
    keepAliveTime.getNano, TimeUnit.NANOSECONDS,
    new LinkedBlockingQueue[Runnable]())

  object TweetDataBaseRepository extends SqlRepository with PostgresDBComponent {

    implicit val ec = ExecutionContext.fromExecutor(executor)
  }

}