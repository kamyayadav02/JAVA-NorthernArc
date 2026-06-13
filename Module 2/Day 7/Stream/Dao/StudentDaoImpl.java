package LoanDao;

import entity.Book;
import entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao{
    private List<Student> students = new ArrayList<>();

    @Override
    public void save(Student student) {
        students.add(student);
    }

    @Override
    public Student findByName(String name) {
        for (Student s : students) {
            if (s.getName() == name) {
                return s;
            }
        }
        return null;
    }

    @Override
    public void deleteByName(String name) {

    }

    @Override
    public void update(Student student) {
        for (Student s : students) {
            if (s.getName() == student.getName()) {
                s.setPhyMarks(student.getPhyMarks());
                s.setMathMarks(student.getMathMarks());
                return;
            }
        }

    }

    @Override
    public void deleteAll() {
        students.clear();

    }

    @Override
    public Iterable<Student> findAll() {
        return students;
    }

    @Override
    public Iterable<Student> findByPhyMarks(int phyMarks) {
        List<Student> result = new ArrayList<>();
        for (Student s : students) {
            if (s.getPhyMarks()==(phyMarks)) {
                result.add(s);
            }
        }
        return result;
    }

    @Override
    public Iterable<Student> findByMathMarks(int mathMarks) {
        List<Student> result = new ArrayList<>();
        for (Student s : students) {
            if (s.getMathMarks()==(mathMarks)) {
                result.add(s);
            }
        }
        return result;

    }
}
