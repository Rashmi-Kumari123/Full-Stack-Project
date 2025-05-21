package com.saloon.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Getter
@Setter
public class UserDTO {
    private Long id;
    private String fullname;
    private String email;
}
