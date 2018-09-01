package io.github.robhinds.shapi.controllers

import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.Directives._
import io.github.robhinds.shapi.services.GenericDomainService
import io.github.robhinds.akkops.routing.DefaultResponseHandler._
import io.github.robhinds.akkops.routing.directives.Directives._
import io.github.robhinds.shapi.converter.ConvertibleId
import io.circe.generic.auto._

import scala.concurrent.Future
import scala.reflect.ClassTag
import scala.reflect._
import _root_.io.circe.Encoder
import _root_.io.github.robhinds.akkops.model.core.Errors.ErrorResponse

class GenericDomainController[A: Encoder : ClassTag, B: ConvertibleId] {
  service: GenericDomainService[Future, A, B] =>

  private val domainClassName = classTag[A].runtimeClass.getSimpleName

  def listRoute(implicit ee: Encoder[ErrorResponse], te: Encoder[Seq[A]]): Route =
    getPath(s"$domainClassName") {
      respond(service.list)
    }

  def getRoute(implicit ee: Encoder[ErrorResponse], c: ConvertibleId[B]): Route =
    getPath(s"$domainClassName" / Segment ) { id =>
      respond(service.get(c.toId(id)))
    }

  val routes = listRoute ~ getRoute
}
