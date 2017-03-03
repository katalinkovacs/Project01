package processors;

import employeeversion1.Employeeversion1;
import employeeversion2.Employeeversion2;
import org.apache.camel.Exchange;


public class Processor1 {

    // processor1Method method --> argument (Exchange ex)

    public void processor1Method (Exchange ex) throws Exception {

        //change file name to have a different output file name
        ex.getIn().setHeader("CamelFileName", "Employee1toEmployee2.xml");
        // camel file component
        //gets the unmarshaled java object from message body
        // this is standard camel how to get the body
        Employeeversion1 e1 = (Employeeversion1) ex.getIn().getBody();

        //get date from p1 object
        String lastName = e1.getLastname();
        String firstName = e1.getFirstname();


        //Create a new empty Person2 object
        Employeeversion2 p2 = new Employeeversion2();

        // add the retrieved data from p1 to p2
        p2.setGivenname(firstName);
        p2.setFamilyname(lastName);

        // set the body with new p2 object
        ex.getIn().setBody(p2);

    }

}
