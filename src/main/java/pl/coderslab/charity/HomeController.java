package pl.coderslab.charity;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.charity.institution.InstitutionService;

@Controller
@RequiredArgsConstructor
@Slf4j
public class HomeController {
    private final InstitutionService institutionService;

    @GetMapping("/")
    public String home(Model model) {
        log.debug("\n ADDING LIST OF ALL FOUNDATIONS TO MODEL");
        model.addAttribute("foundations", institutionService.getAll());
        return "index";
    }
}
