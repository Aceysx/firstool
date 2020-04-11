const cheerio = require('cheerio')
const $ = require('jquery')

const getHtml = async url => {
  // $.ajaxPrefilter(function (options) {
  //   if (options.crossDomain && window.jQuery.support.cors) {
  //     const http = (window.location.protocol === 'http:' ? 'http:' : 'https:')
  //     options.url = http + '//cors-anywhere.herokuapp.com/' + options.url
  //   }
  // })
  return await $.get(url)
}

const Crawler = {
  getHotSearch: async () => {
    // return getHtml(`https://fabiaoqing.com/search`)
    return (await getHtml(`http://localhost:3000/data.html`)
      .then((html) => {
        const $ = cheerio.load(html)
        const $dom_arr = $('a')
        return $dom_arr.filter((index, elem) => {
            return ($(elem).attr('class') || '').includes('header')
              && ($(elem).attr('title') || '').length < 20
          }
        ).map((index, elem) => {
          const url = $(elem).attr('href') || ''
          const title = ($(elem).attr('title') || '').replace('表情包搜索', '')
          const color = $(elem).attr('class').split(' ')[0]
          return { url, title, color }
        })
      })).toArray()
  }
}
export default Crawler