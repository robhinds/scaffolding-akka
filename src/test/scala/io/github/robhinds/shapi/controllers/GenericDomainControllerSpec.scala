package io.github.robhinds.shapi.controllers

import akka.http.scaladsl.server.Route
import akka.http.scaladsl.testkit.ScalatestRouteTest
import org.scalatest.{FlatSpec, Matchers}
import mock.DataGenerator._


class GenericDomainControllerSpec extends FlatSpec with Matchers with ScalatestRouteTest {

  val controller = new GenericDomainController[TestExample, Int]() with ExampleService

  "get domain list" should "return list of objects" in {
    Get("/TestExample") ~> Route.seal(controller.routes) ~> check {
      responseAs[String] shouldEqual
        """{
          |  "status" : "200 OK",
          |  "data" : [
          |    {
          |      "name" : "hello",
          |      "id" : 999,
          |      "other" : true
          |    },
          |    {
          |      "name" : "goodbye",
          |      "id" : 1,
          |      "other" : false
          |    }
          |  ]
          |}""".stripMargin
    }
  }

  "get domain by ID" should "return object" in {
    Get("/TestExample/987") ~> Route.seal(controller.routes) ~> check {
      responseAs[String] shouldEqual
        """{
         |  "status" : "200 OK",
         |  "data" : {
         |    "name" : "hello",
         |    "id" : 999,
         |    "other" : true
         |  }
         |}""".stripMargin
    }
  }

}
