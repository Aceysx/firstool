import * as request from '../../core/request/fetch-request'

export const getRandomStickers = () => {
  return (dispatch) => {
    (async () => {
      const data = await request.get(`./api/users/21`)
      dispatch({
        type: 'GET_STICKERS',
        data
      })
    })()
  }
}
