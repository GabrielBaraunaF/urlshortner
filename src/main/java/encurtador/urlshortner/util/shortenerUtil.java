package encurtador.urlshortner.util;

import org.apache.commons.lang3.RandomStringUtils;

public class shortenerUtil {

   public static String shorten(){
      return RandomStringUtils.randomAlphabetic(5,10);
   }
}
