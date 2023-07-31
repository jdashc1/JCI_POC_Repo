package com.user.service.Payload;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class APIResponce {
private String message;
private boolean success;
private HttpStatus status;

}
