package student.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import student.demo.entity.Student;

import java.util.List;
import java.util.Optional;

@Repository
public interface RStudent extends JpaRepository<Student,Integer> {

    List<Student> findByName(String studentName);
    List<Student> findByFaculty(Integer facultyId);
}
