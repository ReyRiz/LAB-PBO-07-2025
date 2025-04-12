import java.util.Scanner;
public class TP2_no1_H071241029 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Person person = new Person();

        System.out.print("Masukkan nama: ");
        person.setName(input.nextLine());

        System.out.print("Masukkan umur: ");
        person.setAge(input.nextInt());

        System.out.print("Apakah laki-laki? (true/false): ");
        person.setGender(input.nextBoolean());

        System.out.println("\n--- DATA DIRI ---");
        System.out.println("Nama   : " + person.getName());
        System.out.println("Umur   : " + person.getAge());
        System.out.println("Gender : " + person.getGender());
        input.close();
    }
}

class Person {
    private String name;
    private int age;
    private boolean isMale;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }
    public void setGender(boolean isMale) {
        this.isMale = isMale;
    }
    public String getGender() {
        return isMale ? "Male" : "Female";
    }
}