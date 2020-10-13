package pl.coderslab.charity.donation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.category.CategoryService;
import pl.coderslab.charity.institution.InstitutionService;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Donation;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/donation")
public class DonationController {
    private final DonationService donationService;
    private final CategoryService categoryService;
    private final InstitutionService institutionService;

    @GetMapping("/form")
    public String donationForm(Model model) {
        Donation donation = new Donation();
        log.debug("ADDING EMPTY DONATION TO MODEL");
        model.addAttribute("donation", donation);
        log.debug("ADDING ALL CATEGORIES TO MODEL");
        model.addAttribute("categories", categoryService.getAll());
        log.debug("ADDING ALL ORGANIZATIONS TO MODEL");
        model.addAttribute("organizations", institutionService.getAll());
        log.debug("SHOWING ADD-DONATION FORM");
        return "donation/form";
    }

    @PostMapping("/form")
    public String saveDonation(Donation donation) {
        for (Category category : donation.getCategories()) {
            log.debug("\nSAVING DONATION HAS CATEGORY: {}",category.getName());
        }
        Donation saved = donationService.save(donation);
        if(saved!=null&&saved.getId()!=null){
            return "redirect:/donation/success";
        }
        return "redirect:/donation/form";
    }

    @GetMapping("/success")
    public String confirmDonation(){
        return "donation/form-confirmation";
    }
}
