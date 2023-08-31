def call(tomcatIp, tomcatCreds){
   sshagent([tomcatCreds]) {
      // copy war file to tomcat
      sh "scp -o StrictHostKeyChecking=no target/online-banking.war ec2-user@${tomcatIp}:/opt/tomcat9/webapps"

      // Stop & Start Tomcat
      sh "ssh ec2-user@${tomcatIp} /opt/tomcat9/bin/shutdown.sh"
      sh "ssh ec2-user@${tomcatIp} /opt/tomcat9/bin/startup.sh"
  }
}
