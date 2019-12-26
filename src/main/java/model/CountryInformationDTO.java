package model;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder(builderClassName = "LombokBuilder")
@Getter
@AllArgsConstructor
public class CountryInformationDTO {

    @ApiModelProperty(notes = "list of valid countries for registration - holds ISO 3166-1 alpha-2 country codes")
    private List<String> countriesUser;

    @ApiModelProperty(notes = "list of available languages for translation and for communication with the customer")
    private List<String> availableLanguages;

}
