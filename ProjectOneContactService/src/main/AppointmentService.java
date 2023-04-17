package src.main;

import java.util.HashMap;

public class AppointmentService {
    // maps appointmentID to appointment object
    private static AppointmentService reference = new AppointmentService();

    private static HashMap<String, Appointment> apptMap;

    public AppointmentService() {
        AppointmentService.apptMap = new HashMap<String, Appointment>();
    }

    /*public Appointment getAppt(String apptId) {
        if(!apptMap.containsKey(apptId)) {
            throw new IllegalArgumentException("Appointment ID not found");
        }
        return apptMap.get(apptId);
    }*/

    //Create a singleton Appointment Service
    public static AppointmentService getService() {
        return reference;
    }
    //add new appointment
    public boolean addAppt(Appointment appointment) {
        if(apptMap.containsKey(appointment.getApptId()))
            throw new IllegalArgumentException("Appointment ID already exists.");
            apptMap.put(appointment.getApptId(), appointment);
            return true;
    }
    //delete contact
    public void deleteAppt(String apptId) {
        if (apptMap.containsKey(apptId)) {
            apptMap.remove(apptId);
        }
    }
}


