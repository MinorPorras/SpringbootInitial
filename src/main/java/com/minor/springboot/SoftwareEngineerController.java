package com.minor.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/software-engineers")
public class SoftwareEngineerController {
    @GetMapping
    public List<SoftwareEngineer> getAllSoftwareEngineers() {
        return List.of(
                new SoftwareEngineer(1, "John Doe", "Java Developer"),
                new SoftwareEngineer(2, "Jane Smith", "Python Developer"),
                new SoftwareEngineer(3, "Alice Johnson", "Full Stack Developer")
        );
    }

    @GetMapping("hello")
    public String sayHello() {
        return "Hello, World!";
    }
}
