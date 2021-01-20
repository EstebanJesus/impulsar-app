package com.impulsar.app.api.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

@Entity
@Table(name = "user_app")
public class UserApp extends AbstractAuditingEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String login;
    @Column(name = "password_hash", length = 60, nullable = false)
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String langKey;
    private String imageUrl;

    @ManyToMany
    @JoinTable(
            name = "user_app_authority",
            joinColumns = {@JoinColumn(name = "user_app_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "name")}
    )
    private Set<Authority> authorities;

    public UserApp() {
        this.authorities = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLangKey() {
        return langKey;
    }

    public void setLangKey(String langKey) {
        this.langKey = langKey;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Stream<Authority> authoritiesStream() {
        return this.authorities.stream();
    }
}
