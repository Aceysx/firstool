import { combineReducers } from 'redux'

import settings from './settings'
import stickerLabels from '../component/sticker-search/reducer/sticker-labels'

export default combineReducers({
  stickerLabels,
  settings,
})
