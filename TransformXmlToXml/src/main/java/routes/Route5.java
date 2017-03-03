package routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import processors.Processor5;


public class Route5 extends RouteBuilder{

    Processor5 processor5Object = new Processor5();

    public void configure() throws Exception {

        JaxbDataFormat jaxbDataFormat1 = new JaxbDataFormat("employees1phonesaddress");

        JaxbDataFormat jaxbDataFormat2 = new JaxbDataFormat("employees2phonesaddress");

        //from("file:TransformXmlToXml/src/main/resources/data/input")
        from("file:C:/Kati/Marlo/GitRepo/FileReads/Project01")
                .id("route5")
                .unmarshal(jaxbDataFormat1)
                .bean(processor5Object, "processor5Method")
                .marshal(jaxbDataFormat2)
                .to("file:TransformXmlToXml/src/main/resources/data/outbox");
    }
}
