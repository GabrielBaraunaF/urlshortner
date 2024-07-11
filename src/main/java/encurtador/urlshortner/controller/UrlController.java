package encurtador.urlshortner.controller;

import encurtador.urlshortner.entity.Url;
import encurtador.urlshortner.service.Urlservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/url")
public class UrlController {

    @Autowired
    private Urlservice urlservice;

    @PostMapping("/")
    public Url shortenUrl(@RequestBody Url url){
         return urlservice.save(url);
    }

    @GetMapping("/redirect")
    public ModelAndView redirectToPage(@RequestParam String url) {
      String fullUrl = urlservice.redirectToPage(url);
        return new ModelAndView("redirect:".concat(fullUrl));
    }
}
