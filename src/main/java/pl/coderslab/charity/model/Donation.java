package pl.coderslab.charity.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "donations")
@Getter
@Setter
@ToString(exclude = {"categories", "institution"})
@EqualsAndHashCode(of = {"id"})
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Integer quantity;
    @ManyToMany
    @JoinTable(
            joinColumns = {@JoinColumn(name = "donation_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id")},
            uniqueConstraints = {@UniqueConstraint(
                    columnNames = {"donation_id", "category_id"})})
    private List<Category> categories;
    @ManyToOne
    private Institution institution;
    private String street;
    private String city;
    @Column(name = "zip_code")
    private String zipCode;
    private String phone;
    @Column(name = "pick_up_date")
    private LocalDate pickUpDate;
    @Column(name = "pick_up_time")
    private LocalTime pickUpTime;
    @Column(name = "picku_up_comment")
    private String pickUpComment;
}
