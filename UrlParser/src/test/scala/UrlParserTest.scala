package com.knoldus

import com.knoldus.UrlParse.urlParser
import org.scalatest.funsuite.AnyFunSuite

class UrlParserTest extends AnyFunSuite{

  test("Url parser "){

    val url = "https://www.mywebsite.com/home/home2"
    val urlParser = Extracter(url)

    val result = urlParser match {
      case Extracter(protocol, domainName, path) => s"Protocol:$protocol, Domain:$domainName, Path: $path"
      case _ => "Not Matched"
    }
    val expectedValue ="Protocol:https, Domain:www.mywebsite.com, Path: home/home2"
    assert(result===expectedValue)

  }

}
