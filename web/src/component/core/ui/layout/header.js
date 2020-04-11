import React, { useState } from 'react'

import {
  EuiAvatar,
  EuiFacetButton,
  EuiHeader,
  EuiHeaderLink,
  EuiHeaderLinks,
  EuiHeaderLogo,
  EuiHeaderSection,
  EuiHeaderSectionItem,
} from '@elastic/eui'

const menus = {
  MY_PACKET: 'my_packet',
  TOOL_SHOP: 'tool_shop'
}
const Header = () => {
  const [state, setState] = useState({
    active: menus.MY_PACKET
  })

  return (
    <EuiHeader position='fixed'
               style={{ width: '100%', padding: '0 10px' }}>
      <EuiHeaderSectionItem border="none">
        <EuiHeaderLogo href="#"/>
      </EuiHeaderSectionItem>
      <EuiHeaderLinks>
        <EuiHeaderLink
          href="#"
          isActive={state.active === menus.MY_PACKET}
          onClick={() => setState({ active: menus.MY_PACKET })}
        >
          工作台
        </EuiHeaderLink>
        <EuiHeaderLink
          href="#"
          isActive={state.active === menus.TOOL_SHOP}
          onClick={() => setState({ active: menus.TOOL_SHOP })}>
          工具库
        </EuiHeaderLink>
      </EuiHeaderLinks>
      <EuiHeaderSection side="right">
        <EuiHeaderSectionItem border='none'>
          <EuiFacetButton
            icon={<EuiAvatar size="m" name="acey"/>}>
            acey | 登陆
          </EuiFacetButton>
        </EuiHeaderSectionItem>
      </EuiHeaderSection>
    </EuiHeader>
  )
}

export default Header