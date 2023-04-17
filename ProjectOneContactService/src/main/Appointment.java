package src.main;
import java.util.Date;

/*
* The appointment object shall have a required unique appointment ID string that cannot be longer than 10 characters.
* The appointment ID shall not be null and shall not be updatable.
* The appointment object shall have a required appointment Date field.
* The appointment Date field cannot be in the past. The appointment Date field shall not be null.
Note: Use java.util.Date for the appointmentDate field and use before(new Date()) to check if the date is in the past.
The appointment object shall have a required description String field that cannot be longer than 50 characters.
* The description field shall not be null.
* */


public class Appointment {
    private final String apptId; // 10 char or less, not null, and not updatable;
    private Date apptDate; //can not be in the past and not null
    private String apptDescription; //can not be longer than 50 char and not null.

    public Appointment(String apptId, Date apptDate, String apptDescription) {
        if (apptId == null) {
            throw new IllegalArgumentException("Appointment ID can not be null");
        }
        if ( apptId.length() > 10){
            throw new IllegalArgumentException("Appointment ID can  not be longer than 10 char");
        }
        if (apptDate == null) {
            throw new IllegalArgumentException("Invalid Date");
        }
        if (apptDate.before(new Date())){
            throw new IllegalArgumentException("Invalid Date");
        }
        if (apptDescription == null) {
            throw new IllegalArgumentException("Invalid Appointment Description");
        }
        if (apptDescription.length() > 50){
            throw new IllegalArgumentException("Invalid Appointment Description");
        }


    //Set variable to the name of the object
        this.apptId =apptId;
        this.apptDate =apptDate;
        this.apptDescription =apptDescription;
    }

    //Getters
    public String getApptId() {
        return apptId;
    }
    public Date getApptDate() {return apptDate;}
    public String getApptDescription() {return apptDescription;}

    // Method to validate  the requirements
    private boolean validateInput(String item, int length){
        if(item == null){
            throw new IllegalArgumentException( item + "can not be null.");
        }

        if(item.length() > length ) {
            throw new IllegalArgumentException("Invalid " + item);
        }
        return true;
    }
    public void setApptDate(Date apptDate) {
        if (apptDate == null ) {
            throw new IllegalArgumentException("Invalid Appointment Date");
        }

        if(apptDate.before(new Date())){
            throw new IllegalArgumentException("Invalid Appointment Date");
    }
        this.apptDate = apptDate;
    }

    public boolean setApptDescription(String apptDescription) {
        //verify appointment description is not greater than 50 char and not null
        boolean IsValid = validateInput(apptDescription, 50);
        if(IsValid) {
            this.apptDescription = apptDescription;
        }
        return IsValid;
    }
}