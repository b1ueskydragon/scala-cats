package ch04.cats

import org.scalatest.FlatSpec
import ch04.cats.MonadicSecretIdentities._

class MonadicSecretIdentitiesSpec extends FlatSpec {

  "pure" should "return itself" in {

    val value = 1

    val expected = value

    val actual = pure(value)

    assert(expected === actual)

  }

  "map" should "return a value after applying function" in {

    val value = 100

    def f(x: Int) = x * 3.14

    val expected = f(value)

    val actual = map(value)(f) //  map(value)(x => f(x))

    assert(expected === actual)

  }

  "flatMap" should "return a plain value after applying function" in {

    val value = 100

    def f(x: Int) = x * 3.14

    val expected = pure(f(value))

    val actual = flatMap(value)(f)

    assert(expected === actual)

  }

  "flatMap" should "be actually identical with map" in {

    val value = 100

    def f(x: Int) = x * 3.14

    val expected = map(value)(f) // f(value)

    val actual = flatMap(value)(f)

    assert(expected === actual)

  }

  "map" should "be defined using flatMap and pure" in {

    val value = 111

    def f(x: Int) = x.toDouble

    val expected = map(value)(f)

    val actual = flatMap(value)(a => pure(f(a)))

    assert(expected === actual)

  }

}
