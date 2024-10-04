package es.ies.puerto;

/**
 * Dos equipos de héroes han recolectado botines durante una misión conjunta. 
 * Escribe un programa que combine ambos inventarios de botines en uno solo.
 * @author eduglezexp
 */

public class Ejercicio8 {
    public static void main(String[] args) {
        String[] botinEquipo1 = {"Espada mágica", "Escudo resistente"};
        String[] botinEquipo2 = {"Anillo de poder", "Armadura encantada"}; 
        int tamanioCompleto = botinEquipo1.length + botinEquipo2.length;
        String[] botinTotal = new String[tamanioCompleto];
        for (int i = 0; i < botinEquipo1.length; i++) {
            botinTotal[i] = botinEquipo1[i];
        }
        for (int i = 0; i < botinEquipo2.length; i++) {
            botinTotal[botinEquipo1.length + i] = botinEquipo2[i];
        }
        for (String botin : botinTotal) {
            System.out.print(botin + ", ");
        }
    }
}
