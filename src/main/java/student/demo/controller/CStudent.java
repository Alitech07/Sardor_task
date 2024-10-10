package student.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import student.demo.entity.Student;
import student.demo.repository.RStudent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class CStudent {

    private final RStudent rStudent;

    /**
     * Barcha studentlarni olish
     *
     * @return
     */
    @GetMapping("/all")
    protected List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students = rStudent.findAll();
        return students;
    }

    /**
     * Student idsi orqali studentni olish.
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    protected ResponseEntity<?> getStudent(@PathVariable Integer id) {
        return ResponseEntity.ok(rStudent.findById(id));
    }

    /**
     * Yangi Student qo'shish
     *
     * @param student
     * @return
     */
    @PostMapping(value = "/add")
    public ResponseEntity<?> addStudent(@RequestBody Student student) {

        return ResponseEntity.ok(rStudent.save(student));
    }

    /**
     * Student id si orqali student malumotlarini o'zgartirish
     *
     * @param student
     * @param id
     * @return
     */
    @PostMapping("/update/{id}")
    protected String updateStudent(@RequestBody Student student, @PathVariable Integer id) {
        Optional<Student> optionalStudent = rStudent.findById(id);
        if (optionalStudent.isPresent()) {
            Student student1 = optionalStudent.get();
            student1.setName(student.getName());
            student1.setSurname(student.getSurname());
            student1.setBirthDate(student.getBirthDate());
            student1.setFaculty(student.getFaculty());
            student1.setCourse(student.getCourse());
            rStudent.save(student1);
        }
        return "Update Student";
    }

    /**
     * Student idsi orqali Studentni o'chirish
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    protected String deleteStudent(@PathVariable Integer id) {
        rStudent.deleteById(id);
        return "Delete Student";
    }

    @GetMapping("/search/{name}")
    protected ResponseEntity<?> getStudentName(@PathVariable String name) {
       List<Student> optionalStudents=  rStudent.findByName(name);

       if(optionalStudents.isEmpty()){
           return ResponseEntity.ok(new Object());
       }else {
           return ResponseEntity.ok(optionalStudents);
       }
    }


}
