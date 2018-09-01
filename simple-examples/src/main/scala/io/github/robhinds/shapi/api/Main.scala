package io.github.robhinds.shapi.api


import akka.actor.ActorSystem
import akka.event.Logging
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives.logRequestResult
import akka.stream.ActorMaterializer
import io.github.robhinds.shapi.api.SimpleService.{Simple, SimpleService}
import io.github.robhinds.shapi.controllers.GenericDomainController
import io.circe.generic.auto._

import scala.concurrent.ExecutionContext

object Main extends App  {
  private implicit val system = ActorSystem()
  protected implicit val executor: ExecutionContext = system.dispatcher
  protected implicit val materializer: ActorMaterializer = ActorMaterializer()

  val simpleController = new GenericDomainController[Simple, Int]() with SimpleService

  Http().bindAndHandle( logRequestResult("log",Logging.InfoLevel)( simpleController.routes ), "localhost", 8080 )


}