package io.github.robhinds.shapi.utils

import io.github.robhinds.shapi.utils.TextUtils._

object ComponentUtils {

  def documentField(name: String, text: Boolean=true) = {
    s"""
           <DocumentField
             value={ this.props.$name || '' }
             fieldId="$name"
             fieldName="${toSentence(name).capitalize}"
             onChange={newValue => this.props.onChange('$name', newValue)}
             textarea
           />"""
  }

  def booleanDropDown(name: String) = {
    s"""
            <DocumentField
              value={ this.props.$name ? 'Yes' : 'No' }
              fieldId="$name"
              fieldName="${toSentence(name).capitalize}"
              onChange={newValue => this.props.onChange('$name', newValue)}
              options={["Yes", "No"]}
              dropdown
            />"""
  }

}
