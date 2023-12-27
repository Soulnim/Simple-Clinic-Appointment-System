
/**
 * Write a description of class Appointment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Appointment
{
    private String apptID;
    private String date;
    private String time;
    
    public Appointment(String a, String b, String c) {
        this.apptID = a;
        this.date = b;
        this.time = c;
    }
    
    public void setApptID(String a) { this.apptID = a; }
    public void setDate(String b) { this.date = b; }
    public void setTime(String c) { this.time = c; }
    
    public String getApptID() { return this.apptID; }
    public String getDate() { return this.date; }
    public String getTime() { return this.time; }
    
    public String toString() {
        return "Appointment ID : "+this.apptID+" | Date : "+this.date+" | Time : "+this.time;
    }
}
