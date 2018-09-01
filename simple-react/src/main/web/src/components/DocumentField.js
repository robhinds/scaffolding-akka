import React, { Component } from 'react'
import DocumentTextArea from './DocumentTextArea';
import DocumentSelect from './DocumentSelect';

export default class DocumentField extends Component {
  render() {
    return (
      <div style= {{paddingTop: "25px"}}>
        <div className="form-group row">
          <span className="col-md-2 font-weight-bold" >{ this.props.fieldName }: </span>
          {
            (this.props.textarea && <DocumentTextArea {...this.props} />) ||
            (this.props.dropdown && <DocumentSelect {...this.props} />) ||
            <span className="col-md-8">{this.props.value}</span>
          }
        </div>
      </div>
    )
  }
}
