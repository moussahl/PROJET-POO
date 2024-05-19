/* realise par HALOUI Moussa */

package poo_project;

import java.util.Scanner;

public class MenuPricipale {

  public static void main(String[] args) {

DatabaseBienImmobilier bien = new DatabaseBienImmobilier();
Client clientManager = new Client();
Agent_Immobilier agent = new Agent_Immobilier();
Transactions transaction = new Transactions();

/* La classe rendez_vous n'a pas été construite dans la même idée que les autres classes.
 Son auteur a décidé d’écrire une méthode main statique a la classe rendez_vous qui instancie un objet rendez_vous. 
 Il n'est donc pas nécessaire de l'instancier ici. ---- voyez la classe Rendez vous ----*/









    
  int choix = 0;
  Scanner scan = new Scanner(System.in);
  boolean bool = false;

   do {
    
   
    System.out.println("Choisissez votre choix:");
    System.out.println("1: Gestion des bien immobilier");
    System.out.println("2: Gestion des clients (clientèle - propriétaire)");
    System.out.println("3: Gestion des rendez-vous");
    System.out.println("4: Gestion des transactions");
    System.out.println("5: Gestion des agents immobiliers");
    System.out.println("0: Quitter");


    
 do {
   try {
    System.out.println("votre choix:");
    choix =  scan.nextInt();
    bool = true;
   } catch (Exception e) {
    System.out.println("try again");
    scan.next();
   }
  } while (!bool);



  switch (choix) {
    case 1:
       
       bien.menu_bien_immobilier(); //Gestion des bien immobilier
        break;
    case 2:
        
      clientManager.menu_client();//Gestion des clients
        break;
    case 3:
       
        RendezVous.main(args);   //Gestion des rendez-vous
        break;
    case 4:
     transaction.Menu();   //Gestion des transactions
        break;
    case 5:
        agent.Menu();     //Gestion des agents immobiliers

        break;
    case 0:
        System.out.println("Au revoir!");
        break;
    default:
        System.out.println("Choix invalide. Veuillez réessayer.");
}
} while (choix != 0);

  }
}
