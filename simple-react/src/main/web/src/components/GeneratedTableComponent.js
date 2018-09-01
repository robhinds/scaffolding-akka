
import React, { Component } from 'react';

export default class GeneratedTableComponent extends Component {

  render() {
    return (
      <div className="container-fluid">
        <table className="table table-bordered table-hover">
          <tbody>
            { this.props.items.map(t => (
              <tr>
                <td>{ t.number }</td><td>{ t.working }</td><td>{ t.someText }</td>
              </tr>
            )) }
          </tbody>
        </table>
      </div>
    );
  }
}

       