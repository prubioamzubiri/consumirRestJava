package com.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.example.dominio.Actor;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) {
        
        HttpResponse<String> response;
        ObjectMapper mapper = new ObjectMapper();
        
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("http://localhost:8080/peliculas/saludar"))
            .build();

        try{

            response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Response Body: " + response.body());

        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }

        request = HttpRequest.newBuilder()
            .uri(URI.create("http://localhost:8080/actor/203"))
            .build();

        try{

            response = client.send(request, HttpResponse.BodyHandlers.ofString());

            
            Actor actor = mapper.readValue(response.body(), Actor.class);

            System.out.println(mapper.readTree(response.body()).get("name").asText());
    
            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Response Body: " + response.body());
            System.out.println("Actor: " + actor.toString());
    
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}