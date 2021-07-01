package task2

import org.scalatest.{FreeSpec, MustMatchers}

class MultiQueueTest extends FreeSpec with MustMatchers {
  def trivial(m: MultiQueue): Unit = {
    "trivial" in {
      true mustBe true
    }
  }
}
