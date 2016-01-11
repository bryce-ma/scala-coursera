object rational {
  val x = new Rational(1,2)                       //> x  : rational.Rational = 1 / 2
  x.numer                                         //> res0: Int = 1
  
  val y = new Rational(2,3)                       //> y  : rational.Rational = 2 / 3
  x + y                                           //> res1: rational.Rational = 7 / 6
  x - y                                           //> res2: rational.Rational = 1 / -6
  
  y + x                                           //> res3: rational.Rational = 7 / 6
  
  x < y                                           //> res4: Boolean = true
  
  x max y                                         //> res5: rational.Rational = 2 / 3
  
  //val strange = new Rational(1, 0)
  //strange add strange
  
  new Rational(5)                                 //> res6: rational.Rational = 5 / 1
  
  class Rational(n: Int, d: Int) {
    require(d != 0, "denominator must nonzero")
    
    def this(x: Int) = this(x, 1)
  
    private def gcd(a: Int, b: Int): Int = if (b==0) a else gcd(b, a % b)
    
    
    def numer = n
    def denom = d
  
    def < (that: Rational) = numer*that.denom < denom*that.numer
  
    def max(that: Rational) = if (this < that) that else this
   
    def + (that: Rational): Rational =
      new Rational(numer*that.denom + denom*that.numer, denom* that.denom)
	
	  override def toString ={
		  val g = gcd(n, d)
		  numer/g + " / " + denom/g
		}
	  def unary_- = new Rational(-numer, denom)
	  def - (that: Rational) = this + -that
	
	}
}