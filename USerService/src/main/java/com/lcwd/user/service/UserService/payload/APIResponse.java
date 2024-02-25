package com.lcwd.user.service.UserService.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class APIResponse {

    private String message;
    private boolean success;
    private HttpStatus status;
}
