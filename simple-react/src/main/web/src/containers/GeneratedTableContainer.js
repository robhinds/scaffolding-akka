import React, { Component } from 'react';
import GeneratedTableComponent from '../components/GeneratedTableComponent';

export default class GeneratedTableContainer extends Component {

  state = {
    items: [
        {
            number: "4",
            someText:"hello something",
            working:"true"
        },
        {
            number:"16",
            someText:"bye something",
            working:"false"
        }
    ]
  }


  render() {
    return <GeneratedTableComponent items={this.state.items}/>;
  }
}
