import { combineReducers } from 'redux'

import settings from './settings'
import stickers from '../component/kit-sticker-search/reducer/stickers'

export default combineReducers({
  stickerLabels: stickers,
  settings,
})
