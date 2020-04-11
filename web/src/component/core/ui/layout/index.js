import React from 'react'
import { EuiPage, EuiPageBody, EuiPageContent, EuiPageContentBody, EuiPageHeader } from '@elastic/eui'
import Header from './header'

const FirstoolLayout = (props) => {
  return <div>
    <EuiPage style={{ minHeight: '700px', overflowY: 'hidden' }}>
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
