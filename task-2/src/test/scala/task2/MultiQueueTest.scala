package task2.s

import org.scalatest.{FreeSpec, MustMatchers}

class MultiQueueTest extends FreeSpec with MustMatchers {
  def trivial[A >: Null : Ordering](m: MultiQueue[A]): Unit = {
    "trivial" in {
      true mustBe true
    }
  }
}
