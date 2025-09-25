package com.practice.elevatorlld.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Request {
    private Direction direction;
    private Integer floorNumber;
    private RequestType requestType;
}
