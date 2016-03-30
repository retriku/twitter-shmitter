package tweets

import java.util.Date

import db.Repository
import db.components.{H2DBComponent, PostgresDBComponent}
import domain.TwitterDomain
import org.scalatest.{Matchers, WordSpecLike}

import scala.concurrent.duration._
import scala.concurrent.{Await, ExecutionContext}

class TweetDataBaseSpec extends WordSpecLike
  with Matchers {

  "Tweet repository" must {
    "be able to create record and query it" in new State {

      val id = Await.result(repo.create(tweet = testTweet1), 500 milliseconds)
      val result = Await.result(repo.getByUser(user = testTweet1.user), 500 milliseconds)

      result should be(List(testTweet1.copy(Some(id))))
    }
  }

  object TweetDataBase {

    object TweetDataBaseRepository extends Repository with H2DBComponent {

      implicit val ec = ExecutionContext.global
    }

  }

  abstract class State {

    import TweetDataBase._
    import TwitterDomain._

    val repo = TweetDataBaseRepository

    val testTweet1 = Tweet(None, "user1", "tweet", new Date())
  }

}
