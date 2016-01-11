import math.abs

object fixedPoint {

val tolerance = .0001                             //> tolerance  : Double = 1.0E-4
def isCloseEnough(a: Double, b: Double): Boolean =
  abs((a-b) /a) /a < tolerance                    //> isCloseEnough: (a: Double, b: Double)Boolean
  
  
def fixedPoint(f: Double => Double)(firstGuess: Double) : Double = {
  def iterate(guess: Double): Double = {
  	//println(guess)
    val next = f(guess)
    if (isCloseEnough(guess, next)) guess
	else iterate(next)
  }
  iterate(firstGuess)
}                                                 //> fixedPoint: (f: Double => Double)(firstGuess: Double)Double

fixedPoint(x => 1 + x/2)(1)                       //> res0: Double = 1.99951171875

def averageDamp(f: Double => Double)(x: Double) = (x + f(x)) / 2
                                                  //> averageDamp: (f: Double => Double)(x: Double)Double

def sqrt(x: Double): Double =
	fixedPoint(averageDamp(y => x /y))(1)     //> sqrt: (x: Double)Double
	
sqrt(2)                                   //> res1: Double = 1.4142156862745097
  
  
}