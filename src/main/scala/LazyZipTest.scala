
object LazyZipTest extends App{
  val incomingUrl = List("users", "profile", "12345", "extra").view

  val urlToCompare = List("users", "profile", ":id").view

  val list1 = incomingUrl.map(Some(_))
  val list2 = urlToCompare.map(Some(_))

  val zipped = list1.zipAll(list2, None, None)

  println(zipped)

}
