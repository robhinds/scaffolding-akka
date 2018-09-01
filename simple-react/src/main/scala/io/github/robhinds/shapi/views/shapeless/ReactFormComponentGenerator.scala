package io.github.robhinds.shapi.views.shapeless

import shapeless.{HList, LabelledGeneric}
import io.github.robhinds.shapi.utils.ComponentUtils._

trait ReactFormComponentGenerator {

  implicit def intFormComponent: ReactComponentGenerator[Int] =  (name: String) => documentField(name, false)
  implicit def stringFormComponent: ReactComponentGenerator[String] = (name: String) =>  documentField(name)
  implicit def doubleFormComponent: ReactComponentGenerator[Double] = (name: String) => documentField(name, false)
  implicit def booleanFormComponent: ReactComponentGenerator[Boolean] = (name: String) => booleanDropDown(name)
  implicit def genericFormComponent[A, Repr <: HList](implicit a: LabelledGeneric.Aux[A, Repr], b: ComponentGenerator[Repr]): ReactComponentGenerator[A] =
    (inner: String) => s"""
        |import React, { Component } from 'react';
        |import DocumentField from './DocumentField';
        |import { ActionButton, SecondaryButton } from './common/Button';
        |
        |export default class GeneratedFormComponent extends Component {
        |  render() {
        |    return (
        |      <div>
        |        <div className="container">
        |          <form>
        |            $inner
        |          </form>
        |        </div>
        |        <footer className="footer">
        |          <div className="container">
        |            <ActionButton text="Save" onClick={() => null}  disabled={!this.props.dirty}/>
        |            <SecondaryButton text="Cancel" to="/documents" />
        |          </div>
        |        </footer>
        |      </div>
        |    )
        |  }
        |}
      """.stripMargin

}


object ReactFormComponentGenerator extends ReactFormComponentGenerator