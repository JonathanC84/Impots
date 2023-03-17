package com.impots;

public class Impots {
    private double revenu;
    private boolean mariageOuPacs;
    private int enfants;

    static final double TRANCHE_1 = 9807;
    static final double TRANCHE_2 = 27086;
    static final double TRANCHE_3 = 72617;

    public Impots() {
    }

    public Impots(double revenu, boolean mariageOuPacs, int enfants) {
        this.revenu = revenu;
        this.mariageOuPacs = mariageOuPacs;
        this.enfants = enfants;
    }

    public double calculerPartsQF (boolean mariageOuPacs, int enfants) {
        double partsQF = 1;

        if(mariageOuPacs) {
            partsQF++;
        }

        if(enfants<3) {
            partsQF += enfants*0.5;
        } else {
            partsQF += enfants - 1;
        }

        return partsQF;
    }

    public double calculerMontantImpot() {
        double montant = 0;
        double partsQF = calculerPartsQF(this.mariageOuPacs, this.enfants);
        double revenuRecalcule = this.revenu / partsQF;

        if(revenuRecalcule > TRANCHE_1) {
            if(revenuRecalcule < TRANCHE_2) {
                montant += (revenuRecalcule - TRANCHE_1)*14/100;
            } else {
                montant += (TRANCHE_2 - TRANCHE_1)*14/100;
            }
        }

        if(revenuRecalcule > TRANCHE_2) {
            if(revenuRecalcule < TRANCHE_3) {
                montant += (revenuRecalcule - TRANCHE_2)*30/100;
            } else {
                montant += (TRANCHE_3 - TRANCHE_2 - TRANCHE_1)*30/100;
            }
        }

        if(revenuRecalcule > TRANCHE_3) {
            montant += (revenuRecalcule - TRANCHE_3 - TRANCHE_2 - TRANCHE_1)*41/100;
        }

        montant *= partsQF;

        return montant;
    }
}
