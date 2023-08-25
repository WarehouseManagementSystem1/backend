package com.app.dto;

import com.app.entities.UserType;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class SigninResponse {
private Long userId;
private String name;
private UserType userType;
private Long warehouseId;
}
