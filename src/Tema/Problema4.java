package Tema;
/*Construiți un exemplu de metodă care să returneze un Optional, apoi să extrageți valoarea sa
în Main in functie dacă este prezent/absent. Exemplul va fi ales de voi, singura cerință ar fi să
folosiți o altă clasă pe baza căreia să faceți operații (Persoana, Masina, etc).
 */

import java.util.List;
import java.util.Optional;

class Student {
    private String numePrenume;
    private String facultate;

    public Student(String numePrenume, String facultate) {
        this.numePrenume = numePrenume;
        this.facultate = facultate;
    }

    public String getNumePrenume() {
        return numePrenume;
    }

    @Override
    public String toString() {
        return numePrenume + " student/a la facultatea: " + facultate;
    }
}

public class Problema4 {
    public static Optional<Student> gasesteStudent(List<Student> studenti, String numeCautat) {
        return studenti.stream().filter(s -> s.getNumePrenume().equals(numeCautat)).findFirst();
    }

    public static void main(String[] args) {
        Student student1 = new Student("Tomesc Eliza", "Constructii");
        Student student2 = new Student("Rosca Karina", "MPT");
        Student student3 = new Student("Breda Valentin", "ET");
        Student student4 = new Student("Mihaila Ioana", "AC");
        Student student5 = new Student("Onea Mihai", "Drept");
        List<Student> studenti = List.of(student1, student2, student3, student4, student5);

        String numeCautat = "Mihaila Ioana";
        Optional<Student> optionalStudent = gasesteStudent(studenti, numeCautat);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            System.out.println("Student gasit: " + student);
        } else {
            System.out.println("Persoana cu numele: " + numeCautat + " nu e student");
        }
    }
}
