import java.util.*;
class Section{
  private String instrument;
  private ArrayList<Student> students = new ArrayList<Student>();
  public Section(String instrument){
    this.instrument=instrument;

  }
  public void addStudent(Student s){
    students.add(s);
  }
  public String getInstrument(){
    return instrument;
  }
  public ArrayList<Student> getStudents(){
    return students;
  }
  public String toString(){
    String has = " has " + students.size() + " players";
    if(instrument.equals("Violin1")) return "Violin 1"+has;
    if(instrument.equals("Violin2")) return "Violin 2"+has;
    return instrument + has;
  }
}