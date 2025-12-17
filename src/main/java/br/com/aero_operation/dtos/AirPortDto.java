package br.com.aero_operation.dtos;

import br.com.aero_operation.model.airport.AirPort;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;

public record AirPortDto(

        @NotBlank
        @Max(3)
        String code,

        @NotBlank
        String name,

        @NotBlank
        String city
        ) {

        public AirPortDto(AirPort airPort){
                this(
                        airPort.getCode(),
                        airPort.getName(),
                        airPort.getCity()
                );
        }

}
