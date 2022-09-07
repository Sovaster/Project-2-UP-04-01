package com.example.Project2.Controllers;

import com.example.Project2.Models.Prepod;
import com.example.Project2.Models.Student;
import com.example.Project2.repo.PrepodRepository;
import com.example.Project2.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.Project2.Models.Post;
import com.example.Project2.repo.PostRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class BlockController
{
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private PrepodRepository prepodRepository;
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/")
    public String Home(Model model)
    {
        return "Home";
    }


    @GetMapping("/blog")
    public String GetBlog(Model model)
    {
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts",posts);
        return "block-main";
    }
    @GetMapping("/students")
    public String GetStudent(Model model)
    {
        Iterable<Student> students = studentRepository.findAll();
        model.addAttribute("students",students);
        return "student-main";
    }
    @GetMapping("/prepods")
    public String GetPrepod(Model model)
    {
        Iterable<Prepod> prepods = prepodRepository.findAll();
        model.addAttribute("prepods",prepods);
        return "prepod-main";
    }


    @GetMapping("/blog/add")
    public String blogAdd(Model model)
    {
        return "blog-add";
    }
    @GetMapping("/student/add")
    public String studentAdd(Model model)
    {
        return "student-add";
    }
    @GetMapping("/prepod/add")
    public String prepodAdd(Model model)
    {
        return "prepod-add";
    }


    @PostMapping("/blog/add")
    public String blogPostAdd(@RequestParam(value="title") String title,
                              @RequestParam(value ="anons") String anons,
                              @RequestParam(value = "full_text") String full_text,Model model)
    {
        Post post = new Post(title,anons,full_text);
        postRepository.save(post);
        return "redirect:/blog";
    }
    @PostMapping("/student/add")
    public String studentAdd(@RequestParam(value="Familia") String Familia,
                              @RequestParam(value ="Name") String Name,
                              @RequestParam(value = "Otch") String Otch,
                              @RequestParam(value = "Grupa") String Grupa,
                              @RequestParam(value = "Birthday") String Birthday, Model model)
    {
        Student student = new Student(Familia,Name,Otch,Grupa,Birthday);
        studentRepository.save(student);
        return "redirect:/students";
    }
    @PostMapping("/prepod/add")
    public String prepodAdd(@RequestParam(value="Familia") String Familia,
                             @RequestParam(value ="Name") String Name,
                             @RequestParam(value = "Otch") String Otch,
                             @RequestParam(value = "Predmeti") String Predmeti,
                             @RequestParam(value = "Grafic") String Grafic, Model model)
    {
        Prepod prepod = new Prepod(Familia,Name,Otch,Predmeti,Grafic);
        prepodRepository.save(prepod);
        return "redirect:/prepods";
    }


    @GetMapping("/blog/filter")
    public String blogFilter(Model model)
    {
        return "blog-filter";
    }
    @GetMapping("/student/filter")
    public String studentFilter(Model model)
    {
        return "student-filter";
    }
    @GetMapping("/prepod/filter")
    public String prepodFilter(Model model)
    {
        return "prepod-filter";
    }


    @PostMapping("/blog/filter/result")
    public String blogResult(@RequestParam String title, Model model)
    {
//        List<Post> result = postRepository.findByTitle(title);
        List<Post> result = postRepository.findByTitleContains(title);
        model.addAttribute("result", result);
        return "blog-filter";
    }
    @PostMapping("/student/filter/result")
    public String studentResult(@RequestParam String familia, Model model)
    {
//        List<Student> result = studentRepository.findByTitle(Familia);
        List<Student> result = studentRepository.findByfamiliaContains(familia);
        model.addAttribute("result", result);
        return "student-filter";
    }
    @PostMapping("/prepod/filter/result")
    public String prepodResult(@RequestParam String familia, Model model)
    {
        List<Prepod> result = prepodRepository.findByfamilia(familia);
//        List<Prepod> result = prepodRepository.findByTitleContains(Familia);
        model.addAttribute("result", result);
        return "prepod-filter";
    }


    @GetMapping("/blog/{id}")
    public String blogDetails(@PathVariable(value = "id") long id, Model model)
    {
        Optional<Post> post = postRepository.findById(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        if(!postRepository.existsById(id))
        {
            return "redirect:/blog";
        }
        return "blog-details";
    }
    @GetMapping("/blog/{id}/edit")
    public String blogEdit(@PathVariable("id")long id,
                           Model model)
    {
        if(!postRepository.existsById(id)){
            return "redirect:/blog";
        }
        Optional<Post> post = postRepository.findById(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post",res);
        return "blog-edit";
    }
    @PostMapping("/blog/{id}/edit")
    public String blogPostUpdate(@PathVariable("id")long id,
                                 @RequestParam String title,
                                 @RequestParam String anons,
                                 @RequestParam String full_text,
                                 Model model)
    {
        Post post = postRepository.findById(id).orElseThrow();
        post.setTitle(title);
        post.setAnons(anons);
        post.setFull_text(full_text);
        postRepository.save(post);
        return "redirect:/blog";
    }
    @PostMapping("/blog/{id}/remove")
    public String blogBlogDelete(@PathVariable("id") long id, Model model){
        Post post = postRepository.findById(id).orElseThrow();
        postRepository.delete(post);
        return "redirect:/blog";
    }


    @GetMapping("/prepod/{id}")
    public String prepodDetails(@PathVariable(value = "id") long id, Model model)
    {
        Optional<Prepod> prepod = prepodRepository.findById(id);
        ArrayList<Prepod> res = new ArrayList<>();
        prepod.ifPresent(res::add);
        model.addAttribute("prepod", res);
        if(!prepodRepository.existsById(id))
        {
            return "redirect:/prepods";
        }
        return "prepod-details";
    }
    @GetMapping("/prepod/{id}/edit")
    public String prepodEdit(@PathVariable("id")long id, Model model)
    {
        if(!prepodRepository.existsById(id)){
            return "redirect:/prepods";
        }
        Optional<Prepod> prepod = prepodRepository.findById(id);
        ArrayList<Prepod> res = new ArrayList<>();
        prepod.ifPresent(res::add);
        model.addAttribute("prepod",res);
        return "prepod-edit";
    }
    @PostMapping("/prepod/{id}/edit")
    public String PrepodUpdate(@PathVariable("id")long id,
                                 @RequestParam String familia,
                                 @RequestParam String name,
                                 @RequestParam String otch,
                                 @RequestParam String predmeti,
                                 @RequestParam String grafic,
                                 Model model)
    {
        Prepod prepod = prepodRepository.findById(id).orElseThrow();
        prepod.setFamilia(familia);
        prepod.setName(name);
        prepod.setOtch(otch);
        prepod.setPredmeti(predmeti);
        prepod.setGrafic(grafic);
        prepodRepository.save(prepod);
        return "redirect:/prepods";
    }
    @PostMapping("/prepod/{id}/remove")
    public String PrepodDelete(@PathVariable("id") long id, Model model){
        Prepod prepod = prepodRepository.findById(id).orElseThrow();
        prepodRepository.delete(prepod);
        return "redirect:/prepods";
    }


    @GetMapping("/student/{id}")
    public String studentDetails(@PathVariable(value = "id") long id, Model model)
    {
        Optional<Student> student = studentRepository.findById(id);
        ArrayList<Student> res = new ArrayList<>();
        student.ifPresent(res::add);
        model.addAttribute("student", res);
        if(!studentRepository.existsById(id))
        {
            return "redirect:/students";
        }
        return "student-details";
    }
    @GetMapping("/student/{id}/edit")
    public String studentEdit(@PathVariable("id")long id, Model model)
    {
        if(!studentRepository.existsById(id)){
            return "redirect:/students";
        }
        Optional<Student> student = studentRepository.findById(id);
        ArrayList<Student> res = new ArrayList<>();
        student.ifPresent(res::add);
        model.addAttribute("student",res);
        return "student-edit";
    }
    @PostMapping("/student/{id}/edit")
    public String StudentUpdate(@PathVariable("id")long id,
                               @RequestParam String familia,
                               @RequestParam String name,
                               @RequestParam String otch,
                               @RequestParam String grupa,
                               @RequestParam String birthday,
                               Model model)
    {
        Student student = studentRepository.findById(id).orElseThrow();
        student.setFamilia(familia);
        student.setName(name);
        student.setOtch(otch);
        student.setGrupa(grupa);
        student.setBirthday(birthday);
        studentRepository.save(student);
        return "redirect:/students";
    }
    @PostMapping("/student/{id}/remove")
    public String StudentDelete(@PathVariable("id") long id, Model model){
        Student student = studentRepository.findById(id).orElseThrow();
        studentRepository.delete(student);
        return "redirect:/students";
    }
}
