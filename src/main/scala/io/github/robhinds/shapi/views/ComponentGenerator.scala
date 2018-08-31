package io.github.robhinds.shapi.views

import shapeless.labelled.FieldType
import shapeless.{HList, HNil, _}

trait ReactComponentGenerator[A] {
  def generate(a: String): String
}

trait ComponentGenerator[A] {
  def generate: String
}

object ComponentGenerator {

  def generate[A](implicit gen: Lazy[ComponentGenerator[A]]) = gen.value.generate

  implicit def intComponent[K <: Symbol](
    implicit witness: Witness.Aux[K],
    reactComponent: ReactComponentGenerator[Int]
  ): ComponentGenerator[FieldType[K, Int]] =
    new ComponentGenerator[FieldType[K, Int]] {
      override def generate = reactComponent.generate(witness.value.name)
    }

  implicit def stringComponent[K <: Symbol](
    implicit witness: Witness.Aux[K],
    reactComponent: ReactComponentGenerator[String]
  ): ComponentGenerator[FieldType[K, String]] =
    new ComponentGenerator[FieldType[K, String]] {
      override def generate = reactComponent.generate(witness.value.name)
    }

  implicit def doubleComponent[K <: Symbol](
    implicit witness: Witness.Aux[K],
    reactComponent: ReactComponentGenerator[Double]
  ): ComponentGenerator[FieldType[K, Double]] =
    new ComponentGenerator[FieldType[K, Double]] {
      override def generate = reactComponent.generate(witness.value.name)
    }

  implicit def booleanComponent[K <: Symbol](
    implicit witness: Witness.Aux[K],
    reactComponent: ReactComponentGenerator[Boolean]
  ): ComponentGenerator[FieldType[K, Boolean]] =
    new ComponentGenerator[FieldType[K, Boolean]] {
      override def generate = reactComponent.generate(witness.value.name)
    }

  implicit def hnilGenerator: ComponentGenerator[HNil] = new ComponentGenerator[HNil] {
    override def generate = ""
  }

  implicit def hlistGenerator[K <: Symbol, H, T <: HList](
    implicit headGen: Lazy[ComponentGenerator[FieldType[K, H]]],
    tailGen: ComponentGenerator[T]
  ): ComponentGenerator[FieldType[K, H] :: T] =
    new ComponentGenerator[FieldType[K, H] :: T] {
      override def generate = s"${headGen.value.generate}${tailGen.generate}"
    }

  implicit def genericToGenerator[A, Repr <: HList](
    implicit generic: LabelledGeneric.Aux[A, Repr],
    gen: ComponentGenerator[Repr],
    reactComponent: ReactComponentGenerator[A]
  ): ComponentGenerator[A] =
    new ComponentGenerator[A] {
      override def generate = reactComponent.generate(gen.generate)
    }

}
