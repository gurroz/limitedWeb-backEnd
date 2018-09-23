package au.com.rmit.limitedWeb.backend.controller;

import au.com.rmit.limitedWeb.backend.model.Projects;
import au.com.rmit.limitedWeb.backend.model.ProjectsRepository;
import au.com.rmit.limitedWeb.backend.services.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.security.GeneralSecurityException;

@RestController
public class HelloController {

    static final Logger LOG = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private ProjectsRepository projectsRepository;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping(path="/all")
    public @ResponseBody Iterable<Projects> getAllProjects() {
        // This returns a JSON or XML with the users
        return projectsRepository.findAll();
    }

    @RequestMapping(path="/create")
    public void createProject() {
        try {
            ProjectService.getInstance().createProject();
        } catch (IOException e) {
            LOG.error("Error IOException crear proyecto", e);
        } catch (GeneralSecurityException e) {
            LOG.error("Error GeneralSecurityException crear proyecto", e);
        }
    }
}
