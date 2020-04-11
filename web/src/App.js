import React, { Component } from 'react'
import KitIndex from './component/core/ui/kit'
import StickerIndex from './component/sticker-search/index'
import FistoolLayout from './component/core/ui/layout'
import { BrowserRouter as Router, Route } from 'react-router-dom'
import '@elastic/eui/dist/eui_theme_light.css'

export default class App extends Component {
  render () {
    return (
      <Router>
        <FistoolLayout>
          <Route exact path='/' component={KitIndex}/>
          <Route exact path='/kit' component={KitIndex}/>
          <Route exact path='/kit-sticker' component={StickerIndex}/>
          <Route exact path='/shop' component={KitIndex}/>
        </FistoolLayout>
      </Router>
    )
  }
}
