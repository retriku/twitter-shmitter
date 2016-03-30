package db.components

import slick.driver.JdbcProfile

import scala.concurrent.ExecutionContext

trait DBComponent {

  val driver: JdbcProfile

  import driver.api._

  val db: Database

  implicit val ec: ExecutionContext
}
