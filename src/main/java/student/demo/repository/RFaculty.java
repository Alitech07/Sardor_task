package student.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import student.demo.entity.Faculty;

import java.util.Optional;

@Repository
public interface RFaculty extends JpaRepository<Faculty,Integer> {
}
