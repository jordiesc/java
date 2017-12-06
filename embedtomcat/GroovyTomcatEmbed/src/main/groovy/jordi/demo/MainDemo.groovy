/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jordi.demo;

import java.util.Optional;
import org.apache.catalina.startup.Tomcat;

/**
 *
 * @author jordi
 */
public class MainDemo {

    def static PORT = System.getenv("HOSTNAME") 
    def static HOSTNAME = System.getenv("HOSTNAME")

    public static void main(String[] args) throws Exception {
        def contextPath = "/";
        def appBase = ".";
        def tomcat = new Tomcat();
        tomcat.setPort(8080)
        tomcat.setHostname(HOSTNAME ?: "localhost")
        tomcat.getHost().setAppBase(appBase)
        tomcat.addWebapp(contextPath, appBase)
        tomcat.start()
        tomcat.getServer().await()
    }
}
