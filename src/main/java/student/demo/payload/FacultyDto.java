package student.demo.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import student.demo.entity.Student;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacultyDto<T> {
    private String facultyName;
    private T data;
}
