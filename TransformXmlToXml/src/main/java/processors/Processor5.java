package processors;

import employees1phonesaddress.Employeeversion1;
import employees2phonesaddress.Employeeversion2;
import org.apache.camel.Exchange;


public class Processor5 {

    public void processor5Method (Exchange ex) throws Exception {

        ex.getIn().setHeader("CamelFileName", "Employees1phonesaddressToEmployees2phonesaddress.xml");

        Employeeversion1 e1 = (Employeeversion1) ex.getIn().getBody();

        //create output xml structure top level
        Employeeversion2 employeeversion2 = new Employeeversion2();

        // second level
        Employeeversion2.Staff staff = new Employeeversion2.Staff();
        employeeversion2.setStaff(staff);


        // looping through the input list with list item type  here the list item type is Employeeversion1.Employees.Employee
        // and the list is from the input body
        for(Employeeversion1.Employees.Employee employeeIn : e1.getEmployees().getEmployee()){

            Employeeversion2.Staff.Staffmember employeeOut = new Employeeversion2.Staff.Staffmember();

            employeeOut.setFamilyname(employeeIn.getLastname());
            employeeOut.setGivenname(employeeIn.getFirstname());

            Employeeversion2.Staff.Staffmember.Phonenumbers phoneNumbers = new Employeeversion2.Staff.Staffmember.Phonenumbers();
            phoneNumbers.setCellphone(employeeIn.getPhones().getMobile());
            phoneNumbers.setLandline(employeeIn.getPhones().getHome());
            employeeOut.setPhonenumbers(phoneNumbers);

            Employeeversion2.Staff.Staffmember.Location location = new Employeeversion2.Staff.Staffmember.Location();
            location.setCity(employeeIn.getAddress().getSuburb());
            location.setStreetname(employeeIn.getAddress().getStreet());
            employeeOut.setLocation(location);

            staff.getStaffmember().add(employeeOut);


        }
        ex.getIn().setBody(employeeversion2);
        System.out.print("hello");
    }
}
