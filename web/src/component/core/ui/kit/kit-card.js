import React from 'react'
import { EuiCard, EuiIcon } from '@elastic/eui'

const KitCard = (props) => {

  return <EuiCard
    layout="horizontal"
    icon={<EuiIcon size="xl" type={'logoBeats'}/>}
    title={'Elastic Beats'}
    description="This card adds uses an 'xl' size icon which works well in a horizontal layout."
    betaBadgeLabel={'nice'}
    betaBadgeTooltipContent={
         'This module is not GA. Please help us by reporting any bugs.'
    }
    onClick={() => window.alert('Card clicked')}
  />
}

export default KitCard
