import React, { Component } from 'react'

export default class DocumentTextArea extends Component {
  render() {
    return <textarea
      className="form-control col-md-8"
      id={ this.props.fieldId }
      onChange={e => this.props.onChange(e.target.value)}
      value={ this.props.value }
      rows={ this.props.rows || "1" }
      readOnly={ this.props.readonly }
      />
  }
}
