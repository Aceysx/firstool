import React from 'react'
import { EuiTitle } from '@elastic/eui'

const LabelBox = ({ labels }) => {
  return <div>
    {
      labels.length
        ?
        [...labels].map((label, index) => {
          const { title, color, url } = label
          return <EuiTitle size="xs"
                           style={{ display: 'inline-block', margin: '5px 20px', color }}
                           key={index}>
            <span>{title}</span>
          </EuiTitle>
        })
        : <span>empty</span>
    }
  </div>
}
export default LabelBox