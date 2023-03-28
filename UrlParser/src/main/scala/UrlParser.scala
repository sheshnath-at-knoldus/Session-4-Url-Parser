package com.knoldus

class Extracter(val url: String)

//companion Object for Class Extractor
object Extracter {

  //apply method
  def apply(url: String): Extracter = new Extracter(url)

  //unapply method
  def unapply(extracter: Extracter): Option[(String, String, String)] = {

    try {
      val url = extracter.url
      if (url.isEmpty) throw new NullPointerException()

      val protocol = url.substring(0, url.indexOf(":"))
      val domainEnd = url.indexOf("/", url.indexOf("//") + 2)
      val domainName = url.substring(url.indexOf("//") + 2, domainEnd)
      val pathStart = domainEnd + 1
      val path = url.substring(pathStart)
      Some(protocol, domainName, path)

    } catch {
      case e: Exception => None
      case _: NullPointerException => None

    }
  }

}

object UrlParse extends App {

  private val url = "https://www.mywebsite.com/home/home2"
  private val urlParser = Extracter(url)

  private val result = urlParser match {
    case Extracter(protocol, domainName, path) => s"Protocol: $protocol, Domain: $domainName, Path: $path"
    case _ => "Not Matched"
  }
  println(result)
}
