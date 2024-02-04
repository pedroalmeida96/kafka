package com.pedroalmeida.common;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Employee {

    private int id;
    private String name;

}
