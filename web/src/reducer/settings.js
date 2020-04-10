export default (state = {}, action) => {
  if (action.type === 'GET_SETTINGS') {
    return action.data
  } else { return state }
}
