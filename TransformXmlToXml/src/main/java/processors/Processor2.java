package processors;

import employeeversion1.Employeeversion1;
import employeeversion2.Employeeversion2;
import org.apache.camel.Exchange;

public class Processor2 {

    // processor1Method method --> argument (Exchange ex)

    public void processor2Method (Exchange ex) throws Exception {


        ex.getIn().setHeader("CamelFileName", "Employee2toEmployee1.xml");

        Employeeversion2 e2 = (Employeeversion2) ex.getIn().getBody();


        String firstName = e2.getGivenname();
        String lastName = e2.getFamilyname();


        Employeeversion1 e1 = new Employeeversion1();

        // add the retrieved data from p1 to p2
        e1.setLastname(lastName);
        e1.setFirstname(firstName);


        ex.getIn().setBody(e1);

    }
}
