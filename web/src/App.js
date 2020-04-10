import React, { Component } from 'react'
import Index from './component/core/index'
import FistoolLayout from './component/core/layout'
import { HashRouter as Router, Route } from 'react-router-dom'
import "@elastic/eui/dist/eui_theme_light.css";

export default class App extends Component {
  render () {
    return (
      <Router>
        <FistoolLayout>
          <Route exact path='/' component={Index} />
        </FistoolLayout>
      </Router>
    )
  }
}
