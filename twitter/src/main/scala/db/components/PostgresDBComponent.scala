package db.components

import slick.driver.PostgresDriver

trait PostgresDBComponent extends DBComponent {

  val driver = PostgresDriver

  import driver.api._

  val db: Database = PostgresDB.connectionPool
}

private[db] object PostgresDB {

  import slick.driver.PostgresDriver.api._

  val connectionPool = Database.forConfig("database")
}