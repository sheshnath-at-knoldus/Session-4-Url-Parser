package com.knoldus

import com.knoldus.UrlParse.urlParser
import org.scalatest.funsuite.AnyFunSuite

class UrlParserTest extends AnyFunSuite{

  test("Url parser "){
    val url = "https://www.mywebsite.com/home/home2"
    val urlParser = Extracter(url)
    val result = Some("https","www.mywebsite.com","home/home2")
    val expectedValue =Extracter.unapply(urlParser)
    assert(result===expectedValue)

  }

}
