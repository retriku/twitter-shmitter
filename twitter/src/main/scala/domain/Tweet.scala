package domain

import java.util.Date

object TwitterDomain {

  case class Tweet(id: Option[Int] = None,
                   user: String,
                   text: String,
                   createdDate: Date)

  type Tweets = List[Tweet]
}