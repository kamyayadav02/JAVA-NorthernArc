package LoanDao;

import entity.Student;

public interface StudentDao {

    public void save(Student student);

    public Student findByName(String name);

    public void deleteByName(String name);

    public void update(Student student);

    public void deleteAll();

    public Iterable<Student> findAll();

    public Iterable<Student> findByPhyMarks(int phyMarks);

    public Iterable<Student> findByMathMarks(int mathMarks);
}