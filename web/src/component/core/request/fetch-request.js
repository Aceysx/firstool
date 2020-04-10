import HTTP_METHOD from './httpMethod'

const getHeaderFromLocalStorage = (key) => {
  return window.localStorage.getItem(key)
}

export const get = async (url) => {
  try {
    const res = await fetch(url, {
      method: HTTP_METHOD.GET,
      credentials: 'include',
      headers: new Headers({
        id: 21,
        'Accept': 'application/json;charset=utf-8',
        token: getHeaderFromLocalStorage('jwt'),
        sessionId: getHeaderFromLocalStorage('sessionId')
      })
    })

    const body = await res.json()
    return Object.assign({}, { body }, { status })

  } catch (ex) {
    return { status: ex.status }
  }

}

export const del = async (url) => {
  try {
    const res = await fetch(url, {
      method: HTTP_METHOD.DELETE,
      credentials: 'include',
      headers: new Headers({
        id: 21,
        token: getHeaderFromLocalStorage('jwt'),
      })
    })

    const status = res.status
    return Object.assign({}, { status })
  } catch (ex) {
    return { status: ex.status }
  }
}

export const post = async (url, user) => {
  try {
    const res = await fetch(url, {
      method: HTTP_METHOD.POST,
      credentials: 'include',
      headers: new Headers({
        id: 21,
        'Content-Type': 'application/json;charset=utf-8',
        'Accept': 'application/json',
        token: getHeaderFromLocalStorage('jwt'),
        sessionId: getHeaderFromLocalStorage('sessionId')
      }),
      body: JSON.stringify(user)
    })
    const status = res.status
    const body = await res.json()
    return Object.assign({}, { body }, { status })
  } catch (ex) {
    return { status: ex.status }
  }
}

export const update = async (url, data) => {
  try {
    const res = await fetch(url, {
      method: HTTP_METHOD.PUT,
      credentials: 'include',
      headers: new Headers({
        id: 21,
        'Content-Type': 'application/json;charset=utf-8',
        'Accept': 'application/json',
        token: getHeaderFromLocalStorage('jwt'),
        sessionId: getHeaderFromLocalStorage('sessionId')
      }),
      body: JSON.stringify(data)
    })
    let { status } = res

    let body = status === 204 ? {} : await res.json()
    return Object.assign({}, { body }, { status })
  } catch (ex) {
    return { status: ex.status }
  }
}