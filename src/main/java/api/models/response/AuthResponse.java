package api.models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthResponse {

    private boolean status;
    private boolean showPromoPopup;
    private String flow;
    private UserData user;

    private List<Long> promotionsCodes;
    private List<PromotionCodeData> promotionsCodesData;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class UserData {
        private Long id;
        private String token;

        @JsonProperty("session_id")
        private String sessionId;

        @JsonProperty("device_id")
        private Long deviceId;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PromotionCodeData {
        private Long upaId;
        private String code;
        private boolean isDeposit;
        private boolean activated;
    }
}