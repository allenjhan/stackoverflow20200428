object FoldTest extends App{

  val incomingUrl = List("users", "profile", "12345", "extra").toIndexedSeq

  val urlToCompare = List("users", "profile", ":id").toIndexedSeq

  def onePassZip[T, U](l1: IndexedSeq[T], l2: IndexedSeq[U]): IndexedSeq[(Option[T], Option[U])] = {
    val folded = l1.foldLeft((l2, IndexedSeq[(Option[T], Option[U])]())) { (acc, e) =>
      acc._1 match {
        case x +: xs => (xs, acc._2 :+ (Some(e), Some(x)))
        case IndexedSeq() => (IndexedSeq(), acc._2 :+ (Some(e), None))
      }
    }
    folded._2 ++ folded._1.map(x => (None, Some(x)))
  }

  println(onePassZip(incomingUrl, urlToCompare))
  println(onePassZip(urlToCompare, incomingUrl))
}
