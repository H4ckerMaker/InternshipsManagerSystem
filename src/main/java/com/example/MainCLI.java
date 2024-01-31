package com.example;

import com.example.model.Client;

import java.util.Scanner;

public class MainCLI {
    public static void main(String[] args) {
        Client c = new Client();
        Scanner keyboard = new Scanner(System.in);
        int choice;
        String accept;
        int matricola;
        int filtro;
        String durata;
        String nome;
        int stato;
        do {
            printMenu();
            choice = keyboard.nextInt();
            switch (choice){
                case 1:
                    c.visualizzaRichieste();
                    System.out.print("Vuoi accettare una richiesta? (y/n): ");
                    accept = keyboard.next();
                    if (accept.equals("y")) {
                        System.out.println("Inserisci la matricola dello studente a cui accettare la richiesta: ");
                        matricola = keyboard.nextInt();
                        c.accettaRichiesta(matricola);
                    }
                    break;
                case 2:
                    c.visualizzaTirocini();
                    System.out.println("Vuoi applicare un filtro all' output? (y/n): ");
                    accept = keyboard.next();
                    if (accept.equals("y")){
                        printMenuFiltri();
                        filtro = keyboard.nextInt();
                        switch (filtro){
                            case 1:
                                System.out.println("Durata minima: ");
                                durata = keyboard.next();
                                c.visualizzaTirociniFilter("durata",durata);
                                break;
                            case 2:
                                System.out.println("Nome studenti: ");
                                nome = keyboard.next();
                                c.visualizzaTirociniFilter("anagrafica",nome);
                                break;
                            case 3:
                                printMenuFiltriStato();
                                stato = keyboard.nextInt();
                                switch (stato) {
                                    case 1:
                                        c.visualizzaTirociniFilter("stato","approvato");
                                        break;
                                    case 2:
                                        c.visualizzaTirociniFilter("stato", "iniziato");
                                        break;
                                    case 3:
                                        c.visualizzaTirociniFilter("stato", "terminato");
                                        break;
                                    default:
                                        System.out.println("Stato non esistente!");
                                }
                                break;
                            default:
                                System.out.println("Filtro non esistente!");
                        }
                    }
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Scelta non esistente");
            }
        } while (choice != 3);
    }

    private static void printMenu() {
        System.out.println("------ Menu -----");
        System.out.println("1 - Visualizza Richieste Tirocinio");
        System.out.println("2 - Visualizza Tirocini");
        System.out.println("3 - Esci");
    }

    private static void printMenuFiltri() {
        System.out.println("----- Menu Filtri -----");
        System.out.println("Scegli filtro: ");
        System.out.println("1 - Filtro Durata -> inserisci la durata minima dei tirocini da visualizzare");
        System.out.println("2 - Filtro Anagrafica -> inserisci il nome degli studenti di cui vuoi vedere il tirocinio");
        System.out.println("3 - Filtro Stato -> inserisci lo stato dei tirocini che vuoi visualizzare");
    }

    private static void printMenuFiltriStato() {
        System.out.println("Scegli stato: ");
        System.out.println("1 - approvato (tirocinio approvato ma non ancora iniziato)");
        System.out.println("2 - iniziato");
        System.out.println("3 - terminato");
    }
}
