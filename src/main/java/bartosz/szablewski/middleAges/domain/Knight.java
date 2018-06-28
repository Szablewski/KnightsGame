package bartosz.szablewski.middleAges.domain;

import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Knight {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Size(min = 2, max = 35, message = "Imie rycerza musi mieć między 2, a 35 znaków")
    private String dignity;
    @Range(min = 16, max = 50, message = "Wiek rycerza nie może być większy niż 50 i mniejszy niż 16")
    private int age;
    private int level = 1;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "PLAYER_EMAIL")
    private Player player;

    public Knight(String dignity, int age, int level) {
        this.dignity = dignity;
        this.age = age;
        this.level = 1;
    }

    public Knight(String dignity, int age, int level, Player player) {
        this.dignity = dignity;
        this.age = age;
        this.level = 1;
        this.player = player;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.dignity);
        hash = 89 * hash + this.age;
        hash = 89 * hash + this.level;
        hash = 89 * hash + Objects.hashCode(this.player);
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
        final Knight other = (Knight) obj;
        if (this.age != other.age) {
            return false;
        }
        if (this.level != other.level) {
            return false;
        }
        if (!Objects.equals(this.dignity, other.dignity)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.player, other.player)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Knight{" + "id=" + id + ", dignity=" + dignity + ", age=" + age + ", level=" + level + ", player=" + player + '}';
    }

}
