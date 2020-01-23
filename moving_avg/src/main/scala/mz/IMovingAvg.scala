package mz

trait IMovingAvg {
  /**
   * add item
   * @param i
   */
  def add(i: Int): Unit

  /**
   * returns moving average
 *
   * @return None in case
   */
  def avg: Float

  /**
   * retrieves an item
   * @param i: item index
   * @return None in case i is out of bounds or Some if item exists
   */
  def get(i: Int): Option[Int]
}
