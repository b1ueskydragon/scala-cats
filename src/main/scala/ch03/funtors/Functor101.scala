package ch03.funtors

object Functor101 {

  def main(args: Array[String]): Unit = {

    /* Option — the value may or may not be present */
    val opt: Option[Int] = Some(1)
    val opt01: Option[Int] = None
    println(opt.map(_ + 1))
    println(opt01.map(_ + 1))

    /* Either - there may be a value or an error */
    val etr: Either[Exception, Int] = Right(99)
    val etr01: Either[Exception, Int] = Left(new IllegalArgumentException)
    println(etr.map(x => x))
    println(etr01.map(x => x))

    /* List - there may be zero or more values */
    val lst = Seq.empty[Int]
    val lst01: Seq[Int] = List(2, 3, 5, 7, 11)
    println(lst.map(x => x))
    println(lst01.map(x => x))

    /* Future -
                there are not guarantees about its internal state.
                the wrapped computation may be ongoing, complete, or rejected.

       Future always computes and caches a result.
       Future complete; mapping function can be called immediately.
       Not complete;    some underlying thread pool queues the function call and comes back to it later.
     */
    import scala.concurrent.{Future, Await}
    import scala.concurrent.ExecutionContext.Implicits.global
    import scala.concurrent.duration._

    import scala.util.Random

    /* computation for ftr calls nextInt once */
    val ftr = {
      val r = new Random(0L) // initialize (fixed seed)
      val x = Future(r.nextInt()) // side-effect

      for {
        a <- x
        b <- x
      } yield (a, b)
    }

    /* computation for ftr01 calls nextInt twice */
    val ftr01 = {
      val r = new Random(0L)

      for {
        a <- Future(r.nextInt)
        b <- Future(r.nextInt)
      } yield (a, b)
    }

    assert(
      Await.result(ftr, 1.second) != Await.result(ftr01, 1.second)
    )
    assert(
      Await.result(ftr01, 1.second)._2 != Await.result(ftr01, 1.second)._1
    )

  }

}
