package org.example.supplierservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.example.supplierservice.enums.*;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class User extends GlobalRecord {
    // Primary Information
    private String id;

    // Personal Information
    private String firstName;
    private String lastName;

    // Authentication
    private String email;
    private String password;
    private String phoneNumber;

    // Profile
    private String profilePictureUrl;
    private String designation;


    // Company Association
    @ManyToOne
    private Company company;

    // Access & Security
    @Enumerated
    private UserType userType;
    @Enumerated
    private UserStatus status;
    private Boolean emailVerified;
    private Boolean phoneVerified;
    private Boolean mfaEnabled;

    // Login Tracking
    private LocalDateTime lastLoginAt;
    private String lastLoginIp;
    private Integer failedLoginAttempts;
    private Boolean accountLocked;

    // Preferences
    @Enumerated
    private TimeZone timezone;
    @Enumerated
    private Language language;
    @Enumerated
    private Currency preferredCurrency;

    @ManyToMany
    private List<Role> roles;

    // Soft Delete
    private Boolean deleted;

    // Misc
    private String notes;
}
