package pl.kompikownia.dziennik.dziennik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.kompikownia.dziennik.dziennik.model.Subject;
import pl.kompikownia.dziennik.dziennik.model.enums.SubjectLevel;
import pl.kompikownia.dziennik.dziennik.model.enums.SubjectType;
import pl.kompikownia.dziennik.dziennik.service.SubjectService;

import java.util.Set;

@Controller
public class SubjectController {
    private String SUBJECT_LIST = "subjects_list";
    private String SUBJECT_ADD = "subjects_add";
    private SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {this.subjectService = subjectService;}

    @RequestMapping(value="/subjects")
    public String getSubjects(Model model) {
        Set<Subject> allSubjects = subjectService.getAllSubjects();
        model.addAttribute("subjects",allSubjects);
        return SUBJECT_LIST;
    }
    @RequestMapping(value="/subjects/add")
    public String addSubject(Model model) {return SUBJECT_ADD;}

    @RequestMapping(value="/subjects/add", params="add")
    public String addSubjectSubmitted(@RequestParam("name") String subjectName, @RequestParam("type") SubjectType subjectType, @RequestParam("level")SubjectLevel subjectLevel,Model model) {
        subjectService.addSubject(subjectName,subjectLevel,subjectType);
        return "redirect:/subjects";
    }
}
