package api.models.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegistrationRequest {

    private String email;
    private String password;

    @JsonProperty("is_accept")
    @Builder.Default
    private Integer isAccept = 1;

    @Builder.Default
    private String language = "uk";

    @Builder.Default
    private String promokey = "";

    @Builder.Default
    private String type = "email";

    @Builder.Default
    private String fingerprint = "1b942df1be8b0356e346bea9c69838ee";

    @Builder.Default
    private DeviceData device = new DeviceData();

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DeviceData {
        @Builder.Default
        private String platform = "ANDROID";

        @JsonProperty("device_id")
        @Builder.Default
        private String deviceId = "test_device_12345";

        @JsonProperty("device_model")
        @Builder.Default
        private String deviceModel = "QA_Emulator";

        @JsonProperty("os_version")
        @Builder.Default
        private String osVersion = "13";

        @JsonProperty("app_version")
        @Builder.Default
        private String appVersion = "1.0.0";

        @JsonProperty("user_agent")
        @Builder.Default
        private String userAgent = "QA_Auto_Test_Agent";

        @JsonProperty("browser_name")
        @Builder.Default
        private String browserName = "Chrome";

        @JsonProperty("browser_version")
        @Builder.Default
        private String browserVersion = "120.0";
    }
}