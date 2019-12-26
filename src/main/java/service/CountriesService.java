package service;
//package model;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Locale;
//import java.util.Map;
//
//import javax.annotation.PostConstruct;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import lombok.NoArgsConstructor;
//
//@Service
//@NoArgsConstructor
//public class CountriesService {
//
//    @Value("${wee.countries.user}")
//    private List<String> countries;
//
//    @Value("${po.editor.languages}")
//    private List<String> languages;
//
//    @Value("${wee.countries.locales}")
//    private List<String> locales;
//
//    private Map<String, String> languagesMap;
//
//    @PostConstruct
//    public void init() {
//        languagesMap = new HashMap<>();
//
////        for (String locale : locales) {
////            var localeSegments = locale.split("_");
////            languagesMap.put(localeSegments[1], localeSegments[0]);
////        }
//    }
//
//    public CountryInformationDTO getCountryInformation() {
//    	return null;
////        return CountryInformationDTO.builder()
////            .countriesUser(countries)
////            .availableLanguages(languages)
////            .build();
//    }
//
//    public boolean isLanguageSupported(Locale locale) {
//    	
//    	return false;
////        return locale != null && getCountryInformation().getAvailableLanguages().contains(locale.getLanguage());
//    }
//
//    public String languageLookupByCountry(String countryCode) {
//        return languagesMap.get(countryCode);
//    }
//}
