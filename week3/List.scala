package week3

/**
 * @author Bryce
 */
trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
  
}

class Nil[T] extends List[T] {
  def isEmpty: Boolean = true
  def head: Nothing = throw new NoSuchElementException("Nil.head")
  def tail: Nothing = throw new NoSuchElementException("Nil.tail")
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
}

object List {
  def apply[T]() = new Nil
  def apply[T](a: T) = new Cons(a, new Nil[T])
  def apply[T](a: T, b: T): List[T] =
    new Cons(a, new Cons(b, new Nil[T]))

}
