
public class no1{
    public static void main(String[] args) {
        
        Person person = new Person("sza", 23, false);
        
        System.out.println("Nama: " + person.getName());
        System.out.println("Umur: " + person.getAge());
        System.out.println("Gender: " + person.getGender());
    }
}