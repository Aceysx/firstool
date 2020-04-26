const init = [
  // {
  //   title: '',
  //   url: ''
  // }
]

export default (state = init, action) => {
  if (action.type === 'GET_STICKERS') {
    return action.data
  } else { return state }
}
