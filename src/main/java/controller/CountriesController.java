//package hello;
//
//import com.wee.my.services.countries.CountriesService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
//
//@RestController
//@Api(description = "Countries endpoint")
//public class CountriesController {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(CountriesController.class);
//
//    @Autowired
//    private CountriesService countriesService;
//
//    @GetMapping(value = "/countries", produces = APPLICATION_JSON_VALUE)
//    @ApiOperation("Get the enabled countries for registration")
//    public CountryInformationDTO getCountryInformation() {
//        LOGGER.debug("loading enabled countries for registration");
//
//        return countriesService.getCountryInformation();
//    }
//
//}
