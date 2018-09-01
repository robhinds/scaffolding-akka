@(nested: List[String])
import React, { Component } from 'react';
import DocumentField from './DocumentField';
import { ActionButton, SecondaryButton } from '../common/Button';

export default class DocumentForm extends Component {
  render() {
    return (
      <div>
        <div className="container">
          <form>
            @for(field <- nested) {
              @field
            }
          </form>
        </div>
        <footer className="footer">
          <div className="container">
            <ActionButton text="Save" onClick={() => null}  disabled={!this.props.dirty}/>
            <SecondaryButton text="Cancel" to="/documents" />
            <SecondaryButton text="Reset" onClick={this.props.resetForm} disabled={!this.props.dirty}/>
          </div>
        </footer>
      </div>
    )
  }
}