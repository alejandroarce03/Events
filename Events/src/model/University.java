package model;
import java.util.*;
import java.time.*;
public class University{
    //atributtes
    private Auditorium[] auditoriums;
    private ArrayList<Event> events;
    //methods
    public University(){
        events = new ArrayList<Event>();
    }
    
/**
* This method creates the auditoriums that the user wants
* pre: the name of the author is not null, name! = null
* pre: the location of the author is not null, located! = null
* pre: rows and columns are not null and greater than zero, rows! = null, rows> 0, columns! = null, columns> 0, columns
* pre: the author number is not null, numAuditors! = null, numAuditors
* post: the method creates the auditoriums that the user needs and makes an array of authors, also has an arrangement with the alphabet for the rows of the chairs
* @param name the name of the auditorium
* @param located the place where the auditorium is located
* @param rows the number of rows
* @param columns the number of columns
* @param numAuditors the number of auditoriums you want to create
* @return the array of auditoriums created
*/
    public Auditorium[] createAuditorium(String name,String located,int rows,int columns,int numAuditors){
        Chair[][] chairs=null;
        String[] alphabet = new String[26];
        alphabet[0] = "A";
        alphabet[1] = "B";
        alphabet[2] = "C";
        alphabet[3] = "D";
        alphabet[4] = "E";
        alphabet[5] = "F";
        alphabet[6] = "G";
        alphabet[7] = "H";
        alphabet[8] = "I";
        alphabet[9] = "J";
        alphabet[10] = "K";
        alphabet[11] = "L";
        alphabet[12] = "M";
        alphabet[13] = "N";
        alphabet[14] = "O";
        alphabet[15] = "P";
        alphabet[16] = "Q";
        alphabet[17] = "R";
        alphabet[18] = "S";
        alphabet[19] = "T";
        alphabet[20] = "U";
        alphabet[21] = "V";
        alphabet[22] = "W";
        alphabet[23] = "X";
        alphabet[24] = "Y";
        alphabet[25] = "Z";
        String[] alphabetChairs = Arrays.copyOfRange(alphabet, 0,rows);
        auditoriums = new Auditorium[numAuditors];
        Auditorium auditorium = null;
        String status ="Available";
        for(int i=0;i<auditoriums.length;i++){  
            if(auditoriums[i]==null){
                chairs = new Chair[rows][columns];
                 auditorium = new Auditorium(name,located,status,chairs,alphabetChairs);
                auditoriums[i]=auditorium;
            }
        }
        return auditoriums;
    }

    /**
    * This method creates the chairs of an auditorium
    * pre: the name is not null, name! = null
    * pre: the arrangement of chairs that goes by row is not null and is not empty. arrayChairs! = null, arrayChairs.lengh> 0
    * post: the method creates an array of chairs that go in the auditorium
    * @param name
    * @param arrayChairs
    */
    public void createChairs(String name,int[] arrayChairs){
        Chair[][] chairs=null;
        for(int i=0;i<auditoriums.length;i++){
            if(auditoriums[i]!=null){
                if(auditoriums[i].getName().equalsIgnoreCase(name)){
                    chairs=auditoriums[i].getChairs();
                    for(int w=0;w<arrayChairs.length;w++){
                        for(int h=0;h<arrayChairs[w];h++){
                            String status  = "OPERATIONAL";
                            String description ="";
                            if(chairs[w][h]==null){
                            chairs[w][h]= new Chair(status,description);}
                        }
                    }
                }
            }
        }
    }
    /**
    * The method creates an event that will be held at the university
    * pre: the name is not null, name! = null
    * pre: the date is not null and must be in the format YYYY-MM-DDTHH: 00, date! = null
    * pre: the date on which the event ends must be the same day that begins not null and must be in the format YYYY-MM-DDTHH: 00, timeEnd! = null
    * pre: the name of the responsible teacher is not null, nameTeacher! = null
    * pre: the name of the faculty is not null, faculty! = null
    * pre: the number of people who will attend is not null, people! = null
    * pre: the number of audits that will be used is not null and is greater than zero, auditors! = null, auditors> 0
    * post: the method creates an event and makes a reservation in the necessary auditoriums
    * @param name
    * @param date
    * @param timeEnd
    * @param nameTeacher
    * @param faculty
    * @param people
    * @param auditors
    * @return the method returns the created event
    */
    public Event addEvent(String name, String date, String timeEnd,String nameTeacher, String faculty,int people,ArrayList<Auditorium> auditors){
        LocalDateTime dateStartEvent = LocalDateTime.parse(date);
        LocalDateTime timeEndEvent = LocalDateTime.parse(timeEnd);
        Event event=null;
        boolean finish = false;
        ArrayList<Auditorium> array = new ArrayList<Auditorium>();
        for(int s=0; s<auditors.size();s++){
            if(events.isEmpty()){
                event = new Event(name, date,timeEnd, nameTeacher, faculty, people,auditors,dateStartEvent,timeEndEvent);
                events.add(event);
            }else{
                for(int i=0; i<events.size() && !finish ;i++){
                    array = events.get(i).getAuditors();
                    for(int w=0;w<array.size();w++){
                        if(events.get(i).getAuditors().get(w).getName().equalsIgnoreCase(auditors.get(s).getName())){
                            if(events.get(i).getDate().isAfter(timeEndEvent) || (events.get(i).getDate().isBefore(dateStartEvent) && events.get(i).getTimeEnd().isBefore(timeEndEvent))){
                                event = new Event(name, date,timeEnd, nameTeacher, faculty, people,auditors,dateStartEvent,timeEndEvent);
                                events.add(event);
                                finish = true;
                            }
                                else{
                                    event = new Event(name, date,timeEnd, nameTeacher, faculty, people,auditors,dateStartEvent,timeEndEvent);
                                    events.add(event);
                                    finish=true;
                                }
                    
                        }       
                    }

             }
            }
         }
            return event;
     }
     /**
     * The method checks that the auditorium you want to reserve exists
     * pre: the name of the auditorium you want to reserve is not null, nameAuditorium! = null
     * post: the method creates an arraylist of the auditoriums necessary for the event
     * @param nameAuditorium
     * @return the method returns an auditorium arraylist
     */
    public ArrayList<Auditorium> arrayAuditoriumsForEvent(String nameAuditorium){
        ArrayList<Auditorium> auditors = new ArrayList<Auditorium>();
        Auditorium auditor = null;
        for(int i = 0; i < auditoriums.length; i++){
            if(auditoriums[i]!=null){
                if(auditoriums[i].getName().equalsIgnoreCase(nameAuditorium)){
                    auditor = auditoriums[i];
                    auditors.add(auditor);
                    System.out.println("arrrr");
                }
            }
        }
        return auditors;
    }
 
