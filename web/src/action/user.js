import * as request from '../component/core/request/fetch-request'

export const initUser = () => {
  return (dispatch) => {
    (async () => {
      const res = await request.get(`./api/users/21`)
      if (res.status === 200) {
        dispatch({
          type: '',
          user: res.body
        })
      }
    })()
  }
}
