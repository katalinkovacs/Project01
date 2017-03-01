package startapps;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import routes.Route4;


public class StartApp4 {

    public static void main(String ... args) throws Exception{

        //CREATE CAMELCONTEXT
        CamelContext context = new DefaultCamelContext();

        //ADD ROUTES TO CONTEXT
        context.addRoutes(new Route4());

        context.start();
        Thread.sleep(10000);
        context.stop();
    }
}
