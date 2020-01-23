package mz

/**
 * Mutable implementation of IMovingAvg
 * internally it uses an Array to store the items
 * @param window moving average window size
 */
class MovingAvg(window: Int) extends IMovingAvg {

  if (window <=0) {
    throw new IllegalArgumentException("window must be > 0")
  }

  // keeps track
  private var arr = Array.ofDim[Int](10)
  private var lastAddedItemPos = -1
  private var sum = 0


  private def resize: Unit = {
    val newArr = Array.ofDim[Int](arr.length * 2)
    Array.copy(arr,0, newArr,0, arr.length)
    arr = newArr
  }

  def add(n: Int): Unit = {
    if(lastAddedItemPos >= arr.size * 0.75 ) {
      resize
    }

    lastAddedItemPos+=1
    arr(lastAddedItemPos) = n

    sum+=n
    if ( lastAddedItemPos>=window) {
      sum-= arr(lastAddedItemPos - window)
    }
  }

  def get(i: Int): Option[Int] = {
    if(i > lastAddedItemPos || i < 0)
      None
    else
      Some(arr(i))
  }

  override def avg: Float =
    if(lastAddedItemPos < window)
      sum / (lastAddedItemPos + 1)
    else sum / window
}
