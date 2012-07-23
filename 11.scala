// 11.scala
//

import scala.collection.mutable.Map

class CachedProduct(private var cells:Array[Array[Int]]) {
  var cache = Map[String, Int]();

  def apply(i:(Int, Int), j:(Int, Int), k:(Int, Int), l:(Int, Int)) : Int = {
    val this_key = key(i, j, k, l)
    cache.get(this_key) match {
      case Some(x) => {
        println("Cache hit!")
        x
      }
      case None => {
        println("Cache miss!")
        val res = comp(i) * comp(j) * comp(k) * comp(l)
        cache += (this_key -> res)
        res
      }
    }
  }

  private def comp: ((Int, Int)) => Int = {
    case (x, y) => cells(x)(y)
  }

  private def key(i:(Int, Int), j:(Int, Int), k:(Int, Int), l:(Int, Int)) : String = {
    import scala.util.Sorting.stableSort

    val arr = Array(i, j, k, l)

    stableSort(arr,
      (a:(Int, Int), b:(Int, Int)) => a._1 < b._1 || (a._1 == b._1 && a._2 < b._2))

    val (a, b) = arr(0)
    val (c, d) = arr(1)
    val (e, f) = arr(2)
    val (g, h) = arr(3)

    "(%d,%d)(%d,%d)(%d,%d)(%d,%d)".format(a, b, c, d, e, f, g, h)
  }
}

class GridWalker(private val cells:Array[Array[Int]]) {
  private val cp = new CachedProduct(cells)

  def walk(f:((Int, Int), Array[Int]) => Unit) {
    for {
      i <- 0 until cells.length
      j <- 0 until cells(i).length
    } {
      val a = Array(
        c(i, j, 3, -1, 0),  c(i, j, 3, 1, 0),
        c(i, j, 3, 0, -1),  c(i, j, 3, 0, 1),
        c(i, j, 3, -1, -1), c(i, j, 3, 1, -1),
        c(i, j, 3, -1, 1),  c(i, j, 3, 1, 1))

      f((i, j), a)
  }

  def clamp(i:Int, j:Int) : Int = {
    if (i >= 0 && i < cells.length && j >= 0 && j < cells(0).length)
      cells(i)(j)
    else
      0
  }

  def c(i:Int, j:Int, scale: Int, x:Int, y:Int) : Int =
    if (scale == 0) clamp(i, j)
    else clamp(i + x * scale, j + y * scale) * c(i, j, scale - 1, x, y)
  }
}

def loadCells(filename:String) : Array[Array[Int]] = {
  val cells = 
    for (l <- io.Source.fromFile(filename).getLines)
      yield for (i <- l.split(' ').map(_.toInt)) yield i
  cells.toArray
}

def result():Int = {
  val gw = new GridWalker(loadCells("11.txt"))
  var max = 0
  def walker(s:(Int, Int), v:Array[Int]) = {
    if (max < v.max)
      max = v.max
  }

  gw.walk(walker)
  max
}

println(result())

