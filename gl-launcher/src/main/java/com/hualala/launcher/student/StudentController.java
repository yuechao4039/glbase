package com.hualala.launcher.student;//package com.hualala.api.student;
//
//
//import com.hualala.interfaces.student.Student;
//import com.hualala.interfaces.student.StudentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping(value = "/stu", produces = {"application/json"})
//public class StudentController {
//    @Autowired
//    private StudentService studentService;
//
//    @RequestMapping(value = "/selectall")
//    public ResponseEntity<List<Student>> selectAll() {
//        List<Student> list = this.studentService.select();
//
//        return new ResponseEntity<List<Student>>(list, HttpStatus.OK);
//    }
//}
