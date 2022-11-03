package com.dao;

import com.bean.Doctor;
import com.bean.Patient;
import com.util.JPAProvider;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class DoctorDaoImplementation {
    public void addDoctor(Doctor doctor) {
        EntityManager entityManager = JPAProvider.getFactory().createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(doctor);

        entityManager.getTransaction().commit();
    }

    public void assignDoctor(int patientId, int doctorId) {
        EntityManager entityManager = JPAProvider.getFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Doctor doctor = entityManager.find(Doctor.class,doctorId);

        Patient patient = entityManager.find(Patient.class,patientId);

        List<Doctor> doctorList = patient.getDoctorList();

        doctorList.add(doctor);

        patient.setDoctorList(doctorList);

        entityManager.getTransaction().commit();
    }

    public void updateDoctor(int id,int fees) {
        EntityManager entityManager = JPAProvider.getFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Doctor doctor = entityManager.find(Doctor.class,id);

        doctor.setFees(fees);

        entityManager.getTransaction().commit();
    }

    public void deleteDoctor(int id) {
        EntityManager entityManager = JPAProvider.getFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Doctor doctor = entityManager.find(Doctor.class,id);

        entityManager.remove(doctor);
        entityManager.getTransaction().commit();
    }

    public void fetchAllDoctor() {
        EntityManager entityManager = JPAProvider.getFactory().createEntityManager();
        Query query = entityManager.createQuery("from Doctor");

        List<Doctor> doctorList = query.getResultList();

        for(Doctor doctor : doctorList) {
            System.out.println(doctor);
        }
    }

    public void fetchAllDoctorbySpecialization(String specialization) {
        EntityManager entityManager = JPAProvider.getFactory().createEntityManager();
        Query query = entityManager.createQuery("from Doctor where specialization = :x");
        query.setParameter("x",specialization);

        List<Doctor> doctorList = query.getResultList();

        for(Doctor doctor : doctorList) {
            System.out.println(doctor);
        }
    }

    public void fetchAllPatientbyRating(String feedback) {
        EntityManager entityManager = JPAProvider.getFactory().createEntityManager();
        Query query = entityManager.createQuery("select p.patientName,d.doctorName,p.feedback from Patient p  inner join Doctor d" +
                " on p.patientId = d.doctorId where p.feedback =: x group by d.doctorId ");

        query.setParameter("x",feedback);
        List<Object>doctorList = query.getResultList();

        for(Object doctor : doctorList) {
            Object[] ar = (Object[]) doctor;
            System.out.println("Patient Name : "+ar[0]+" Doctor Name : "+ar[1]+" Rating  : "+ar[2]);

        }
    }









}
