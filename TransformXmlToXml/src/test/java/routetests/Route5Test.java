package routetests;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.builder.AdviceWithRouteBuilder;
import org.apache.camel.model.RouteDefinition;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.apache.commons.io.FileUtils;
import org.custommonkey.xmlunit.DetailedDiff;
import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.Difference;
import org.junit.Test;
import org.springframework.util.ResourceUtils;
import routes.Route5;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;

/**
 * Created by Zoli on 2/03/2017.
 */
public class Route5Test extends CamelTestSupport {


    protected CamelContext createCamelContext() throws Exception {
        CamelContext context = super.createCamelContext();
        context.addRoutes(new Route5());

        return context;
    }





    @Override
    public void setUp() throws Exception{
        super.setUp();



        RouteDefinition route5Definition = context.getRouteDefinition("route5");

        route5Definition.adviceWith(context, new AdviceWithRouteBuilder() {
            @Override
            public void configure() throws Exception {
                replaceFromWith("direct:in");
                interceptSendToEndpoint("file:TransformXmlToXml/src/main/resources/data/outbox")
                .skipSendToOriginalEndpoint().to("mock:out");
            }
        });
    }

    @Test
    public void route5_whenValidInput_thenValidOutput() throws Exception{
        String request = FileUtils.readFileToString(ResourceUtils.getFile("classpath:input/request.xml"));
        String expected = FileUtils.readFileToString(ResourceUtils.getFile("classpath:expected/successResult.xml"));

        template.sendBody("direct:in", request);

        Exchange ex = getMockEndpoint("mock:out").getExchanges().get(0);
       String result = ex.getIn().getBody(String.class);


        Diff diff = new Diff(expected, result);

        List<Difference> differences = new DetailedDiff(diff).getAllDifferences();

        for (Object object : differences) {
            Difference difference = (Difference)object;
            System.out.println("***********************");
            System.out.println(difference);
            System.out.println("***********************");
        }


        assertThat(differences.size(), is(0));



    }


}
