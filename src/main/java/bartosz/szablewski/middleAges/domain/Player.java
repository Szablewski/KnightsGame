package bartosz.szablewski.middleAges.domain;

import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Player {

    @Id
    @Email(message = "Podaj prawidłowy email")
    @NotEmpty(message = "Pole nie może być puste")
    @Column(unique = true)
    private String email;
    @Size(min = 6, message = "Hasło musi zawierać conajmniej 6 znaków")
    private String password;
    @NotEmpty(message = "Pole nie może być puste")
    private String firstName;
    @NotEmpty(message = "Pole nie może być puste")
    private String lastName;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "PLAYER_ROLES", joinColumns = {
        @JoinColumn(name = "PLAYER_EMAIL", referencedColumnName = "email")},
            inverseJoinColumns = {
                @JoinColumn(name = "ROLE_NAME", referencedColumnName = "name")})
    private List<Role> roles;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "player")
    private List<Knight> knights;

    public Player(String email, String password, String firstName, String lastName) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.email);
        hash = 29 * hash + Objects.hashCode(this.password);
        hash = 29 * hash + Objects.hashCode(this.firstName);
        hash = 29 * hash + Objects.hashCode(this.lastName);
        hash = 29 * hash + Objects.hashCode(this.roles);
        hash = 29 * hash + Objects.hashCode(this.knights);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Player other = (Player) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.roles, other.roles)) {
            return false;
        }
        if (!Objects.equals(this.knights, other.knights)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Player{" + "email=" + email + ", password=" + password + ", firstName=" + firstName + ", lastName=" + lastName + ", roles=" + roles + ", knights=" + knights + '}';
    }

}
