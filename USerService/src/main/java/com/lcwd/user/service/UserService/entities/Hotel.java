package com.lcwd.user.service.UserService.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Hotel {

    private String id;

    private String name;

    private String location;

    private String about;
}
