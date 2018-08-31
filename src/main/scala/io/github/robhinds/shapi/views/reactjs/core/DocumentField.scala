package io.github.robhinds.shapi.views.reactjs.core

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

object DocumentField {

  case class CustomTextAreaProps(fieldId: String, value: String, rows: Int = 1)
  val customeTextArea = ScalaComponent
    .builder[CustomTextAreaProps]("CustomTextArea")
    .render_P(props =>
      <.textarea(
        ^.cls := "form-control col-md-8",
        ^.id := props.fieldId,
        ^.value := props.value,
        ^.rows := props.rows
      )
    )


  case class DocumentFieldProps(textarea: Boolean, dropdown: Boolean, fieldName: String, fieldId: String, value: String, rows: Int = 1)
  val documentField = ScalaComponent
    .builder[DocumentFieldProps]("DocumentField")
    .render_P(props =>
      <.div(
        <.div(
          ^.cls := "form-group row",
          <.span(
            ^.cls := "col-md-2 font-weight-bold",
            s"${props.fieldName}"
          )
        )
      )
    )

}

//<div style= {{paddingTop: "25px"}}>
//<div className="form-group row">
//<span className="col-md-2 font-weight-bold" >{ this.props.fieldName }: </span>
//{
//(this.props.textarea && <DocumentTextArea {...this.props} />) ||
//(this.props.dropdown && <DocumentSelect {...this.props} />) ||
//<span className="col-md-8">{this.props.value}</span>
//}
//</div>
//</div>