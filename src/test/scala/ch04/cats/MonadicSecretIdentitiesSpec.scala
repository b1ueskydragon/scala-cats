package ch04.cats

import org.scalatest.FlatSpec
import ch04.cats.MonadicSecretIdentities._

class MonadicSecretIdentitiesSpec extends FlatSpec {

  "pure" should "return itself" in {

    val value = 1

    val expected = value

    assert(expected == pure(value))

  }

}
