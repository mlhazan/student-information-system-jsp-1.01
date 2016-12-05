/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;


/**
 *@author M.Hasan
 *Date:31-Mar-2015
 *
 */
public class Student {
    private String lastName ;
    private String firstName ;
    private String id ;

    public Student() {
        
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
