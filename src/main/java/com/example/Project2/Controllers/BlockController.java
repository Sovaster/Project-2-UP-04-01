package com.example.Project2.Controllers;

import com.example.Project2.Models.Prepod;
import com.example.Project2.Models.Student;
import com.example.Project2.repo.PrepodRepository;
import com.example.Project2.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.Project2.Models.Post;
import com.example.Project2.repo.PostRepository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
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
}
