package com.Main;


import com.bean.Doctor;
import com.bean.Patient;
import com.dao.DoctorDaoImplementation;
import com.dao.PatientDaoImplementation;

import javax.print.Doc;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
//        Doctor doctor = new Doctor("Doctor1",5,"Pediatrician",500);
//        Patient patient = new Patient("Patient1",9,"Typhoid","Good");
//
////        new DoctorDaoImplementation().addDoctor(doctor);
////        new PatientDaoImplementation().addPatient(patient);
////
//        new DoctorDaoImplementation().assignDoctor(1,1);


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = true;

        while (flag) {
            System.out.println("1.Add Doctor" +
                    "\n2.Add Patient" +
                    "\n3.Assign Doctor to Patient" +
                    "\n4.Update Doctor" +
                    "\n5.Update Patient" +
                    "\n6.Delete Doctor" +
                    "\n7.Delete Patient" +
                    "\n8.Fetch All Patients" +
                    "\n9.Fetch all doctors" +
                    "\n10. Fetch Doctor by specialization" +
                    "\n11. DoctorWise Patients" +
                    "\n12 Fetch Doctors by rating " +
                    "\nEnter your Choice : ");

            int choice = Integer.parseInt(bufferedReader.readLine());
            switch (choice) {
                case 1:
                    System.out.println("Enter doctor name,exp,specialization,fees ");
                    Doctor doctor = new Doctor(bufferedReader.readLine(), Integer.parseInt(bufferedReader.readLine()
                    ), bufferedReader.readLine(), Integer.parseInt(bufferedReader.readLine()));
                    new DoctorDaoImplementation().addDoctor(doctor);
                    break;
                case 2 :
                    System.out.println("Enter patient name,age,disease,feedback");
                    Patient patient = new Patient(bufferedReader.readLine(),Integer.parseInt(bufferedReader.readLine()),
                            bufferedReader.readLine(),bufferedReader.readLine());
                    new PatientDaoImplementation().addPatient(patient);
                    break;
                case 3 :
                    System.out.println("Enter patient id and doctor id ");
                    new DoctorDaoImplementation().assignDoctor(Integer.parseInt(bufferedReader.readLine()),
                            Integer.parseInt(bufferedReader.readLine()));
                    break;
                case 4 :
                    System.out.println("Enter id of doctor to be updated and new fees");
                    new DoctorDaoImplementation().updateDoctor(Integer.parseInt(bufferedReader.readLine()),
                            Integer.parseInt(bufferedReader.readLine()));
                    break;
                case 5 :
                    System.out.println("Enter id of patient to be updated and new feedback");
                    new PatientDaoImplementation().updatePatient(Integer.parseInt(bufferedReader.readLine()),
                            bufferedReader.readLine());
                    break;
                case 6 :
                    System.out.println("Enter id of doctor to be deleted ");
                    new DoctorDaoImplementation().deleteDoctor(Integer.parseInt(bufferedReader.readLine()));
                    break;
                case 7 :
                    System.out.println("Enter id of patient to be deleted  ");
                    new PatientDaoImplementation().deletePatient(Integer.parseInt(bufferedReader.readLine()));
                    break;
                case 8 :
                    new DoctorDaoImplementation().fetchAllDoctor();
                    break;
                case 9 :
                    new PatientDaoImplementation().fetchAllPatient();
                    break;
                case 10 :
                    System.out.println("Enter specialization you want : ");
                    new DoctorDaoImplementation().fetchAllDoctorbySpecialization(bufferedReader.readLine());
                    break;
                case 11 :
                    System.out.println("Enter doctor name to be fetched : ");
                    new PatientDaoImplementation().fetchAllPatientbyDoctorName(bufferedReader.readLine());
                    break;
                case 12 :
                    System.out.println("Enter your rating : ");
                    new DoctorDaoImplementation().fetchAllPatientbyRating(bufferedReader.readLine());
                    break;
                default:
                    flag = false;
                    break;

            }
        }
    }
}
