package pl.kompikownia.dziennik.dziennik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kompikownia.dziennik.dziennik.model.Teacher;
import pl.kompikownia.dziennik.dziennik.service.TeacherService;

import java.util.Set;

@Controller
public class TeacherController {

    private String TEACHER_LIST = "teacher_list";
    private TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {this.teacherService = teacherService;}

    @RequestMapping("/teachers")
    public String getTeachers(Model model) {
        Set<Teacher> teachers = teacherService.getAllTeachers();
        model.addAttribute("teachers",teachers);
        return TEACHER_LIST;
    }
}
