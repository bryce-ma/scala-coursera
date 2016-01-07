def sum(f: Int => Int)(a: Int, b: Int) : Int = {
  def loop(start: Int, acc: Int): Int = {
    if (start > b) 0
	else loop(start+1, f(start) + acc)
  }
  loop(a,0)
}
  