package encurtador.urlshortner.service;

import encurtador.urlshortner.dto.UrlDto;
import encurtador.urlshortner.entity.Url;
import encurtador.urlshortner.exception.ApplicationException;
import encurtador.urlshortner.repository.UrlRepository;
import encurtador.urlshortner.util.QrcodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static encurtador.urlshortner.util.shortenerUtil.shorten;

@Service
public class DefaultUrlService implements Urlservice {

    @Autowired
    private UrlRepository urlRepository;

    @Override
    public UrlDto save(UrlDto urlDto) {

        Url url= new Url();
        url.setFullUrl(urlDto.getFullUrl());
        url.setShortnerUrl(shorten());
        url.setExpiredAt(LocalDateTime.now().plusMinutes(10));

        Url novo =urlRepository.save(url);

        urlDto.setId(novo.getId());
        urlDto.setShortnerUrl(novo.getShortnerUrl());
        urlDto.setExpiredAt(novo.getExpiredAt());
        urlDto.setBarcode(QrcodeUtil.generateByteCode(novo.getFullUrl()));

         return urlDto;
    }
    @Override
    public String redirectToPage(String url){
        Optional<Url> urlexists =urlRepository.findByShortnerUrl(url);
        if (urlexists.isPresent()){
            return urlexists.get().getFullUrl();
        }
        throw new ApplicationException("url invalid");
    }

    @Override
    public void deleteUrl(){
      List<Url> expiredUrls = urlRepository.findAll().stream().filter(url -> url.getExpiredAt().isBefore(LocalDateTime.now())).toList();
      expiredUrls.forEach(url -> urlRepository.delete(url));
    }


}
