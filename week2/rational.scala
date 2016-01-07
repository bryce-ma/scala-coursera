object rational {
  val x = new Rational(1,2)                       //> x  : rational.Rational = 1 / 2
  x.numer                                         //> res0: Int = 1
  
  val y = new Rational(2,3)                       //> y  : rational.Rational = 2 / 3
  x.add(y)                                        //> res1: rational.Rational = 7 / 6
  x.sub(y)                                        //> res2: rational.Rational = -1 / 6
  
  class Rational(n: Int, d: Int) {
  def numer = n
  def denom = d
  
  def add(that: Rational): Rational =
    new Rational(numer*that.denom + denom*that.numer, denom* that.denom)

  def neg = new Rational(-numer, denom)

  def sub(that: Rational) = add(that.neg)
    
  override def toString =
      numer + " / " + denom
      
  }
	
}
