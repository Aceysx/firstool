import Crawler from '../../core/crawler/crawler'

export const getHotSearch = () => {
  return (dispatch) => {
    (async () => {
      const data = await Crawler.getHotSearch()
      dispatch({
        type: 'GET_STICKER_HOT_LABELS',
        data
      })
    })()
  }
}
