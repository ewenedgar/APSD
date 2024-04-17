package edu.miu.cs.cs489.lab7.adsapp.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patientId;
    @Column(nullable = false)
//    @NotNull(message = "Patient Name is required and cannot be null") // new Patient("")
//    @NotEmpty(message = "Patient Name is required and cannot be null or empty string") //new Patient(" ")
    @NotBlank(message = "Patient First Name is required and cannot be null or empty string or blank spaces")
    private String lastName;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id", unique = true, nullable = true)
//    @JsonIgnore
    @JsonManagedReference
    private Address primaryAddress;



    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Patient{");
        sb.append("patientId=").append(patientId);
        sb.append(", last name='").append(lastName).append('\'');
        sb.append(", primaryAddress=").append(primaryAddress);
        sb.append('}');
        return sb.toString();
    }
}
