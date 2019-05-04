package ch04.cats

import cats.instances.list._
import cats.instances.option._
import ch04.cats.Sample.{sumSquareFlatMap, _}
import org.scalatest.FlatSpec

class SampleSpec extends FlatSpec {

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
