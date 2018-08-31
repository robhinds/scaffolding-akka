import React, { Component } from 'react'

export default class DocumentSelect extends Component {
  render() {
    return (
      <select
        className="form-control col-md-8"
        id={ this.props.fieldId }
        onChange={e => this.props.onChange(e.target.value)}
        disabled={ this.props.readonly }
        value={this.props.value}
        >
        <option key="blank" value=""></option>
        {this.props.options.map(x =>
            <option key={x.key || x} value={x.key || x} >
              {x.value || x}
            </option>
        )}
      </select>
    )
  }
}
