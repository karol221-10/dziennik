package pl.kompikownia.dziennik.dziennik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.kompikownia.dziennik.dziennik.model.SchoolClass;
import pl.kompikownia.dziennik.dziennik.model.Student;
import pl.kompikownia.dziennik.dziennik.repository.ClassRepository;
import pl.kompikownia.dziennik.dziennik.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class ProfileListController {
    private String PROFILE_LIST = "uczen_lista";
    private ClassRepository classRepository;

    @Autowired
    public ProfileListController(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }
    @RequestMapping(value = "/classes", method = RequestMethod.GET)
    public String getStudentByClasses(@RequestParam("classNumber") Integer classID, Model model) {
        List<SchoolClass> allClasses = classRepository.getAllClasses();
        model.addAttribute("schoolclasses",allClasses);
        if(classID!=null) {
            SchoolClass selectedClass = classRepository.getClassByID(classID);
            Set<Student> setOfStudents = classRepository.getStudentFromClass(classID);
            List<Student> listOfStudents = new ArrayList<>(setOfStudents);
            model.addAttribute("students",listOfStudents);
            model.addAttribute("selectedClassID",classID);
        }
        return PROFILE_LIST;
    }
}
