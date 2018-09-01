package io.github.robhinds.shapi.views.shapeless

import shapeless.{HList, LabelledGeneric}

trait ReactTableComponentGenerator {

  implicit def intFormComponent: ReactComponentGenerator[Int] =  (name: String) => s"<td>{ t.$name }</td>"
  implicit def stringFormComponent: ReactComponentGenerator[String] = (name: String) =>  s"<td>{ t.$name }</td>"
  implicit def doubleFormComponent: ReactComponentGenerator[Double] = (name: String) => s"<td>{ t.$name }</td>"
  implicit def booleanFormComponent: ReactComponentGenerator[Boolean] = (name: String) => s"<td>{ t.$name }</td>"
  implicit def genericFormComponent[A, Repr <: HList](implicit a: LabelledGeneric.Aux[A, Repr], b: ComponentGenerator[Repr]): ReactComponentGenerator[A] =
    (inner: String) =>
      s"""
         |import React, { Component } from 'react';
         |
         |export default class GeneratedTableComponent extends Component {
         |
         |  render() {
         |    return (
         |      <div className="container-fluid">
         |        <table className="table table-bordered table-hover">
         |          <tbody>
         |            { this.props.items.map(t => (
         |              <tr>
         |                $inner
         |              </tr>
         |            )) }
         |          </tbody>
         |        </table>
         |      </div>
         |    );
         |  }
         |}
         |
       """.stripMargin

}

object ReactTableComponentGenerator extends ReactTableComponentGenerator
