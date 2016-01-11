package week2

object intsets {
  val t1 = new NonEmpty(6, Empty, Empty)          //> t1  : week2.NonEmpty = {.6.}
  val t2 = t1 incl 4                              //> t2  : week2.IntSet = {{.4.}6.}
  val t3 = new NonEmpty(7, Empty, Empty)          //> t3  : week2.NonEmpty = {.7.}
  val t4 = t3 incl 1                              //> t4  : week2.IntSet = {{.1.}7.}
  val t5 = t2 union t4                            //> t5  : week2.IntSet = {{.1{{.4.}6.}}7.}
}

abstract class IntSet {
	def incl(x: Int): IntSet
	def contains(x: Int): Boolean
	def union(other: IntSet): IntSet
}

object Empty extends IntSet {    //Empty can be a class or a singleton object
  def contains(x: Int) = false
  def incl(x: Int) = new NonEmpty(x, Empty, Empty)
  def union(that: IntSet) = that
  override def toString = "."
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
	def contains(x: Int) =
	  if (x > elem) right contains x
	  else if(x < elem) left contains x
	  else right contains x
	
	def incl(x: Int) =
		if (x < elem) new NonEmpty(elem, left incl x, right)
		else if (x > elem) new NonEmpty(elem, left, right incl x)
		else this
		
	override def toString = "{" +left+elem+right+ "}"
	
	def union(that: IntSet) =
	  right union (left union (that incl elem))    //my version has a little different from the lecture, but key point as same
}