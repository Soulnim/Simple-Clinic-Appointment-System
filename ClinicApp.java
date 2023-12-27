
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
            // to be determined
        }
        else if (option == 'C' || option == 'c') {
            // to be determined
        }
        else if (option == 'D' || option == 'd') {
            // to be determined
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
}
