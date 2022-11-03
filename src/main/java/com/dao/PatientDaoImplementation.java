package com.dao;

import com.bean.Doctor;
import com.bean.Patient;
import com.util.JPAProvider;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class PatientDaoImplementation {
    public void addPatient(Patient patient) {
        EntityManager entityManager = JPAProvider.getFactory().createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(patient);

        entityManager.getTransaction().commit();
    }

    public void updatePatient(int id, String feedback) {
        EntityManager entityManager = JPAProvider.getFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Patient patient = entityManager.find(Patient.class, id);


        patient.setFeedback(feedback);

        entityManager.getTransaction().commit();
    }

    public void deletePatient(int id) {
        EntityManager entityManager = JPAProvider.getFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Patient patient = entityManager.find(Patient.class, id);
        entityManager.remove(patient);
        entityManager.getTransaction().commit();
    }

    public void fetchAllPatient() {
        EntityManager entityManager = JPAProvider.getFactory().createEntityManager();
        Query query = entityManager.createQuery("from Patient");

        List<Patient> doctorList = query.getResultList();

        for(Patient doctor : doctorList) {
            System.out.println(doctor);
        }
    }

    public void fetchAllPatientbyDoctorName(String doctorname) {
        EntityManager entityManager = JPAProvider.getFactory().createEntityManager();
        Query query = entityManager.createQuery("from Doctor where doctorName = : x");

        List<Object>doctorList = query.getResultList();

        for(Object doctor : doctorList) {
            Object[] ar = (Object[]) doctor;
            System.out.println("Patient Name : "+ar[0]+" Doctor Name : "+ar[1]);

        }
    }
}
