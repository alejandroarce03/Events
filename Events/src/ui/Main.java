package ui;
import model.*;
import java.util.Scanner;
import java.util.*;
public class Main {
    // atributtes
    Scanner in;
    Scanner num;
    Scanner un;
    private University university;

    // methods
    public Main() {
        university = new University();
        in = new Scanner(System.in);
        num = new Scanner(System.in);
        un = new Scanner(System.in);
    }

    public static void main(String[] args) {
        Main obj = new Main();
        obj.exe();
    }

    public void exe() {
        boolean cont = false;
        for (int i = 0; !cont; i++) {
            System.out.println("Menu");
            System.out.println("1. Create Auditoriums");
            System.out.println("2. Report faculty chair");
            System.out.println("3. Percentage of faulty chairs");
            System.out.println("4. Add event");
            System.out.println("5. Exit");
            int option = num.nextInt();
            switch (option) {
            case 1:
                createAuditorium();
                break;
            case 2:
                System.out.println(reportChair());
                break;
            case 3:
                percentage();
                break;
            case 4:
                addEventt();
                break;
            case 5: cont=true; 
                break;
            default:

            }
        }
    }

    public void createAuditorium() {
        System.out.print("How many auditoriums do you want create: ");
        int numAuditors = num.nextInt();
        for (int i = 0; i < numAuditors; i++) {
            boolean cont = false;
            System.out.print("Enter the name of auditorium: ");
            String nameAuditorium = in.nextLine();
            System.out.print("Enter location of auditorium: ");
            String location = in.nextLine();
            System.out.print("How many rows: ");
            int rows = num.nextInt();
            int[] arrayChairs = new int[rows];
            System.out.print("How many columns: ");
            int columns = num.nextInt();
            if (university.createAuditorium(nameAuditorium, location, rows, columns, numAuditors) != null) {
                System.out.println("The auditorium is created");
                for (int x = 0; x < rows && !cont; x++) {
                    int numChairs = 0;
                    System.out.print("How many chairs in the " + (x + 1) + " row: ");
                    numChairs = num.nextInt();
                    if (numChairs > columns) {
                        System.out.println("Error you can not create more than " + (columns));
                        cont = true;
                    }
                    arrayChairs[x] = numChairs;
                }
                if (!cont)
                    university.createChairs(nameAuditorium, arrayChairs);
            } else {
                System.out.println("The auditorium is not created");
            }
        }
    }

    public void addEventt(){
        ArrayList<Auditorium> arrayAuditors = new ArrayList<Auditorium>();
        Event event = null;
        System.out.print("Enter name: ");
        String name = in.nextLine();
        System.out.print("Enter date(yyyy-MM-ddTHH:00): ");
        String date = in.nextLine();
        System.out.print("Enter time that end(yyyy-MM-ddTHH:00): ");
        String timeEnd = in.nextLine();
        System.out.print("Enter name of teacher: ");
        String teacherName = in.nextLine();
        System.out.print("Enter faculty of that event: ");
        String faculty = in.nextLine();
        System.out.print("Enter people who attend to this event: ");
        int people = num.nextInt();
        System.out.print("Enter how many auditoriums do you want reserve: ");
        int reserve = num.nextInt();
        for(int i=0;i<reserve;i++){
        System.out.print("Enter auditorium that you want reserve: ");
        String nameAuditorium = in.nextLine();
         arrayAuditors=university.arrayAuditoriumsForEvent(nameAuditorium);
        }
        event=university.addEvent(name,date,timeEnd,teacherName,faculty,people,arrayAuditors);
        if(event!=null){
            System.out.println("The event was added");}
       
    }
    public String reportChair(){
        System.out.print("Enter name of auditorium: ");
        String nameAuditorium = un.nextLine();
        System.out.print("Enter the row of chair: ");
        String row = un.nextLine();
        System.out.print("Enter the column of chair: ");
        int column = num.nextInt();
        System.out.print("Enter description of faculty chair: ");
        String description = un.nextLine();
        String msg = "";
        msg = university.reportFaulty(row, column,description,nameAuditorium);
        if(msg==null){
            System.out.println("The chair is not exist");
        }
        return msg;
    }
    public void percentage(){
        System.out.print("Enter the name of auditorium: ");
        String name = un.nextLine();
        System.out.println("The percentage of faulty chairs is: "+university.percentageOfFaulty(name)+"%");
    }
}
