import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;
class Main {
  static ArrayList<Student> students = new ArrayList<Student>();
  public static void main(String[] args) {
    File file = new File("Students.txt");
    try{
      Scanner sc = new Scanner(file);
      boolean hasNextLine = true;
      do{
        try{
          List<String> temp = Arrays.asList(sc.nextLine().split(","));
          boolean unique = true;
          ArrayList<String> tempins = new ArrayList<String>();
          for(var i=2;i<temp.size();i++){
            tempins.add(temp.get(i));
          }
          
          int studentIndex=-1;
          Student tempStudent = new Student(temp.get(0),temp.get(1),tempins);
          
          for(int i=0;i<students.size();++i){
            if(students.get(i).equals(tempStudent)){
              unique=false;
              studentIndex=i;
            }
          }
          if(unique){
            students.add(tempStudent);
          }
          else{
            students.get(studentIndex).addInstrument(tempStudent.getInstruments());
              unique=true;}
        }
        catch(Exception e){
          hasNextLine=false;
        }
      }
      while(hasNextLine);
    }
    catch(Exception e){System.out.println("bruh");}
    System.out.println(sortSections());
  }
  public static ArrayList<Section> sortSections(){
    ArrayList<Section> sections=new ArrayList<Section>();
    for(Student student:students){
      boolean isSection = false;
      for(String instrument:student.getInstruments()){
        for(Section section:sections){
          if(instrument.equals(section.getInstrument())) {
            section.addStudent(student);    
            isSection=true;
          }
        }
        if(!isSection){
          sections.add(new Section(instrument));
          sections.get(sections.size()-1).addStudent(student);
        }
        isSection=false;
      }
      
    }
    return sections;
  }
}