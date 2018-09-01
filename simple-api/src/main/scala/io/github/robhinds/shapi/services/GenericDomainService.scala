package io.github.robhinds.shapi.services

import cats.Monad
import io.github.robhinds.akkops.model.core.Response.Response

import scala.language.higherKinds

trait GenericDomainService[F[_], A, B] {

  implicit def F: Monad[F]

  def list: F[Response[Seq[A]]]

  def get(id: B): F[Response[A]]

  def create(a: A): F[Response[A]]

  def update(a: A): F[Response[Boolean]]

  def delete(id: B): F[Response[Boolean]]

}
