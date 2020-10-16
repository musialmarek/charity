package pl.coderslab.charity.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.donation.DonationRepository;
import pl.coderslab.charity.model.Donation;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/donations")
@RequiredArgsConstructor
public class DonationController {

    private final DonationRepository donationRepository;

    @GetMapping
    public List<Donation> getAll() {
        return donationRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    // Location: /api/donations/178
    public void create(@RequestBody Donation donation, HttpHeaders headers) {
        donationRepository.save(donation);
        headers.setLocation(URI.create("/api/donations/" + donation.getId()));
    }

    @GetMapping("/{id}")
    // 404 NOT FOUND
    // 200 OK + w treści obiekt Donation
    public ResponseEntity get(@PathVariable Long id) {
        return donationRepository.findById(id)
                .map(donation -> ResponseEntity.ok(donation))
//                .map(donation -> ResponseEntity.ok().header("X-Forwarded-For", "oklahoma").body(donation))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        Optional<Donation> optionalDonation = donationRepository.findById(id);
        if (optionalDonation.isPresent()) {
            donationRepository.delete(optionalDonation.get());
//            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            return ResponseEntity.ok(optionalDonation.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public Donation update(@RequestBody Donation donation) {
        return null;
    }
}
