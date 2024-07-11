package encurtador.urlshortner.service;

import encurtador.urlshortner.entity.Url;

public interface Urlservice {

    public Url save(Url url);
    public String redirectToPage(String ur);
    public void deleteUrl();
}
