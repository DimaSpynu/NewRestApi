package com.spynu.newrestapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    String id = UUID.randomUUID().toString();
    String username;
    String password;
    String email;
    String fio;

}
