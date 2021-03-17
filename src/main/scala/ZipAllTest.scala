object ZipAllTest extends App {
  val incomingUrl = List("users", "profile", "12345", "extra")

  val urlToCompare = List("users", "profile", ":id")

  val list1 = incomingUrl.map(Some(_))
  val list2 = urlToCompare.map(Some(_))

  val zipped = list1.zipAll(list2, None, None)

  println(zipped)
}
