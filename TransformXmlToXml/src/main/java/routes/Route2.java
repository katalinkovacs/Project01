package routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.jaxb.JaxbDataFormat;//
import processors.Processor2;


public class Route2 extends RouteBuilder{

    Processor2 processor2Object = new Processor2();

    public void configure() throws Exception {


        /* DataFormat jaxb = new JaxbDataFormat("com.acme.model");
         *  from("activemq:My.Queue").
         *       unmarshal(jaxb).
         *       to("mqseries:Another.Queue");
         */


        JaxbDataFormat jaxbDataFormat2 = new JaxbDataFormat("employeeversion2");

        JaxbDataFormat jaxbDataFormat1 = new JaxbDataFormat("employeeversion1");


        // FROM FILE TO FILE

        from("file:C:/Kati/Marlo/GitRepo/FileReads/Project01/From2")
        //from("file:TransformXmlToXml/src/main/resources/data/inbox2")
                .id("route2")
                //unmarshalling is the process to read in xml and convert to java object using jaxb generated template
                // classes
                .unmarshal(jaxbDataFormat2)
                //this is to invoke processor to transform person1 to person2
                .bean(processor2Object, "processor2Method")   // object + method
                //marshalling is the process to convert java to xml -- the processor from previous step returns
                // a person2 which will be used to create the output xml
                .marshal(jaxbDataFormat1)
                //.to("file:C:/Kati/Marlo/GitRepo/FileReads/Project01/To2");
                .to("file:TransformXmlToXml/src/main/resources/data/outbox");

    }

}

