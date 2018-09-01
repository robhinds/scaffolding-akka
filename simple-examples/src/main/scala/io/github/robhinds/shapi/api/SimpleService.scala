package io.github.robhinds.shapi.api

import cats.Monad
import io.github.robhinds.akkops.model.core.Response.{Response, success}
import io.github.robhinds.shapi.services.GenericDomainService

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object SimpleService {

  case class Simple(number: Int, working: Boolean, someText: String)
  val eg1 = Simple(999, true, "hello some text")
  val eg2 = Simple(1, false, "goodbye again")


  trait SimpleService extends GenericDomainService[Future, Simple, Int] {
    override implicit val F: Monad[Future] = implicitly[Monad[Future]]

    override def list: Future[Response[Seq[Simple]]] = Future(success(List(eg1, eg2)))

    override def get(id: Int): Future[Response[Simple]] = Future(success(eg1))

    override def create(a: Simple): Future[Response[Simple]] = ???

    override def update(a: Simple): Future[Response[Boolean]] = ???

    override def delete(id: Int): Future[Response[Boolean]] = ???
  }
}