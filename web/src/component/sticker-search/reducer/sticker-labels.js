const init = [
  // {
  //   title: '',
  //   color: '',
  //   url: ''
  // }
]

export default (state = init, action) => {
  if (action.type === 'GET_STICKER_HOT_LABELS') {
    return action.data
  } else { return state }
}
