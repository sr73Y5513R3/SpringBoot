package com.salesianos.pruebaSeguridad02.user.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue

    private UUID id;

    private String username;
    private String password;
    private String avatar;
    private String fullName;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<UserRole> roles;
}
