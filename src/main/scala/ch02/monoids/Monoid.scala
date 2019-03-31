package ch02.monoids

trait Semigroup[A] {
  def combine(x: A, y: A): A
}

trait Monoid[A] extends Semigroup[A] {
  def empty: A // identity law
}

object Monoid {

  def apply[A](implicit monoid: Monoid[A]): Monoid[A] = monoid

  implicit val booleanAndMonoid: Monoid[Boolean] = new Monoid[Boolean] {

    def empty: Boolean = true

    def combine(x: Boolean, y: Boolean): Boolean = x && y

  }

  implicit val booleanOrMonoid: Monoid[Boolean] = new Monoid[Boolean] {

    override def empty: Boolean = false

    override def combine(x: Boolean, y: Boolean): Boolean = x || y

  }

  // exclusive or with identity false
  implicit val booleanEitherMonoid: Monoid[Boolean] = new Monoid[Boolean] {

    override def empty: Boolean = false

    override def combine(x: Boolean, y: Boolean): Boolean = (x && !y) || (!x && y)

  }

  // exclusive nor with identity true
  implicit val booleanXnorMonoid: Monoid[Boolean] = new Monoid[Boolean] {

    override def empty: Boolean = true

    override def combine(x: Boolean, y: Boolean): Boolean = (x && y) || (!x && !y) // (!x || y) && (x || !y)

  }

}