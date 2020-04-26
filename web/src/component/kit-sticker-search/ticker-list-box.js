import React from 'react'
import { EuiFlexGrid, EuiFlexItem, EuiImage } from '@elastic/eui'

const TickerListBox = ({ stickers }) => {
  return <EuiFlexGrid>
    {
      stickers.length
        ?
        stickers.map((sticker, index) => {
          const { title, url } = sticker
          return <EuiFlexItem key={index}>
            <EuiImage
              style={{ height: 200, width: 200 }}
              key={index}
              hasShadow
              allowFullScreen
              alt={title}
              url={url}
            />
          </EuiFlexItem>
        })
        : <span>empty</span>
    }
  </EuiFlexGrid>
}
export default TickerListBox