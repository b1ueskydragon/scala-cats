package ch04.cats

import cats.instances.list._
import cats.instances.option._
import ch04.cats.Sample._
import org.scalatest.FlatSpec

import scala.concurrent.Await
import scala.concurrent.duration._

class SampleSpec extends FlatSpec {

  "dupliAndCarry" should "return a Vector of pairs which paired itself and multiple 10" in {

    val a = Vector(1, 2, 3)

    val expected = Vector(1, 10, 2, 20, 3, 30)

    assert(expected == dupliAndCarry(a))

  }

  "future" should "return a concurrent Future type Int" in {

    val a = 1

    val expected = 3
    val actual = Await.result(future(a), Duration.Inf)

    assert(expected == actual)

  }

  "sumSquareFlatMap" should "return a some value when parameter type is Option" in {

    val a = Option(2)
    val b = Option(5)

    val expected = Some(2 * 2 + 5 * 5)

    assert(expected == sumSquareFlatMap(a, b))

  }

  "sumSquareFlatMap" should "return a List when parameter type is List" in {

    val a = List(2, 3, 4)
    val b = List(5, 6)

    val expected = List(
      2 * 2 + 5 * 5,
      2 * 2 + 6 * 6,
      3 * 3 + 5 * 5,
      3 * 3 + 6 * 6,
      4 * 4 + 5 * 5,
      4 * 4 + 6 * 6
    )

    assert(expected == sumSquareFlatMap(a, b))

  }

  "sumSquareFlatMap" should "equal as sumSquareComprehension" in {

    val a = List(2, 3, 4)
    val b = List(5, 6)

    assert(sumSquareFlatMap(a, b) == sumSquareComprehension(a, b))

  }

}
