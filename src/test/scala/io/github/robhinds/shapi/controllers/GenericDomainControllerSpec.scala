package io.github.robhinds.shapi.controllers

import akka.http.scaladsl.server.Route
import akka.http.scaladsl.testkit.ScalatestRouteTest
import cats.Monad
import io.github.robhinds.akkops.model.core.Response._
import io.github.robhinds.shapi.services.GenericDomainService
import org.scalatest.{FlatSpec, Matchers}
import io.circe.generic.auto._
import io.circe._, io.circe.generic.semiauto._

import scala.concurrent.Future

class GenericDomainControllerSpec extends FlatSpec with Matchers with ScalatestRouteTest {

  case class TestExample(name: String, id: Int, other: Boolean)
  val eg1 = TestExample("hello", 999, true)
  val eg2 = TestExample("goodbye", 1, false)
  trait ExampleService extends GenericDomainService[Future, TestExample, Int] {
    override implicit val F: Monad[Future] = implicitly[Monad[Future]]
    override def list: Future[Response[Seq[TestExample]]] = Future(success(List(eg1, eg2)))
    override def get(id: Int): Future[Response[TestExample]] = Future(success(eg1))
    override def create(a: TestExample): Future[Response[TestExample]] = ???
    override def update(a: TestExample): Future[Response[Boolean]] = ???
    override def delete(id: Int): Future[Response[Boolean]] = ???
  }

  "get domain list" should "return list of objects" in {
    val r = new GenericDomainController[TestExample, Int]() with ExampleService
    Get("/TestExample") ~> Route.seal(r.routes) ~> check {
      val jsonString = responseAs[String]
      jsonString shouldEqual "{\n  \"status\" : \"200 OK\",\n  \"data\" : [\n    {\n      \"name\" : \"hello\",\n      \"id\" : 999,\n      \"other\" : true\n    },\n    {\n      \"name\" : \"goodbye\",\n      \"id\" : 1,\n      \"other\" : false\n    }\n  ]\n}"
    }
  }

  "get domain by ID" should "return object" in {
    val r = new GenericDomainController[TestExample, Int]() with ExampleService
    Get("/TestExample/987") ~> Route.seal(r.routes) ~> check {
      val jsonString = responseAs[String]
      jsonString shouldEqual "{\n  \"status\" : \"200 OK\",\n  \"data\" : {\n    \"name\" : \"hello\",\n    \"id\" : 999,\n    \"other\" : true\n  }\n}"
    }
  }

}
