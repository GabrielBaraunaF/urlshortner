package encurtador.urlshortner.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "fullUrl")
    private String fullUrl;

    @Column(name = "shortnerUrl")
    private String shortnerUrl;

    @Column(name = "expiredAt")
    private LocalDateTime expiredAt;


}
