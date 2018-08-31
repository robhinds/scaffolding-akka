
import React, { Component } from 'react';
import DocumentField from './DocumentField';
import { ActionButton, SecondaryButton } from './common/Button';

export default class DocumentForm extends Component {
  render() {
    return (
      <div>
        <div className="container">
          <form>
            
           <DocumentField
             value={ this.props.number || '' }
             fieldId="number"
             fieldName="Number"
             onChange={newValue => this.props.onChange('number', newValue)}
             textarea
           />
            <DocumentField
              value={ this.props.working ? 'Yes' : 'No' }
              fieldId="working"
              fieldName="Working"
              onChange={newValue => this.props.onChange('working', newValue)}
              options={["Yes", "No"]}
              dropdown
            />
           <DocumentField
             value={ this.props.someText || '' }
             fieldId="someText"
             fieldName="Some text"
             onChange={newValue => this.props.onChange('someText', newValue)}
             textarea
           />
          </form>
        </div>
        <footer className="footer">
          <div className="container">
            <ActionButton text="Save" onClick={() => null}  disabled={!this.props.dirty}/>
            <SecondaryButton text="Cancel" to="/documents" />
          </div>
        </footer>
      </div>
    )
  }
}
      