    /**
    * The method reports a defective chair
    * pre: the row of the chair you want to report is not null, row! = null
    * pre: the column of the sila you want to report is not null, column! = null
    * pre: the description of the defect is not null, describption! = null
    * pre: the name of the auditorium where the defective chair is located is not null, name! = null
    * post: the method reports a defective chair of a given auditorium
    * @param row
    * @param column
    * @param description
    * @param name
    * @return the method returns if the chair exists and was reported or on the contrary does not exist
    */
    public String reportFaulty(String row,int column,String description,String name){
        String status = "faulty";
        String msg="";
        column+=1;
        for(int i=0;i<auditoriums.length;i++){
            boolean centi= false;
            if(auditoriums[i]!=null){
                if(auditoriums[i].getName().equalsIgnoreCase(name)){
                    Chair[][] chairs=auditoriums[i].getChairs();
                     for(int y=0;y<auditoriums[i].getAlphabet().length && !centi;y++){
                         if(row.equalsIgnoreCase(auditoriums[i].getAlphabet()[i])){
                             if(column<=chairs[i].length){
                                chairs[i][column].setStatus(status);
                                chairs[i][column].setDescription(description);
                                centi = true;
                                msg = "The status of chair was change to faulty";
                                   
                                }
                            }    
                        }
                    }
               }    
        }
        return msg;
    }
  
    /**
    * Calcium method the percentage of defective chairs
    * pre: the name of the auditorium to be calculated, name! = null
    * post: the method calculates the percentage of defective chairs per auditorium
    * @param name
    * @return the method returns the percentage of defective chairs
    */
    public double percentageOfFaulty(String name){
        double percentage =0;
        double numOfChairs=0;
        double numOfChairsFaulty=0;
        for(int q=0;q<auditoriums.length;q++){
           if(auditoriums[q]!=null){
                if(auditoriums[q].getName().equalsIgnoreCase(name)){
                    for(int i = 0; i < auditoriums[q].getChairs().length; i++){
                        for(int j=0; j < auditoriums[q].getChairs()[i].length; j++){
                            if(auditoriums[q].getChairs()[i][j]!=null){
                                if(auditoriums[q].getChairs()[i][j].getStatus().equalsIgnoreCase("faulty")){
                                    numOfChairsFaulty++;
                                }else{
                                    numOfChairs++;
                                }
                            }
                        }
                    }
                }
           }
        }
        double totalChairs = numOfChairs+numOfChairsFaulty;
        percentage= (numOfChairsFaulty/totalChairs)*100;
        return percentage; 
    }
}