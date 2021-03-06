package routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import processors.Processor3;


public class Route3 extends RouteBuilder{

    Processor3 processor3Object = new Processor3();

    public void configure() throws Exception {

        JaxbDataFormat jaxbDataFormat1 = new JaxbDataFormat("employees1");

        JaxbDataFormat jaxbDataFormat2 = new JaxbDataFormat("employees2");

        from("file:TransformXmlToXml/src/main/resources/data/inbox/inbox3?noop=true")
        //from("file:C:/Kati/Marlo/GitRepo/FileReads/Project01/inbox3")
                .id("route3")
                .unmarshal(jaxbDataFormat1)
                .bean(processor3Object, "processor3Method")
                .marshal(jaxbDataFormat2)
                .to("file:TransformXmlToXml/src/main/resources/data/outbox");
    }
}
