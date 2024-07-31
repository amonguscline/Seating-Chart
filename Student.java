import java.util.*;
class Student{
  private ArrayList<String> instruments = new ArrayList<String>();
  private String fname;
  private String lname;
  public Student(String fname, String lname, ArrayList<String> ins){
    this.fname = fname;
    this.lname = lname;
    for(int i=0;i<ins.size();i++){
      instruments.add(ins.get(i));
    }
    
  }
  public boolean equals(Student s){
    return this.fname.equals(s.getFName())&&this.lname.equals(s.getLName());
  }
  public String getFName(){
    return fname;
  }
  public String getLName(){
    return lname;
  }
  public String toString(){
    return fname+" " + lname + " " + instruments;
  }
  public void addInstrument(ArrayList<String> ins){
    
    for(int i=0;i<ins.size();++i){
      boolean iNstruments = false;
      for(int j=0;j<instruments.size();j++){
        if(ins.get(i).equals(instruments.get(j))) iNstruments=true;
      }
      if(!iNstruments) instruments.add(ins.get(i));
    }
    
  }
  public ArrayList<String> getInstruments(){
    return instruments;
  }
}