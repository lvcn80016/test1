package sample.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sample.entity.Student;
import sample.service.StudentService;

@RestController
@RequestMapping("/stu")
public class StudentController {

	@Autowired
    private StudentService studentService;

	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
	
    @RequestMapping("/list")
    public List<Student> getStus(){
		logger.info("---------------22222222222-----------------");
        return studentService.getList();
    }

}
