package pl.kompikownia.dziennik.dziennik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.kompikownia.dziennik.dziennik.model.SchoolClass;
import pl.kompikownia.dziennik.dziennik.repository.ClassRepository;
import pl.kompikownia.dziennik.dziennik.service.ClassService;

import java.util.List;

@Controller
public class ClassesController {
    private String CLASSES_LIST = "classes_list";
    private String ADD_CLASS = "classes_add";
    private ClassService classService;

    @Autowired
    public ClassesController(ClassService classService) {this.classService = classService;}

    @RequestMapping(value="/classes")
    public String getSchoolClasses(Model model) {
        List<SchoolClass> allClasses = classService.getAllClasses();
        model.addAttribute("classes",allClasses);
        return CLASSES_LIST;
    }
    @RequestMapping(value="/classes", params="del")
    public String removeClass(@RequestParam("selected") Integer selectedID, Model model) {
        classService.deleteClassByID(selectedID);
        return getSchoolClasses(model);
    }
    @RequestMapping(value="/classes/add")
    public String addClass(Model model) {
        return ADD_CLASS;
    }
    @RequestMapping(value="/classes/add", params="add")
    public String addClassSubmitted(@RequestParam("className") String className, @RequestParam("classNumber") Integer classNumber, Model model) {
        classService.addClass(className,classNumber);
        return "redirect:/classes";
    }
    @RequestMapping(value="/classes/change")
    public String changeClass(@RequestParam("selected") Integer selected,Model model) {
        SchoolClass sch = classService.getClassByID(selected);
        model.addAttribute("schoolclass",sch);
        model.addAttribute("selected",selected);
        return ADD_CLASS;
    }
    @RequestMapping(value="/classes/change", params="change")
    public String changeClassSubmitted(@RequestParam("className") String className,@RequestParam("classNumber")Integer classNumber,@RequestParam("change") Integer ID,Model model)
    {
        classService.updateClass(ID,className,classNumber);
        return "redirect:/classes";
    }
};
