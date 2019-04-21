package ch03.cats

/** Identity:
  * calling map with the identity function == doing nothing
  * | fa.map(a => a) == fa
  *
  * Composition:
  * mapping with two functions f and g == mapping with f and then mapping with g
  * | fa.map(g(f(_))) == fa.map(f).map(g)
  *
  * @tparam F type constructor
  *           (take a single parameter and produce type)
  */
trait MyFunctor[F[_]] {
  def map[A, B](fa: F[A])(f: A => B): F[B]
}
