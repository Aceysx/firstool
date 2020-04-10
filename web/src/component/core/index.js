import React, { useEffect, useState } from 'react'
import { EuiFlexGroup, EuiFlexItem, EuiCard, EuiIcon} from '@elastic/eui'
import { useDispatch, useMappedState } from 'redux-react-hook'

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
  const icons = ['Beats', 'Cloud', 'Logging', 'Kibana'];

  const cardNodes = icons.map(function(item, index) {
    return (
      <EuiFlexItem key={index}>
        <EuiCard
          icon={<EuiIcon size="xxl" type={`logo${item}`} />}
          title={`Elastic ${item}`}
          isDisabled={item === 'Kibana' ? true : false}
          description="Example of a card's description. Stick to one or two sentences."
          onClick={() => window.alert('Card clicked')}
        />
      </EuiFlexItem>
    );
  });
  return <div>
    <EuiFlexGroup gutterSize="l">{cardNodes}</EuiFlexGroup>
  </div>
}

export default Index
