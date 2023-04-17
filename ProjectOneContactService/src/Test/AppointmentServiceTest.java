package src.Test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import src.main.Appointment;
import src.main.AppointmentService;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertTrue;
public class AppointmentServiceTest {

    private static AppointmentService appointmentService;

    @BeforeAll
    static void setup() {
        appointmentService = AppointmentService.getService();
    }
    private Date date = new Date();

    @Test
    void testAddAppointment() {
        AppointmentService appointmentService = new AppointmentService();
        Appointment appointment = new Appointment( "123456", new Date(), "a description");
        //Appointment appointment2 = new Appointment( "123456789", date, "a descpriton");
        assertTrue(appointmentService.addAppt(appointment));
        //assertTrue(appointmentService.addAppt(appointment2));
        //Appointment updateAppt = appointmentService.getAppt(appointment.getApptId());

    }

    @Test
    void testAddAndDeleteApplication() {
        Calendar c = Calendar.getInstance();
        c.set(2024, 03, 28, 3, 29);
        Date date = c.getTime();
        Date newDate = c.getTime();
        Appointment appointment1 = new Appointment("123456789", newDate, "this is a description");
        Appointment appointment2 = new Appointment( "1234569", newDate, "another descpriton");

        assertTrue(appointmentService.addAppt(appointment1));
        assertTrue(appointmentService.addAppt(appointment2));

        appointmentService.deleteAppt(appointment1.getApptId());


    }

}
