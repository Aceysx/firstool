import React from 'react'
import { EuiPage, EuiPageBody, EuiPageContent, EuiPageContentBody, EuiPageHeader } from '@elastic/eui'
import Header from './header'

const FirstoolLayout = (props) => {
  return <div style={{ height: '980px', overflowY: 'hidden' }}>
    <EuiPage style={{ height: '100%' }}>
      <EuiPageBody component="div">
        <EuiPageHeader>
          <Header/>
        </EuiPageHeader>
        <EuiPageContent>
          <EuiPageContentBody>{props.children}</EuiPageContentBody>
        </EuiPageContent>
      </EuiPageBody>
    </EuiPage>
  </div>
}

export default FirstoolLayout
