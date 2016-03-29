package db.components

import slick.driver.H2Driver

trait H2DBComponent extends DBComponent {

  val driver = H2Driver

  import driver.api._

  val db: Database = H2DB.connectionPool
}

private[db] object H2DB {

  import slick.driver.H2Driver.api._

  val connectionPool = Database.forConfig("test-database")
}
