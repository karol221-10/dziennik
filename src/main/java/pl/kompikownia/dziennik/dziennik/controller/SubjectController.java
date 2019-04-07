package pl.kompikownia.dziennik.dziennik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kompikownia.dziennik.dziennik.model.Subject;
import pl.kompikownia.dziennik.dziennik.service.SubjectService;

import java.util.Set;

@Controller
public class SubjectController {
    private String SUBJECT_LIST = "subjects_list";
    private SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {this.subjectService = subjectService;}

    @RequestMapping(value="/subjects")
    public String getSubjects(Model model) {
        Set<Subject> allSubjects = subjectService.getAllSubjects();
        model.addAttribute("subjects",allSubjects);
        return SUBJECT_LIST;
    }
}
