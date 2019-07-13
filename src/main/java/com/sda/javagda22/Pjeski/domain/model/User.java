package com.sda.javagda22.Pjeski.domain.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long Id;

    private String firstName;
    private String lastName;
    private String city;
    private String address;
    private String postalCode;
    @NotNull
    private String email;
//    ---------------------------
    @NotNull
    private String password;
    @Transient
    private int roleNr;
    @NotNull
    private int active;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_role",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
//    @Transient
//    private String operation;

//    todo osiągnięcia za największe datki itp
//    todo logowanie
//    - tylko login widoczny dla innych w HallOfFame z powodu RODO itp
//    HallOfFame to nowa klasa?
    /* póki co hall of fame możemy sobie zostawić
    na sam koniec, bo dodanie tego to tam nawet nie wiem czy ma sens, dlatego póki co olejmy temat
    a co do, osiągnięć, to ja to widzę tak, że przy zalogowanym nicku po prostu danemu userowi będzię się wyświetlało
    przy jego nicku coś jak na allegro "zaufany sprzedawca"
     */

    public int getRoleNr() {
        return roleNr;
    }

    public void setRoleNr(int roleNr) {
        this.roleNr = roleNr;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
