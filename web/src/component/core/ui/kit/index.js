import React, { useEffect, useState } from 'react'
import { EuiFlexGrid, EuiFlexItem } from '@elastic/eui'
import { useDispatch, useMappedState } from 'redux-react-hook'
import KitCard from './kit-card'

const Index = (props) => {
  const [state, setState] = useState({
    currentPage: 1
  })

  const propsMerge = { ...useMappedState(state => state), ...props }
  const changeState = (data) => {
    setState({ ...state, ...data })
  }

  const dispatch = useDispatch()

  useEffect(() => {
  }, [])
  const icons = ['Beats', 'Cloud', 'Logging', 'Kibana', 'Kibana',]

  const cardNodes = icons.map(function (item, index) {
    return (
      <EuiFlexItem key={index}>
        <KitCard/>
      </EuiFlexItem>
    )
  })
  return <div style={{height:'100%'}}>
    <EuiFlexGrid columns={4}>
      {cardNodes}
    </EuiFlexGrid>
  </div>
}

export default Index
