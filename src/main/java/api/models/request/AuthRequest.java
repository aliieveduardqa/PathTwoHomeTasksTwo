package api.models.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthRequest {

    private String email;

    @JsonProperty("phone_code")
    private String phoneCode;

    private String phone;

    private String password;

    @Builder.Default
    private String type = "email";
}