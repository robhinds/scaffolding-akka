package io.github.robhinds.shapi.views

import io.github.robhinds.shapi.utils.ComponentUtils.{booleanDropDown, documentField}
import shapeless.{HList, LabelledGeneric}

trait FormComponentGenerator {

  implicit def intFormComponent: ReactComponentGenerator[Int] =  (name: String) => documentField(name, false)
  implicit def stringFormComponent: ReactComponentGenerator[String] = (name: String) =>  documentField(name)
  implicit def doubleFormComponent: ReactComponentGenerator[Double] = (name: String) => documentField(name, false)
  implicit def booleanFormComponent: ReactComponentGenerator[Boolean] = (name: String) => booleanDropDown(name)
  implicit def genericFormComponent[A, Repr <: HList](implicit a: LabelledGeneric.Aux[A, Repr], b: ComponentGenerator[Repr]): ReactComponentGenerator[A] =
    (inner: String) => s"""
        |import React, { Component } from 'react';
        |import DocumentField from './DocumentField';
        |import { ActionButton, SecondaryButton } from '../common/Button';
        |
        |export default class DocumentForm extends Component {
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
        |            <SecondaryButton text="Reset" onClick={this.props.resetForm} disabled={!this.props.dirty}/>
        |          </div>
        |        </footer>
        |      </div>
        |    )
        |  }
        |}
      """.stripMargin

}

object FormComponentGenerator extends FormComponentGenerator