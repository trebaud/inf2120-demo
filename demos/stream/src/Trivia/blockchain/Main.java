package Trivia.blockchain;

/**
 * Created by thomas on 11/9/17.
 */
public class Main {
    public static void main(String[] args) {

        Blockchain blockchain = new Blockchain();
        Mineur mineur = new Mineur(blockchain);

        blockchain.ajouterTransaction("Satoshi Nakamoto", "Elon Musk", 50);
        blockchain.ajouterTransaction("Satoshi Nakamoto", "Barack Obama", 400);
        blockchain.ajouterTransaction("Bill Clinton", "Elon Musk", 40);
        blockchain.ajouterTransaction("Satoshi Nakamoto", "Linus Torvalds", 1000);
        blockchain.ajouterTransaction("Bill Clinton", "Barack Obama", 4000);

        mineur.miner();

        System.out.println("\n/****  Verification de la validite de la BlockChain  ****/");
        System.out.println("\t>>>>>>>>> Cette chaine est " + (blockchain.chaineEstValide() ? "valide" : "invalide") + " !");

        if(blockchain.chaineEstValide())
            blockchain.afficher();

        blockchain.ajouterTransaction("Bill Gates", "Linus Torvalds", 1000);
        blockchain.ajouterTransaction("Bill Gates", "Linus Torvalds", 1000);
        blockchain.ajouterTransaction("Bill Gates", "Linus Torvalds", 1000);
        blockchain.ajouterTransaction("Bill Gates", "Linus Torvalds", 1000);
        blockchain.ajouterTransaction("Linus Torvalds", "Steve Jobs", 1);


        mineur.miner();

        System.out.println("\n/****  Verification de la validite de la BlockChain  ****/");
        System.out.println("\t>>>>>>>>> Cette chaine est " + (blockchain.chaineEstValideAlt() ? "valide" : "invalide") + " !");

        if(blockchain.chaineEstValideAlt())
            blockchain.afficher();

        System.out.println("!!! Un hacker s'est introduit dans le systeme !!!");
        blockchain.getChaine().get(1).getTransactions().get(0).quantite = 0; // ici on suppose qu'un agent malfaiteur tente de modifier une transaction ulterieure

        System.out.println("\n/****  Verification de la validite de la BlockChain  ****/");
        System.out.println("\t>>>>>>>>> Cette chaine est " + (blockchain.chaineEstValide() ? "valide" : "invalide") + " !");

    }

}
