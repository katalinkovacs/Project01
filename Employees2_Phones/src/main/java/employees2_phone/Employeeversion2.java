//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.03.01 at 11:36:24 AM AEDT 
//


package employees2_phone;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "staff"
})
@XmlRootElement(name = "employeeversion2")


public class Employeeversion2 {

    @XmlElement(required = true)
    protected Employeeversion2 .Staff staff;


    public Employeeversion2 .Staff getStaff() {
        return staff;
    }


    public void setStaff(Employeeversion2 .Staff value) {
        this.staff = value;
    }



    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "staffmember"
    })



    public static class Staff {

        protected List<Employeeversion2 .Staff.Staffmember> staffmember;


        public List<Employeeversion2 .Staff.Staffmember> getStaffmember() {
            if (staffmember == null) {
                staffmember = new ArrayList<Employeeversion2 .Staff.Staffmember>();
            }
            return this.staffmember;
        }



        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "givenname",
            "familyname",
            "phonenumbers"
        })
        public static class Staffmember {

            @XmlElement(required = true)
            protected String givenname;
            @XmlElement(required = true)
            protected String familyname;
            @XmlElement(required = true)
            protected Employeeversion2 .Staff.Staffmember.Phonenumbers phonenumbers;


            public String getGivenname() {
                return givenname;
            }


            public void setGivenname(String value) {
                this.givenname = value;
            }


            public String getFamilyname() {
                return familyname;
            }


            public void setFamilyname(String value) {
                this.familyname = value;
            }


            public Employeeversion2 .Staff.Staffmember.Phonenumbers getPhonenumbers() {
                return phonenumbers;
            }


            public void setPhonenumbers(Employeeversion2 .Staff.Staffmember.Phonenumbers value) {
                this.phonenumbers = value;
            }



            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "cellphone",
                "landline"
            })
            public static class Phonenumbers {

                @XmlElement(required = true)
                protected String cellphone;
                @XmlElement(required = true)
                protected String landline;


                public String getCellphone() {
                    return cellphone;
                }


                public void setCellphone(String value) {
                    this.cellphone = value;
                }


                public String getLandline() {
                    return landline;
                }


                public void setLandline(String value) {
                    this.landline = value;
                }

            }

        }

    }

}
