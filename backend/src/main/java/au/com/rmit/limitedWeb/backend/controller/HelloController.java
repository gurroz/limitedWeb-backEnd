package au.com.rmit.limitedWeb.backend.controller;

import au.com.rmit.limitedWeb.backend.model.Projects;
import au.com.rmit.limitedWeb.backend.model.ProjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

    @Autowired
    private ProjectsRepository projectsRepository;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping(path="/all")
    public @ResponseBody
    Iterable<Projects> getAllProjects() {
        // This returns a JSON or XML with the users
        return projectsRepository.findAll();
    }
}
