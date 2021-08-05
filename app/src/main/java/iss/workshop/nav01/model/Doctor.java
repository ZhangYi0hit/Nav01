package iss.workshop.nav01.model;

public class Doctor {
    Integer id;
    String name;
    String hospitalName;
    String major;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public String getMajor() {
        return major;
    }

    public Doctor(Integer id, String name, String hospitalName, String major) {
        this.id = id;
        this.name = name;
        this.hospitalName = hospitalName;
        this.major = major;
    }
}