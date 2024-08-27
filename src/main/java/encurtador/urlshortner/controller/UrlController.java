package encurtador.urlshortner.controller;

import encurtador.urlshortner.dto.UrlDto;
import encurtador.urlshortner.entity.Url;
import encurtador.urlshortner.service.Urlservice;
import encurtador.urlshortner.util.QrcodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.awt.image.BufferedImage;

@RestController
@RequestMapping("/url")
public class UrlController {

    @Autowired
    private Urlservice urlservice;

    @PostMapping("/")
    public UrlDto shortenUrl(@RequestBody UrlDto url){
         return urlservice.save(url);
    }

    @GetMapping("/redirect/{url}")
    public ModelAndView redirectToPage(@PathVariable String url) {
      String fullUrl = urlservice.redirectToPage(url);
        return new ModelAndView("redirect:".concat(fullUrl));
    }

}
