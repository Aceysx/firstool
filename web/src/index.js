import React from 'react'
import ReactDOM from 'react-dom'
import { applyMiddleware, createStore } from 'redux'
import thunkMiddleware from 'redux-thunk'
import { StoreContext } from 'redux-react-hook'

import reducer from './reducer'
import App from './App'

import './style/index.css'

const store = createStore(reducer, applyMiddleware(thunkMiddleware))

ReactDOM.render(
  <StoreContext.Provider value={store}>
    <App />
  </StoreContext.Provider>,
  document.getElementById('root'))
