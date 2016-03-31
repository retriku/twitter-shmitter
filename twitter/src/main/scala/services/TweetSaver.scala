package services

import akka.actor.{Actor, ActorLogging, Props}
import akka.event.LoggingReceive
import akka.pattern.pipe
import domain.TwitterDomain.Tweet
import tweets.Dao

class TweetSaver(dao: Dao) extends Actor
  with ActorLogging {

  import TweetSaver._

  implicit val ec = context.dispatcher

  override def receive: Receive = LoggingReceive {
    case Save(tweet) =>
      dao.create(tweet).pipeTo(sender)
    case GetTweetByUser(user) =>
      dao.getByUser(user).pipeTo(sender)
    case GetAllTweets =>
      dao.getAll.pipeTo(sender)
  }
}

object TweetSaver {

  sealed trait Command

  final case class Save(tweet: Tweet) extends Command

  final case class GetTweetByUser(user: String) extends Command

  case object GetAllTweets extends Command

  def props(dao: Dao) = Props(new TweetSaver(dao))
}