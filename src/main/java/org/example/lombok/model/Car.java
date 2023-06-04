package org.example.lombok.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "cars")
@Getter
@Setter
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String manufacturer;
    private String name;
    private int topSpeed;

    public Car(String manufacturer, String name, int topSpeed) {
        this.manufacturer = manufacturer;
        this.name = name;
        this.topSpeed = topSpeed;
    }

    public String objStrData() {
        return "Car: " + getManufacturer() +  " " + getName()
                + " topSpeed" + getTopSpeed();
    }
}
