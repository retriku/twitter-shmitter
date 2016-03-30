package tweets

import java.util.concurrent.{LinkedBlockingQueue, ThreadPoolExecutor, TimeUnit}

import com.typesafe.config.ConfigFactory
import domain.TwitterDomain

import scala.concurrent.Future

class TweetDataBase extends Dao {

  import TwitterDomain._

  override def create(tweet: Tweet): Future[Int] = ???

  override def getByUser(user: String): Future[Tweets] = ???

  override def getAll: Future[Tweets] = ???
}

object TweetDataBase {

  val config = ConfigFactory.load().getConfig("repository-execution-context.thread-pool-executor")
  val corePoolSize = config.getInt("core-pool-size")
  val maximumPoolSize = config.getInt("max-pool-size")
  val keepAliveTime = config.getDuration("keep-alive-time")
  val executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize,
    keepAliveTime.getNano, TimeUnit.NANOSECONDS,
    new LinkedBlockingQueue[Runnable]())

}