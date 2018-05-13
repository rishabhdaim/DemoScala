package com.journaldev.annotations

import scala.beans.BeanProperty

/**
  * Created by diam on 5/13/2018.
  */
class Car {

  @BeanProperty
  var cName = "Dzire"

  @BeanProperty
  var cNo = 2381
}
