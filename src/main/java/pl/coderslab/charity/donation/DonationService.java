package pl.coderslab.charity.donation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DonationService {
    private final DonationRepository donationRepository;

    public Integer numberOfAllBugs() {
        Integer numberOfAllDonations = donationRepository.getNumberOfAllDonations();
        if (numberOfAllDonations == null) {
            numberOfAllDonations = 0;
        }
        return numberOfAllDonations;
    }

    public Integer numberOfAllDonations() {
        Integer numberPickUpDonations = donationRepository.getNumberPickUpDonations();
        if (numberPickUpDonations == null) {
            numberPickUpDonations = 0;
        }
        return numberPickUpDonations;
    }
}
