package sk.stuba.fei.uim.oop.assignment3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @GetMapping()
    public String hello(){
        return "Hello author";
    }
}
