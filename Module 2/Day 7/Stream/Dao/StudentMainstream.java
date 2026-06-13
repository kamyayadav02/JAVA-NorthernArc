package LoanDao;

import entity.Loan;
import entity.Student;

import java.util.Comparator;
import java.util.List;

public class StudentMainstream {
    public static void main(String[] args) {
        StudentDao dao = new StudentDaoImpl();
        dao.save(new Student("Rahul",98,86,78,95,92));
        dao.save(new Student("Raghav",82,96,95,89,86));
        dao.save(new Student("Neha",99,100,82,90,94));
        dao.save(new Student("Rachin",87,84,91,100,81));
        dao.save(new Student("Sourav",72,85,94,99,89));


        //Max marks per subject

        System.out.println("----------------------------------");
        int maxPhy = ((List<Student>) dao.findAll())
                .stream()
                .mapToInt(Student::getPhyMarks)
                .max()
                .orElse(0);

        System.out.println(maxPhy);

        int maxChem = ((List<Student>) dao.findAll())
                .stream()
                .mapToInt(Student::getChemMarks)
                .max()
                .orElse(0);

        System.out.println(maxChem);

        int maxMaths = ((List<Student>) dao.findAll())
                .stream()
                .mapToInt(Student::getMathMarks)
                .max()
                .orElse(0);

        System.out.println(maxMaths);

        int maxHist = ((List<Student>) dao.findAll())
                .stream()
                .mapToInt(Student::getHistMarks)
                .max()
                .orElse(0);

        System.out.println(maxHist);

        int maxGeo = ((List<Student>) dao.findAll())
                .stream()
                .mapToInt(Student::getGeoMarks)
                .max()
                .orElse(0);

        System.out.println(maxGeo);

        System.out.println("-------------------------------------");

        System.out.println(((List<Student>) dao.findAll())
                .stream()
                .max(Comparator.comparingInt(Student::getPhyMarks)));

        System.out.println(((List<Student>) dao.findAll())
                .stream()
                .max(Comparator.comparingInt(Student::getChemMarks)));

        System.out.println(((List<Student>) dao.findAll())
                .stream()
                .max(Comparator.comparingInt(Student::getMathMarks)));

        System.out.println(((List<Student>) dao.findAll())
                .stream()
                .max(Comparator.comparingInt(Student::getHistMarks)));

        System.out.println(((List<Student>) dao.findAll())
                .stream()
                .max(Comparator.comparingInt(Student::getGeoMarks)));


        // To find average per subject

        System.out.println("-------------------------------");
        System.out.println(
                ((List<Student>) dao.findAll())
                        .stream()
                        .mapToDouble(Student::getPhyMarks)
                        .average()
        );

        System.out.println(
                ((List<Student>) dao.findAll())
                        .stream()
                        .mapToDouble(Student::getChemMarks)
                        .average()
        );

        System.out.println(
                ((List<Student>) dao.findAll())
                        .stream()
                        .mapToDouble(Student::getMathMarks)
                        .average()
        );

        System.out.println(
                ((List<Student>) dao.findAll())
                        .stream()
                        .mapToDouble(Student::getHistMarks)
                        .average()
        );

        System.out.println(
                ((List<Student>) dao.findAll())
                        .stream()
                        .mapToDouble(Student::getGeoMarks)
                        .average()
        );


        //above average in physics

        List<Student> students = (List<Student>) dao.findAll();


        double avgPhy = students.stream()
                .mapToInt(Student::getPhyMarks)
                .average()
                .orElse(0.0);

        long count = students.stream()
                .filter(s -> s.getPhyMarks() > avgPhy)
                .count();


        System.out.println("Average Physics Marks: " + avgPhy);
        System.out.println("Students above average in Physics: " + count);



        //total toppers

        System.out.println("-------------------------------------");
        List<Student> student = (List<Student>) dao.findAll();


        students.stream()
                .max(Comparator.comparingInt(Student::getPhyMarks))
                .ifPresent(s -> System.out.println("Physics: " + s.getName() + " - " + s.getPhyMarks()));

        students.stream()
                .max(Comparator.comparingInt(Student::getChemMarks))
                .ifPresent(s -> System.out.println("Chemistry: " + s.getName() + " - " + s.getChemMarks()));

        students.stream()
                .max(Comparator.comparingInt(Student::getMathMarks))
                .ifPresent(s -> System.out.println("Math: " + s.getName() + " - " + s.getMathMarks()));


        students.stream()
                .max(Comparator.comparingInt(Student::getHistMarks))
                .ifPresent(s -> System.out.println("History: " + s.getName() + " - " + s.getHistMarks()));


        students.stream()
                .max(Comparator.comparingInt(Student::getGeoMarks))
                .ifPresent(s -> System.out.println("Geography: " + s.getName() + " - " + s.getGeoMarks()));


    }
}
