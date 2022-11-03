package com.bean;

import javax.persistence.*;
import java.util.List;
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patientId;
    private String patientName;
    private int patientAge;
    private String disease;
    private String feedback;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Doctor> doctorList;

    public Patient() {

    }

    public Patient(String patientName, int patientAge, String disease, String feedback) {
        this.patientName = patientName;
        this.patientAge = patientAge;
        this.disease = disease;
        this.feedback = feedback;
    }

    public Patient(int patientId, String patientName, int patientAge, String disease, String feedback, List<Doctor> doctorList) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.patientAge = patientAge;
        this.disease = disease;
        this.feedback = feedback;
        this.doctorList = doctorList;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public int getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(int patientAge) {
        this.patientAge = patientAge;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public List<Doctor> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(List<Doctor> doctorList) {
        this.doctorList = doctorList;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", patientName='" + patientName + '\'' +
                ", patientAge=" + patientAge +
                ", disease='" + disease + '\'' +
                ", feedback='" + feedback + '\'' +
                '}';
    }
}
