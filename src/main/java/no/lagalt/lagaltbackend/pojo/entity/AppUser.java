package no.lagalt.lagaltbackend.pojo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import no.lagalt.lagaltbackend.pojo.enums.AuthorityType;
import no.lagalt.lagaltbackend.pojo.enums.UserVisibility;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;
    private String full_name;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private AuthorityType authorityType;
    @Enumerated(EnumType.STRING)
    private UserVisibility userVisibility;
    @OneToMany(mappedBy = "owner")
    private Set<Project> projects;

    @ManyToMany(mappedBy = "users")
    private Set<Skill> skills;


    @JsonIgnore
    private byte[] encryptedPassword;

}
