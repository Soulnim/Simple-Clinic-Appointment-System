
/**
 * Write a description of class ClinicApp here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;

public class ClinicApp
{
    static Scanner inText = new Scanner(System.in);
    static Scanner inChar = new Scanner(System.in);
    static Scanner inNum = new Scanner(System.in);
    
    static Appointment apptList[] = new Appointment[100];
    public static void main(String args[]) {
        // 'for' below is for testing data
        for (int i=0; i<=35; i++) {
            apptList[i] = new Appointment("APT0"+i, "DT"+i, "TM"+i);
        }
        while (true) {
            int key = dashboard();
            if (key == 0) {
                break;
            }
        }
    }
    
    public static int dashboard() {
        System.out.print("\f");
        System.out.println("+-------------------------------------------------------+");
        System.out.println(" CLINIC APPOINTMENT SYSTEM");
        System.out.println("+-------------------------------------------------------+");
        System.out.println(" A] View Appointment List");
        System.out.println(" B] Add New Appointment");
        System.out.println(" C] Edit Appointment Data");
        System.out.println(" D] Delete Appointment");
        System.out.println(" E] Statistics");
        System.out.println(" F] Exit");
        System.out.println("+-------------------------------------------------------+");
        System.out.print(" Option : ");
        char option = inChar.next().charAt(0);
        if (option == 'A' || option == 'a') {
            viewAppointment();
        }
        else if (option == 'B' || option == 'b') {
            addAppointment();
        }
        else if (option == 'C' || option == 'c') {
            editAppointment();
        }
        else if (option == 'D' || option == 'd') {
            deleteAppointment();
        }
        else if (option == 'E' || option == 'e') {
            // to be determined
        }
        else if (option == 'F' || option == 'f') {
            System.out.print("\f");
            System.out.println("+-------------------------------------------------------+");
            System.out.println(" System terminated. See you again!");
            System.out.println("+-------------------------------------------------------+");
            return 0;
        }
        else {
            System.out.print("\f");
            System.out.println("+-------------------------------------------------------+");
            System.out.println(" Invalid Key!");
            System.out.println("+-------------------------------------------------------+");
            System.out.print(" Press [Enter] to continue");
            String enter = inText.nextLine();
            return 1;
        }
        return 1;
    }
    
    public static void viewAppointment() {
        int dataStart = 0;
        int page = 1;
        while (true) {
            int counter = 0;
            System.out.print("\f");
            System.out.println("+-------------------------------------------------------+");
            System.out.println(" Appointment List");
            System.out.println("+-------------------------------------------------------+");
            for (int i=dataStart; i<100; i++) {
                if (counter != 10) {
                    if (apptList[i] == null) {
                        break;
                    }
                    System.out.println(" "+(i+1)+" ] "+apptList[i].toString());
                    System.out.println("+-------------------------------------------------------+");
                    counter++;
                }
                else {
                    break;
                }
            }
            System.out.println(" [ Page : "+page+" ]");
            char option = 'H';
            if (page == 1) {
                System.out.print(" Insert [V] Next Page, [H] Home : ");
                option = inChar.next().charAt(0);
            }
            else if (page > 1) {
                System.out.print(" Insert [C] Previous Page, [V] Next Page, [H] Home : ");
                option = inChar.next().charAt(0);
            }
            if (option == 'C' || option =='c') {
                dataStart -= 10;
                page -= 1;
            }
            else if (option == 'V' || option == 'v') {
                dataStart += 10;
                page += 1;
            }
            else if (option == 'H' || option == 'h') {
                break;
            }
        }
    }
    
    public static void addAppointment() {
        System.out.print("\f");
        System.out.println("+-------------------------------------------------------+");
        System.out.println(" Add New Appointment");
        System.out.println("+-------------------------------------------------------+");
        System.out.print(" Appointment ID : ");
        String apptID = inText.nextLine();
        while (true) {
            System.out.print(" Date (DD/MM/YYYY) : ");
            String date = inText.nextLine();
            System.out.print(" Time (24-hours format) : ");
            String time = inText.nextLine();
            boolean isExist = false;
            for (int i=0;i<100;i++) {
                Appointment current = (Appointment) apptList[i];
                if (apptList[i] != null) {
                    if (current.getDate().equals(date) || current.getTime().equals(time)) {
                        isExist = true;
                    }
                }
                if (apptList[i] == null) {
                    if (isExist == false) {
                        apptList[i] = new Appointment(apptID,date,time);
                        System.out.print("\f");
                        System.out.println("+-------------------------------------------------------+");
                        System.out.println(" Data has been added!");
                        System.out.println("+-------------------------------------------------------+");
                        System.out.print(" Press [Enter] to continue");
                        String enter = inText.nextLine();
                        break;
                    }
                    else {
                        System.out.println("+-------------------------------------------------------+");
                        System.out.println(" Date or Time clashed with existing data");
                        System.out.println("+-------------------------------------------------------+");
                        System.out.print(" Press [Enter] to continue");
                        String enter = inText.nextLine();
                        System.out.print("\f");
                        System.out.println("+-------------------------------------------------------+");
                        System.out.println(" Add New Appointment");
                        System.out.println("+-------------------------------------------------------+");
                        System.out.println(" Appointment ID : " + apptID);
                        break; // testing, need to change later
                    }
                }
            }
            if (isExist == false) {
                break;
            }
        }
    }
    
    public static void editAppointment() {
        int dataStart = 0;
        int page = 1;
        boolean isEditing = true;
        while (true) {
            int counter = 0;
            System.out.print("\f");
            System.out.println("+-------------------------------------------------------+");
            System.out.println(" Appointment List");
            System.out.println("+-------------------------------------------------------+");
            for (int i=dataStart; i<100; i++) {
                if (counter != 10) {
                    if (apptList[i] == null) {
                        break;
                    }
                    System.out.println(" "+(i+1)+" ] "+apptList[i].toString());
                    System.out.println("+-------------------------------------------------------+");
                    counter++;
                }
                else {
                    break;
                }
            }
            System.out.println(" [ Page : "+page+" ]");
            String option = "H";
            if (page == 1) {
                System.out.print(" Insert [V] Next Page, [H] Home : ");
                option = inText.nextLine();
            }
            else if (page > 1) {
                System.out.print(" Insert [C] Previous Page, [V] Next Page, [H] Home : ");
                option = inText.nextLine();
            }
            if (option.equalsIgnoreCase("C")) {
                dataStart -= 10;
                page -= 1;
            }
            else if (option.equalsIgnoreCase("V")) {
                dataStart += 10;
                page += 1;
            }
            else if (option.equalsIgnoreCase("H")) {
                isEditing = false;
                break;
            }
            else {
                try {
                    int choice = Integer.parseInt(option);
                    System.out.print("\f");
                    System.out.println("+-------------------------------------------------------+");
                    System.out.println(" Edit Appointment");
                    System.out.println("+-------------------------------------------------------+");
                    System.out.println(" "+(choice)+" ] "+apptList[choice-1].toString());
                    System.out.println("+-------------------------------------------------------+");
                    System.out.println(" 1] Edit Date");
                    System.out.println(" 2] Edit Time");
                    System.out.println(" 3] Back");
                    System.out.println("+-------------------------------------------------------+");
                    System.out.print(" Option : ");
                    int editOpt = inNum.nextInt();
                    boolean isEdited = false;
                    if (editOpt == 1) {
                        System.out.println(" Old date : "+apptList[choice-1].getDate());
                        System.out.print(" Enter new date (DD/MM/YYYY) : ");
                        String newDate = inText.nextLine();
                        apptList[choice-1].setDate(newDate);
                        isEdited = true;
                    }
                    else if (editOpt == 2) {
                        System.out.println(" Old time : "+apptList[choice-1].getDate());
                        System.out.print(" Enter new time (24-hours format) : ");
                        String newTime = inText.nextLine();
                        apptList[choice-1].setTime(newTime);
                        isEdited = true;
                    }
                    else if (editOpt == 3) {
                        // do nothing
                    }
                    if (isEdited) {
                        System.out.print("\f");
                        System.out.println("+-------------------------------------------------------+");
                        System.out.println(" Data has been edited!");
                        System.out.println("+-------------------------------------------------------+");
                        System.out.print(" Press [Enter] to continue");
                        String enter = inText.nextLine();
                    }
                }
                catch (NumberFormatException e) {
                    System.out.print("\f");
                    System.out.println("+-------------------------------------------------------+");
                    System.out.println(" Invalid Key!");
                    System.out.println("+-------------------------------------------------------+");
                }
            }
        }
    }
    
    public static void deleteAppointment() {
        int dataStart = 0;
        int page = 1;
        boolean isDeleting = true;
        while (true) {
            int counter = 0;
            System.out.print("\f");
            System.out.println("+-------------------------------------------------------+");
            System.out.println(" Appointment List");
            System.out.println("+-------------------------------------------------------+");
            for (int i=dataStart; i<100; i++) {
                if (counter != 10) {
                    if (apptList[i] == null) {
                        break;
                    }
                    System.out.println(" "+(i+1)+" ] "+apptList[i].toString());
                    System.out.println("+-------------------------------------------------------+");
                    counter++;
                }
                else {
                    break;
                }
            }
            String option = "H";
            if (page == 1) {
                System.out.println(" [ Page : "+page+" ] [V] Next Page, [H] Home");
                System.out.print(" Choose data to be deleted (eg. 1) : ");
                option = inText.nextLine();
            }
            else if (page > 1) {
                System.out.println(" [ Page : "+page+" ] [C] Previous Page, [V] Next Page, [H] Home");
                System.out.print(" Choose data to be deleted (eg. 1) : ");
                option = inText.nextLine();
            }
            if (option.equalsIgnoreCase("C")) {
                dataStart -= 10;
                page -= 1;
            }
            else if (option.equalsIgnoreCase("V")) {
                dataStart += 10;
                page += 1;
            }
            else if (option.equalsIgnoreCase("H")) {
                isDeleting = false;
                break;
            }
            else {
                try {
                    int choice = Integer.parseInt(option);
                    System.out.print("\f");
                    System.out.println("+-------------------------------------------------------+");
                    System.out.println(" Edit Appointment");
                    System.out.println("+-------------------------------------------------------+");
                    System.out.println(" "+(choice)+" ] "+apptList[choice-1].toString());
                    System.out.println("+-------------------------------------------------------+");
                    System.out.print(" Are you sure to delete this? (Y/N) : ");
                    char deleteOpt = inChar.next().charAt(0);
                    boolean isDeleted = false;
                    if (deleteOpt == 'Y' || deleteOpt == 'y') {
                        int count = choice-1;
                        while (apptList[count] != null) {
                            apptList[count] = apptList[count+1];
                            if(apptList[count+1] == null) {
                                apptList[count] = null;
                            }
                            count++;
                        }
                        System.out.print("\f");
                        System.out.println("+-------------------------------------------------------+");
                        System.out.println(" Data has been removed!");
                        System.out.println("+-------------------------------------------------------+");
                        System.out.print(" Press [Enter] to continue");
                        String enter = inText.nextLine();
                    }
                    else {
                        // do nothing
                    }
                }
                catch (NumberFormatException e) {
                    System.out.print("\f");
                    System.out.println("+-------------------------------------------------------+");
                    System.out.println(" Invalid Key!");
                    System.out.println("+-------------------------------------------------------+");
                }
            }
        }
    }
}
