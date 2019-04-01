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

  implicit def setUnionMonoid[A]: Monoid[Set[A]] = new Monoid[Set[A]] {

    override def empty: Set[A] = Set.empty

    override def combine(x: Set[A], y: Set[A]): Set[A] = x ++ y // x union y

  }

}

object Semigroup {

  def apply[A](implicit semigroup: Semigroup[A]): Semigroup[A] = semigroup

  // this forms a semigroup, but doesn't form a monoid
  // because it has no identity element.
  implicit def setIntersectionSemigroup[A]: Semigroup[Set[A]] =
    (a: Set[A], b: Set[A]) => a intersect b

}