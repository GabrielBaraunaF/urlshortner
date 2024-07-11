package encurtador.urlshortner.repository;

import encurtador.urlshortner.entity.Url;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UrlRepository extends JpaRepository<Url,Integer> {
    Optional<Url> findByShortnerUrl(String shortnerUrl);
}
