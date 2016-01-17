package week3

object nth {
	def singlton[T](elem: T) = new Cons[T](elem, new Nil[T])
                                                  //> singlton: [T](elem: T)week3.Cons[T]
	
  def nth[T](n: Int, xs: List[T]): T =
    try{
    	if (n == 0) xs.head
  	  else nth(n-1, xs.tail)
    }catch {
      case e: NoSuchElementException =>
        throw new IndexOutOfBoundsException("nth: out of range")
    }                                             //> nth: [T](n: Int, xs: week3.List[T])T
  	
	
  val s = singlton[Int](1)                        //> s  : week3.Cons[Int] = week3.Cons@180bc464
  
  nth(0, s)                                       //> res0: Int = 1
  nth(1, s)                                       //> java.lang.IndexOutOfBoundsException: nth: out of range
                                                  //| 	at week3.nth$$anonfun$main$1.nth$1(week3.nth.scala:12)
                                                  //| 	at week3.nth$$anonfun$main$1.nth$1(week3.nth.scala:9)
                                                  //| 	at week3.nth$$anonfun$main$1.apply$mcV$sp(week3.nth.scala:19)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at week3.nth$.main(week3.nth.scala:3)
                                                  //| 	at week3.nth.main(week3.nth.scala)
}