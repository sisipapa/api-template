package com.sisipapa.template.api.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
public class Address {
    private String addr;
    private String detailAddr;
    private String post;
}
