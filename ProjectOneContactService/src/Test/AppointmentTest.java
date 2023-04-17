package src.Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import src.main.Appointment;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertTrue;
class AppointmentTest {
        @Test
        void testApptConstructor() {
            Calendar c = Calendar.getInstance();
            c.set(2024, 03, 28, 3, 29);
            Date date = c.getTime();

            //id too long
            Assertions.assertThrows(IllegalArgumentException.class, () ->{
                new Appointment("12345678901", date, "Appt Description");
            });
            //id null
            Assertions.assertThrows(IllegalArgumentException.class, () ->{
                new Appointment(null, date , "Appt Description");
            });
            //description too long
            Assertions.assertThrows(IllegalArgumentException.class, () ->{
                new Appointment("1234567890", date , "Thisisadescription"
                        + "thatiswaytoolongtobevalidforthisconstructor");
            });
            //description null
            Assertions.assertThrows(IllegalArgumentException.class, () ->{
                new Appointment("1234567890", date , null);
            });
            //date null
            Assertions.assertThrows(IllegalArgumentException.class, () ->{
                new Appointment("1234567890", null , "Appt Description");
            });
            /*date before today
            date.setTime(0);
            Assertions.assertThrows(IllegalArgumentException.class, () ->{
                new Appointment("1234567890", date , "Appt Description");
            });*/

            //everything correct
            Date newDate = c.getTime();
            Appointment appt = new Appointment("1234567890", newDate, "Appt Description");
            assertTrue(appt.getApptId().equals("1234567890"));
            assertTrue(appt.getApptDate().equals(newDate));
            assertTrue(appt.getApptDescription().equals("Appt Description"));

        }

        @Test
         void testSetters() {
            Calendar c = Calendar.getInstance();
            c.set(2025, 10, 5, 9, 15);
            Date date = c.getTime();
            Date newDate = c.getTime();
            Date badDate = new Date();
            badDate.setTime(10000);

            // make object
            Appointment appt = new Appointment("1234567890", newDate, "Appt Description");

            // set new description
            appt.setApptDescription("This is a description");
            // null description error
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                appt.setApptDescription(null);
            });
            // long description error
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                appt.setApptDescription("Thisdescriptionistoolongtobevalidandwillthrowanerror");
            });
            // check that description is changed
            assertTrue(appt.getApptDescription().equals("This is a description"));

            // date is before today
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                appt.setApptDate(badDate);
            });
            // date is null
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                appt.setApptDate(null);
            });

            // date is appropriate
            appt.setApptDate(newDate);
            // check that date changed
            assertTrue(appt.getApptDate().equals(newDate));

        }

    }