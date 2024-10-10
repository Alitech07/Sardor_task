package student.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import student.demo.entity.Faculty;
import student.demo.entity.Student;
import student.demo.payload.FacultyDto;
import student.demo.repository.RFaculty;
import student.demo.repository.RStudent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/faculty")
public class CFaculty {

    private final RFaculty rFaculty;
    private final RStudent rStudent;

    /**
     * Yangi Fakultet qo'shish
     * @param faculty
     * @return
     */
    @PostMapping("/add")
    public String addFaculty(@RequestBody Faculty faculty){
        rFaculty.save(faculty);
        return "Add Faculty";
    }

    /**
     * Facultet idsi orqali fakultet malumotlari va studentlari haqida malumot olish.
     *
     * @param id
     * @return
     */

    @GetMapping("/{id}")
    public ResponseEntity<?> getFacultyInfo(@PathVariable Integer id) {

        Optional<Faculty> faculty = rFaculty.findById(id);
        List<Student> students = rStudent.findByFaculty(id);

        String facName = faculty.get().getName();
        String res="Fakultet nomi: "+facName+"\n";
        for (Student student:students){
            res = "Id: "+student.getId()+"\n"
                    +"Ismi: "+student.getName()+"\n"
                    +"Familya: "+student.getSurname()+"\n"
                    +"Kurs: "+student.getCourse()+"\n\n";
        }
        return ResponseEntity.ok(res);
    }
}
