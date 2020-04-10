def label = 'tws-notification'
def pvcPath = '/home/jenkins/.gradle'
podTemplate(label: label, namespace: 'ci',
    volumes: [
        hostPathVolume(
            hostPath: '/usr/share/zoneinfo/Asia/Shanghai',
            mountPath: '/etc/localtime'),
        hostPathVolume(
            hostPath: '/usr/local/bin/kubectl',
            mountPath: '/usr/local/bin/kubectl'),
        persistentVolumeClaim(
            claimName: 'ci-jenkins-slave',
            mountPath: '/home/jenkins/.gradle')
    ]
) {
    node(label) {
        stage('Checkout deployment config') {
            def jobNameToGoLive = 'TWS-NOTIFICATION-CENTER'
            sh "cp ${pvcPath}/deployments/${jobNameToGoLive}/${params.GO_LIVE_NUMBER}/deployment.production.yml deployment.production.yml"
        }

        stage('Deploy to production') {
            withCredentials([[$class: 'FileBinding', credentialsId: 'kube_config_file', variable: 'KUBECTL_CONFIG_FILE']]) {
                sh 'kubectl --kubeconfig=$KUBECTL_CONFIG_FILE apply -f deployment.production.yml'
            }
        }
    }
}
