package models;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: labuser
 * Date: 7/19/13
 * Time: 2:49 AM
 * To change this template use File | Settings | File Templates.
 */
public class Patients {

    private int id;
    private String name;
    private String gender;
    private int age;
    private List<PatientsResults> patientsResults;
    private int status;






    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
