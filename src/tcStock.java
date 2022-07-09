import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.Context;

 public class tcStock {
 
   Tomcat tomcat;

private void startTomcat() throws FileNotFoundException, IOException, LifecycleException  {	
          
        tomcat = new Tomcat();
        tomcat.setPort(8100);
       tomcat.setBaseDir("/home/ec2-user/Sources");
           


//  String contextPath2 = "/NQmaps";
//       String docBase = "/var/www/rivermaps/nqland/map.html";
//Context one = tomcat.addWebapp(contextPath2,docBase);

Context two = tomcat.addWebapp( "/Cattle","/home/ec2-user/jStock/target/jStock.war" );
      

  
        tomcat.getHost().setAppBase(".");
        tomcat.start();
        tomcat.getServer().await();
         }

  void stopTomcat() throws LifecycleException, SQLException {
       tomcat.stop();  
        }

    public static void main(String args[]) throws IOException, FileNotFoundException{
      try {
          tcStock tomcat=new tcStock();
          tomcat.startTomcat();
          Thread.sleep(100000);
          tomcat.stopTomcat();
  } catch (InterruptedException | SQLException | LifecycleException e){
   }
     
 }
}

