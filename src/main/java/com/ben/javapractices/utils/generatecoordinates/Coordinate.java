package com.ben.javapractices.utils.generatecoordinates;

import java.text.MessageFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Coordinate {

    private Double latitude;

    private Double longitude;

    @Override
    public String toString() {
        return MessageFormat.format("{0},{1}", latitude, longitude);
    }

}
