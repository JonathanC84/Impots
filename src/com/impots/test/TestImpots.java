package com.impots.test;
import com.impots.Impots;
import java.util.Scanner;

public class TestImpots {
    public static void main(String[] args) {

        Scanner clavier = new Scanner(System.in);
        System.out.println("Entrez votre revenu net imposable : ");
        double revenu = clavier.nextDouble();
        System.out.println("Êtes-vous marié ou pacsé ? (Répondez par oui ou non)");
        String reponse = clavier.next().toLowerCase();
        System.out.println("Entrez le nombre d'enfants à charge (si aucun, entrez 0) : ");
        int enfants = clavier.nextInt();

        boolean mariageOuPacs = false;
        if(reponse.equals("oui")) {
            mariageOuPacs = true;
        }

        Impots mesImpots = new Impots(revenu, mariageOuPacs, enfants);

        double montant = mesImpots.calculerMontantImpot();
        System.out.println("Montant de vos impôts : "+montant+" €");
    }
}