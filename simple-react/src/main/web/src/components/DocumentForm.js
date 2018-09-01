import React, { Component } from 'react';
import DocumentField from './DocumentField';
import { ActionButton, SecondaryButton } from '../common/Button';

export default class DocumentForm extends Component {
  render() {
    return (
      <div>
        <div className="container">
          <form>
            <DocumentField
              value={ this.props.title || '' }
              fieldId="title"
              fieldName="Title"
              editable="true"
              onChange={newValue => this.props.onChange('title', newValue)}
              textarea
              readonly
              />
            <DocumentField
              value={ this.props.isPublished ? 'Yes' : 'No' }
              fieldId="published"
              fieldName="Published"
              onChange={newValue => this.props.onChange('isPublished', newValue)}
              options={["Yes", "No"]}
              dropdown
              readonly
              />
            <DocumentField
              value={this.props.topic}
              fieldId="topic"
              fieldName="Topics (S0)"
              editable="true"
              onChange={newValue => this.props.onChange('topic', newValue)}
              options={this.props.topics}
              dropdown
              readonly={!this.props.isStatic}
              />
            <DocumentField
              value={ this.props.description || '' }
              fieldId="description"
              fieldName="Description"
              rows="5"
              editable="true"
              onChange={newValue => this.props.onChange('description', newValue)}
              textarea
              />
            <DocumentField
              value={ this.props.documentType ? this.props.documentType.id : '' }
              fieldId="type"
              fieldName="Type"
              onChange={newValue => this.props.onChange('documentType', newValue)}
              options={this.props.docTypes}
              dropdown
              readonly={!this.props.isStatic}
              />
            <DocumentField
              value={ this.props.isStatic ? 'Static' : 'HotDocs' }
              fieldId="source"
              fieldName="Source"
              onChange={newValue => this.props.onChange('isStatic', newValue)}
              options={["Static", "HotDocs"]}
              dropdown
              readonly
              />
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
