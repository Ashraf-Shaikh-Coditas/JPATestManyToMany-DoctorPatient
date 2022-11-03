package com.bean;

import javax.persistence.*;
import java.util.List;

@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int doctorId;
    private String doctorName;
    private int experience;
    private String specialization;
    private int fees;

    @ManyToMany(mappedBy = "doctorList",cascade = CascadeType.ALL)
    private List<Patient> patientList;

    public Doctor(String doctorName, int experience, String specialization, int fees, List<Patient> patientList) {
        this.doctorName = doctorName;
        this.experience = experience;
        this.specialization = specialization;
        this.fees = fees;
        this.patientList = patientList;
    }

    public Doctor(String doctorName, int experience, String specialization, int fees) {
        this.doctorName = doctorName;
        this.experience = experience;
        this.specialization = specialization;
        this.fees = fees;
    }

    public Doctor() {
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getFees() {
        return fees;
    }

    public void setFees(int fees) {
        this.fees = fees;
    }

    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId=" + doctorId +
                ", doctorName='" + doctorName + '\'' +
                ", experience=" + experience +
                ", specialization='" + specialization + '\'' +
                ", fees=" + fees +
                ", patientList=" + patientList +
                '}';
    }
}
