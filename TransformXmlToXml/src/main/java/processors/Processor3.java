package processors;

import employees1.Employeeversion1;
import employees2.Employeeversion2;
import org.apache.camel.Exchange;


public class Processor3 {

    // processor1Method method --> argument (Exchange ex)

    public void processor3Method (Exchange ex) throws Exception {

        ex.getIn().setHeader("CamelFileName", "Employee1toEmployee2.xml");

        Employeeversion1 e1 = (Employeeversion1) ex.getIn().getBody();


        /*
        for(Account a : customer1.myAccounts){
            System.out.println(a.getClass());
            System.out.println(a.getAccountNumber());
            System.out.println(a.getBalance());
        }
        */

        for(Employeeversion1.Employees.Employee e1 : Employeeversion1.Employees.Employee.g){
            System.out.println(e1.getClass());
            //System.out.println(e1.getAccountNumber());

        }



    }




}
