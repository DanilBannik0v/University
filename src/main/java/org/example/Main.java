package org.example;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student.StudentBuilder("Pushkin Igor", "1",3,233).setPhone("79125349625").setEmail("IvanovIII@mail.ru").build();
        Student student2 = new Student.StudentBuilder("Gavrilov Boris", "1",2,186).setPhone("72954693642").setEmail("XxGavrilovxX@mail.ru").build();
        Student student3 = new Student.StudentBuilder("Andreev Valery", "2",1,238).setPhone("749687386934").setEmail("Valeryhhhhh@mail.ru").build();
        Student student4 = new Student.StudentBuilder("Vinogradov Pyotr", "2",4,295).setPhone("75929957231").setEmail("VinoEnjoyer@mail.ru").build();
        Student student5 = new Student.StudentBuilder("Korobochka Irina", "3",2,248).setPhone("76947693643").setEmail("smallKorobochka@mail.ru").build();
        Student student6 = new Student.StudentBuilder("Voroncova Tatyana", "3",3,189).setPhone("70236483062").setEmail("Vorona@mail.ru").build();

        University URFU = new University.UniversityBuilder("1","Ural Federal University", "URFU",1920, 13,1)
                .setAddress("Marks St. 15").setNumberOfStudents(11876).build();
        University USUoE = new University.UniversityBuilder("2","Ural State University of Economics", "USUoE",1967, 12,2)
                .setAddress("Sverdlova St. 28").setNumberOfStudents(7398).build();
        University USFEU = new University.UniversityBuilder("3","Ural State Forest Engineering University", "USFEU",1930 , 11,3)
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