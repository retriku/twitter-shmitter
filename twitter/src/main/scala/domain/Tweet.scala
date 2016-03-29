package domain

import java.util.Date

case class Tweet(id: Option[Int] = None,
                 user: String,
                 text: String,
                 createdDate: Date)