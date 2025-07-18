import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PersonController{
    private final PersonService personService;

    public Person getPerson(){
        
    }
}