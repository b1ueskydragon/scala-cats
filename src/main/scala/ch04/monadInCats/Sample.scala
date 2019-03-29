package ch04.monadInCats

import cats.Monad
import cats.instances.vector._
import scala.concurrent.Future // for Monad

import cats.instances.future._ // for Monad
import scala.concurrent._
import scala.concurrent.duration._

import scala.concurrent.ExecutionContext.Implicits.global // Bringing the ExecutionContext into scope

object Sample {

  def main(args: Array[String]): Unit = {
    val res = Monad[Vector].flatMap(Vector(1, 2, 3))(a => Vector(a, a * 10))
    println(res) // Vector(1, 10, 2, 20, 3, 30)

    val fm = Monad[Future]

    val future: Future[Int] = fm.flatMap(fm.pure(1))(x => fm.pure(x + 2))

    Await.result(future, 10.second) // TODO

  }

}
