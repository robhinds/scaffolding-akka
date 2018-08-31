import React, { Component } from 'react';
import GeneratedTableComponent from '../components/GeneratedTableComponent';

export default class GeneratedTableContainer extends Component {
  render() {
    return <GeneratedTableComponent numer="4" someText="hello something" working="true" dirty="false"/>;
  }
}
