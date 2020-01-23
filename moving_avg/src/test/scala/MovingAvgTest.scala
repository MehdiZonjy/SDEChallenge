package mz
import org.scalatest._


class MovingAvgTest extends FunSuite with Matchers {

  test("#add Should be able to add and retrieve an item") {
    val movingAvg = new MovingAvg(3)
    movingAvg.add(0)
    movingAvg.add(1)
    movingAvg.add(2)
    assert((movingAvg.get(1) == Some(1)))
  }

  test("#get Should return None when accessing an item that does not exist") {
    val movingAvg = new MovingAvg(3)
    assert(movingAvg.get(0) == None)
  }

  test("avg# should return moving avg") {
    val movingAvg = new MovingAvg(3)
    for ( i <- 1 to 7) {
      movingAvg.add(i)
    }

    assert(movingAvg.avg == 6)
  }
}
