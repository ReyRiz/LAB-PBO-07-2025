// class for no 1
public class Person{
    String name;
    int age;
    boolean isMale;

    public Person() {
        this.name = "";
        this.age = 0;
        this.isMale = true;
    }
    public Person(String name, int age, boolean isMale){
        this.name = name;
        this.age = age;
        this.isMale = isMale;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    } 
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }
    public void setGender(boolean isMale){
        this.isMale = isMale;
    }
    public String getGender(){
        if (isMale) {
            return "Laki-laki";
        } else {
            return "Perempuan";
        }
        
    }
} 
