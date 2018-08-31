import React, { Component } from 'react'
import { Link } from "react-router-dom";

class Button extends Component {
  render() {
    return (( this.props.onClick &&
        <button type='button'
          className={ this.props.className + " btn btn-raised btn-" + this.props.buttonType}
          onClick={this.props.onClick}
          disabled={this.props.disabled}
          style={{margin: '5px'}}>
            {this.props.text}
        </button>
      ) ||
      (
        this.props.to &&
        <Link to={this.props.to}
          className={ this.props.className + " btn btn-raised btn-" + this.props.buttonType}
          disabled={this.props.disabled}
          style={{margin: '5px'}}>{
            this.props.text}
        </Link>
      )
    )
  }
}

export function ActionButton(props) {
    return <Button {...props} buttonType="primary" />
}
export function SecondaryButton(props) {
    return <Button {...props} buttonType="secondary" />
}
