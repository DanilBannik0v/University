package org.example;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student.StudentBuilder("Pushkin Igor", "0001",3, 4.5F).setPhone("79125349625").setEmail("IvanovIII@mail.ru").build();
        Student student2 = new Student.StudentBuilder("Gavrilov Boris", "0001",2,4.4F).setPhone("72954693642").setEmail("XxGavrilovxX@mail.ru").build();
        Student student3 = new Student.StudentBuilder("Andreev Valery", "0002",1,4.7F).setPhone("749687386934").setEmail("Valeryhhhhh@mail.ru").build();
        Student student4 = new Student.StudentBuilder("Vinogradov Pyotr", "0002",4,4.9F).setPhone("75929957231").setEmail("VinoEnjoyer@mail.ru").build();
        Student student5 = new Student.StudentBuilder("Korobochka Irina", "0003",2,4.0F).setPhone("76947693643").setEmail("smallKorobochka@mail.ru").build();
        Student student6 = new Student.StudentBuilder("Voroncova Tatyana", "0003",3,3.9F).setPhone("70236483062").setEmail("Vorona@mail.ru").build();

        University URFU = new University.UniversityBuilder("0001","Ural Federal University", "URFU",1920, 13,1)
                .setAddress("Marks St. 15").setNumberOfStudents(11876).build();
        University USUoE = new University.UniversityBuilder("0002","Ural State University of Economics", "USUoE",1967, 12,2)
                .setAddress("Sverdlova St. 28").setNumberOfStudents(7398).build();
        University USFEU = new University.UniversityBuilder("0003","Ural State Forest Engineering University", "USFEU",1930 , 11,3)
                .setAddress("Lenin St 11").setNumberOfStudents(5428).build();

        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);
        System.out.println(student4);
        System.out.println(student5);
        System.out.println(student6);
        System.out.println("-------------------------------");
        System.out.println(URFU);
        System.out.println(USUoE);
        System.out.println(USFEU);
    }
}