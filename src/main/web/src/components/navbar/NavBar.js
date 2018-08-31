import React, { Component } from 'react';
import { Link } from "react-router-dom";
import { ActionButton } from '../common/Button';

export default class NavBar extends Component {

  render() {
    return (
      <header>
        <nav className="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
          <Link to="/documents" className="navbar-brand" href="#">
            Hackday Banter
          </Link>
          <div className="collapse navbar-collapse" id="navbarCollapse">
            <ActionButton to="/" className="my-2 my-sm-0 ml-auto" text="Log out" />
          </div>
        </nav>
      </header>
    );
  }
}
