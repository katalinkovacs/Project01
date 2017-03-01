package routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import processors.Processor4;


public class Route4 extends RouteBuilder{

    Processor4 processor4Object = new Processor4();

    public void configure() throws Exception {

        JaxbDataFormat jaxbDataFormat1 = new JaxbDataFormat("employees1_phone");

        JaxbDataFormat jaxbDataFormat2 = new JaxbDataFormat("employees2_phone");

        //from("file:TransformXmlToXml/src/main/resources/data/input")
        from("file:TransformXmlToXml/src/main/resources/data/inbox5?noop=true")
                .unmarshal(jaxbDataFormat1)
                .bean(processor4Object, "processor4Method")
                .marshal(jaxbDataFormat2)
                .to("file:TransformXmlToXml/src/main/resources/data/outbox");
    }
}