package pl.kompikownia.dziennik.dziennik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.kompikownia.dziennik.dziennik.repository.StudentRepository;

@Controller
public class ProfileListController {
    private String PROFILE_LIST = "uczen_lista";
    private StudentRepository studentRepository;

    @Autowired
    public ProfileListController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @GetMapping("/")
    public String getStudentList(Model model) {
        return PROFILE_LIST;
    }
}
