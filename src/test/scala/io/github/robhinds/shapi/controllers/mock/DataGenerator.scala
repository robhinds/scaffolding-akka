package io.github.robhinds.shapi.controllers.mock

import cats.Monad
import io.github.robhinds.akkops.model.core.Response.{Response, success}
import io.github.robhinds.shapi.services.GenericDomainService

import scala.concurrent.Future

object DataGenerator {

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

}
