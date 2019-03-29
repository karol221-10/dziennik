package pl.kompikownia.dziennik.dziennik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.kompikownia.dziennik.dziennik.model.SchoolClass;
import pl.kompikownia.dziennik.dziennik.repository.ClassRepository;
import pl.kompikownia.dziennik.dziennik.repository.StudentRepository;

import java.util.List;

@Controller
public class ProfileListController {
    private String PROFILE_LIST = "uczen_lista";
    private ClassRepository classRepository;

    @Autowired
    public ProfileListController(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }
    @GetMapping("/")
    public String getStudentList(Model model) {
        List<SchoolClass> allClasses = classRepository.getAllClasses();
        model.addAttribute("schoolclasses",allClasses);
        return PROFILE_LIST;
    }
}
