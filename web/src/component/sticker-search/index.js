import React, { useEffect, useState } from 'react'
import { useDispatch, useMappedState } from 'redux-react-hook'
import { EuiFieldSearch, EuiFlexGroup, EuiSpacer } from '@elastic/eui'
import LabelBox from './label-box'
import { getHotSearch } from './action/sticker'

const StickerIndex = (props) => {
  const [state, setState] = useState({
    currentPage: 1
  })

  const propsMerge = { ...useMappedState(state => state), ...props }
  const changeState = (data) => {
    setState({ ...state, ...data })
  }

  const dispatch = useDispatch()

  useEffect(() => {
    dispatch(getHotSearch())
  }, [])

  const { stickerLabels } = propsMerge
  console.log(stickerLabels)
  return <div>
    <div style={{ height: 50 }}>nav</div>
    <EuiFlexGroup justifyContent="center">
      <EuiFieldSearch
        style={{ height: 50, minWidth: 500 }}
        placeholder="Search this"
        onChange={() => {}}
        isClearable
      />
    </EuiFlexGroup>
    <EuiSpacer size="xxl"/>
    <EuiSpacer size="xxl"/>
    <EuiFlexGroup justifyContent="center">
      <div style={{ width: '80%' }}>
        <LabelBox
          labels={stickerLabels}/>
      </div>
    </EuiFlexGroup>
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
