package encurtador.urlshortner.service;

import encurtador.urlshortner.dto.UrlDto;
import encurtador.urlshortner.entity.Url;

public interface Urlservice {

    public UrlDto save(UrlDto url);
    public String redirectToPage(String ur);
    public void deleteUrl();
}
