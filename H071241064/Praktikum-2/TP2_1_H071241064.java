class Person {
    private String name;
    private int age;
    private boolean isMale;

    public void setName(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public void setAge(int a) {
        age = a;
    }

    public int getAge() {
        return age;
    }

    public void setGender(boolean g) {
        isMale = g;
    }

    public String getGender() {
        return isMale ? "Laki-laki" : "Perempuan";
    }

    public void displayInfo() {
        System.out.println("Nama: " + getName());
        System.out.println("Umur: " + getAge() + " tahun");
        System.out.println("Jenis Kelamin: " + getGender());
    }
}

public class TP2_1_H071241064 {
    public static void main(String[] args) {
        Person person1 = new Person();
        person1.setName("Budi");
        person1.setAge(25);
        person1.setGender(true);

        Person person2 = new Person();
        person2.setName("Siti");
        person2.setAge(22);
        person2.setGender(false);

        person1.displayInfo();
        System.out.println();
        person2.displayInfo();
    }
}

