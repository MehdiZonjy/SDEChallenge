package mz

object Main extends App {
  val movingAvg = new MovingAvg(3)
  movingAvg.add(1)
  movingAvg.add(2)
  movingAvg.add(3)
  movingAvg.add(4)
  movingAvg.add(5)
  movingAvg.add(6)
  movingAvg.add(7)
  println(movingAvg.get(0))
  println(movingAvg.get(-3))
  println(movingAvg.get(10))
  println(movingAvg.avg)

}