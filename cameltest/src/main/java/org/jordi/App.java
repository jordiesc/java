/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package org.jordi;


public class App {
    public String getGreeting() throws Exception {
       try {
        final CamelStarted2 cs = new CamelStarted2();
        cs.createCamelPipeline();
        
       } catch (Exception e ){
           System.err.println(e.getMessage());
           e.printStackTrace();
       }
       return "ok";
    }

    public static void main(final String[] args) throws Exception {
        System.out.println(new App().getGreeting());
    }
}
