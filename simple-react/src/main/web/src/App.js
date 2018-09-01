import React, { Component } from 'react';
import NavBarContainer from './containers/navbar/NavBarContainer';
import { Route, Redirect } from "react-router-dom";
import GeneratedTableContainer from './containers/GeneratedTableContainer';
import GeneratedFormContainer from './containers/GeneratedFormContainer';
import './App.css';

class App extends Component {
  render() {
    return (
      <div className="App">
        <NavBarContainer />
        <main role="main">
          <Route exact path="/" render={() => <Redirect to="/list" />} />
          <Route exact path='/list' component={GeneratedTableContainer} />
          <Route exact path='/edit' component={GeneratedFormContainer} />
        </main>
      </div>
    );
  }
}

export default App;
