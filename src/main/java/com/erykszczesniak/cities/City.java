package com.erykszczesniak.cities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@Entity
public class City implements Serializable {
    private static final long serialVersionUID = 8539936152170847419L;

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int population;


}