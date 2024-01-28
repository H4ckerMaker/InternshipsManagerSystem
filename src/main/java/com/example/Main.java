package com.example;

import com.example.model.Client;

public class Main {
    public static void main(String[] args) {
        Client c = new Client();
        String req = c.getRichieste();
        System.out.println(req);
    }
}
