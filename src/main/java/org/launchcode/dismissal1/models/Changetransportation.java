package org.launchcode.dismissal1.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Changetransportation {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 3, max= 15, message = "Select Current Transportation.")
    private String transportation;

    @NotNull
    @Size(min = 3, max= 15, message = "Select Transportation change.")
    private String transportationchange;

    @NotNull
    @Size(min = 3, max= 15, message = "Enter date in mm:dd:yyyy format.")
    private String datec;

    @NotNull
    @Size(min = 3, max=200, message= "Write a note for your records.")
    private String notes1;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @ManyToOne
    private Student student;



//@Size(min = 3)
//format of date and time of submission
//private LocalDateTime submission=LocalDateTime.now();
//DateTimeFormatter forsubmission = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//private String formattedDate = submission.format(forsubmission);

    public Changetransportation(String transportation, String transportationchange, String datec, String notes1) {
        this.transportation = transportation;
        this.transportationchange=transportationchange;
        this.datec = datec;
        this.notes1 = notes1;
        //this.formattedDate = formattedDate;
        }

    public Changetransportation() {

    }

    public int getId() {
        return id;
        }

    public String getTransportation() {
        return transportation;
        }

    public void setTransportation(String transportation ) {
        this.transportation = transportation;
        }

    public String getTransportationchange() {
        return transportationchange;
        }

    public void setTransportationchange(String transportationchange) { this.transportationchange = transportationchange; }

    public String getDatec() {
        return datec;
        }

    public void setDatec(String datec) {
        this.datec = datec;
        }

    public String getNotes1() {
        return notes1;
        }

    public void setNotes1(String notes1) {
        this.notes1 = notes1;
        }
}