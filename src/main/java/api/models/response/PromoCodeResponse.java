package api.models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PromoCodeResponse {

    private boolean status;
    private boolean includesDepositPromotions;
    private List<Promotion> promotions;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Promotion {
        private Long id;
        private Long code;
        private String type;

        @JsonProperty("activation_type")
        private String activationType;

        @JsonProperty("min_deposit")
        private Integer minDeposit;
    }
}