package com.geekster.Backend_Traini8_KevinRoland.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TrainingCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    @NotBlank(message = "CenterName is mandatory")
    @Size(max = 40, message = "CenterName must be less than 40 characters")
    private String centerName;
    @NotBlank(message = "CenterCode is mandatory")
    @Pattern(regexp = "\\p{Alnum}{12}", message = "CenterCode must be exactly 12 alphanumeric characters")
    private String centerCode;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Address_fk")
    private Address address;
    private int Student_Capacity;
    private List<String>Courses_Offered;
    @CreationTimestamp
    private String CreatedOn;

    @NotNull(message = "Email is mandatory")
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Invalid email format")
    private String ContactEmail;

    @NotNull(message = "Phone number is mandatory")
    @NotBlank(message = "Phone number is mandatory")
    @Size(min = 10, max = 10, message = "Phone number must be exactly 10 digits")
    private String ContactPhone;

}
