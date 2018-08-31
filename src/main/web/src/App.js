import React, { Component } from 'react';
import NavBarContainer from './containers/navbar/NavBarContainer';
import { Route, Redirect } from "react-router-dom";
import GeneratedTableContainer from './containers/GeneratedTableContainer';
import './App.css';

class App extends Component {
  render() {
    return (
      <div className="App">
        <NavBarContainer />
        <main role="main">
          <GeneratedTableContainer />
        </main>
      </div>
    );
  }
}

export default App;
