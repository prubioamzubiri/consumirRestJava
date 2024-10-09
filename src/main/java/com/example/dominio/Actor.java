package com.example.dominio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Actor {

    private Long id;
    private String name;
    private int numero_de_premios;
    private String sueldo_por_pelicula;
    
}
