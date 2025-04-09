public class No1{
    public static void main(String[] args) {
        Person person = new Person();

        person.setName("Julio");
        person.setAge(20);
        person.setGender("Male");

        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
        System.out.println("Gender: " + person.getGender()); //ttp bisa di akses karena private


    }
}

class Person{
    private String name;
    private int age;
    private boolean isMale;

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
    public void setGender(String gender){
        this.isMale = gender.equalsIgnoreCase("Male"); // bandingkan huruf kapital atau tidak dan setara
    }
    public String getGender(){
        return isMale ? "Male" : "Female";

    }
} 
    