import React, { useEffect, useState } from 'react'
import { useDispatch, useMappedState } from 'redux-react-hook'
import { EuiFieldSearch, EuiFlexGroup, EuiFlexItem, EuiSpacer } from '@elastic/eui'
import TickerListBox from './ticker-list-box'
import * as sticker from './action/sticker'

const StickerIndex = (props) => {
  const [state, setState] = useState({
    currentPage: 1
  })

  const propsMerge = { ...useMappedState(state => state), ...props }
  const changeState = (data) => {
    setState({ ...state, ...data })
  }

  const dispatch = useDispatch()

  const searchStickers = keyword => {
  }

  useEffect(() => {
    dispatch(sticker.getRandomStickers())
  }, [])

  const { stickerLabels: stickers } = propsMerge
  return <div>
    <div style={{ height: 50 }}>nav</div>
    <EuiFlexGroup justifyContent="center">
      <EuiFlexItem grow={false}>
        <EuiFieldSearch
          style={{ height: 50, minWidth: 500 }}
          placeholder="Search this"
          onSearch={searchStickers}
          isClearable
        />
      </EuiFlexItem>
    </EuiFlexGroup>
    <EuiSpacer size="xxl"/>
    <EuiSpacer size="xxl"/>
    <TickerListBox
      searchSticker={searchStickers}
      stickers={stickers}/>
    {/*<EuiImage*/}
    {/*  size="s"*/}
    {/*  hasShadow*/}
    {/*  allowFullScreen*/}
    {/*  caption="Click me"*/}
    {/*  alt="Accessible image alt goes here"*/}
    {/*  url="https://source.unsplash.com/2000x1000/?Nature"*/}
    {/*/>*/}
  </div>
}

export default StickerIndex
