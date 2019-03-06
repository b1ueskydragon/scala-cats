package ch04.monad

object Lists {

  def main(args: Array[String]): Unit = {
    println(f)
    println(g)
  }

  /** In the for comprehension,
    * there are three possible values of x
    * and two possible values of y.
    *
    * This means there are six possible values of (x, y).
    *
    * @return pairs of Ints
    */
  def f = for {
    x <- (1 to 3).toList
    y <- (4 to 5).toList
  } yield (x, y)


  /** FlatMap,
    * is generating combinations from our code,
    * which states the sequence of operations:
    * - get x
    * - get y
    * - create a tuple (x, y)
    *
    * If we think of Lists as sets of intermediate results,
    * flatMap becomes a construct that calculates permutations and combinations.
    *
    * @return pairs of Ints
    */
  def g = (1 to 3).toList.flatMap { x =>
    (4 to 5).toList map { y =>
      (x, y)
    }
  }

}
