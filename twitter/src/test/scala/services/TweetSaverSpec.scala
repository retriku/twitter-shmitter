package services

import java.text.SimpleDateFormat
import java.util.Date

import akka.actor.ActorSystem
import akka.testkit.TestKit
import domain.TwitterDomain.Tweet
import org.scalatest.{BeforeAndAfterAll, Matchers, WordSpecLike}
import services.TweetSaver.Save
import tweets.TweetPostgresDB

import scala.concurrent.duration._

class TweetSaverSpec extends TestKit(ActorSystem("test"))
  with Matchers
  with WordSpecLike
  with BeforeAndAfterAll {

  override protected def afterAll(): Unit = TestKit.shutdownActorSystem(system, 10 seconds)

  "TweetSaver actor" must {

    "create new tweet" in new State {

      actor ! Save(testTweet1)
      expectMsg(1)
    }
  }

  abstract class State {

    val actor = system.actorOf(TweetSaver.props(new TweetPostgresDB()))

    val dateFormat = new SimpleDateFormat("yyyy-MM-dd")

    val testTweet1 = Tweet(Some(1), "user1", "tweet", dateFormat.parse(dateFormat.format(new Date())))
  }

}
