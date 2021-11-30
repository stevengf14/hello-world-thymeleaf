
package ec.com.learning.HelloWorld;


import ec.com.learning.domain.Person;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Steven
 */
@Controller
@Slf4j
public class InitController {
    
    @Value("${index.hello}")
    private String hello;
    
    @GetMapping("/")
    public String init(Model model){
        var message = "Hello World using Thymeleaf";
        
        var person = new Person();
        person.setName("Steven");
        person.setLastName("Guamán");
        person.setEmail("stevengf14@gmail.com");
        person.setPhone("09xxxxxxxx");
        
        var person2 = new Person();
        person2.setName("Nicole");
        person2.setLastName("Latorre");
        person2.setEmail("nicolat@gmail.com");
        person2.setPhone("09xxxxxxxx");
        
//        List<Person> people = new ArrayList<>();
//        people.add(person);
//        people.add(person2);
                
        var people = Arrays.asList(person, person2);
        
        log.info("Executing Spring MVC controller");
        model.addAttribute("message", message);
        model.addAttribute("hello", hello);
        //model.addAttribute("person", person);
        model.addAttribute("people", people);
        return "index";
    }
}
