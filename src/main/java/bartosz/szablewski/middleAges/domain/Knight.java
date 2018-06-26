package bartosz.szablewski.middleAges.domain;

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

}
