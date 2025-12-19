package com.blychain.spocp.transferObject.documents;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AgentContactTO {

    @Schema(example = "Agent Jane Smith")
    @NotBlank(message = "The name cannot be null or blank")
    private String name;

    @Schema(example = "jane.smith@example.com")
    @Email(message = "Invalid email")
    @NotBlank(message = "The email cannot be null or blank")
    private String email;

    @Schema(example = "+1 987-654-3210")
    @NotBlank(message = "The phone cannot be null or blank")
    private String phone;
}
