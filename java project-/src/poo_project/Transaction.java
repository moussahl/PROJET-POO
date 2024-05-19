/* realise par DEHILI Mehdi */

package poo_project;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.text.*;
class Transactions { // La structure de cette classe et les methodes utilisees sont similaires a celle
                     // de la classe Agent_Immobilier. Seul des commentaires notables seront ajoutes.
  public static class Node {
    private int jour;
    private int mois;
    private int annee;
    private boolean type;
    private boolean etat;
    private int id_proprietaire;
    private int id_clientele;
    private int id_transaction;
    private double somme;
    private Node next;
    Node(int jour, int mois, int annee, boolean type, int id_proprietaire,
      int id_clientele, int id_transaction, double somme, boolean etat) {
      this.jour = jour;
      this.mois = mois;
      this.annee = annee;
      this.type = type;
      this.id_proprietaire = id_proprietaire;
      this.id_clientele = id_clientele;
      this.id_transaction = id_transaction;
      this.somme = somme;
      this.etat = etat;
      this.next = null;
    }
    // Getters
    public int getJour() {
      return jour;
    }
    public double getsomme() {
      return somme;
    }
    public int getMois() {
      return mois;
    }
    public int getAnnee() {
      return annee;
    }
    public boolean isType() {
      return type;
    }
    public boolean isEtat() {
      return etat;
    }
    public int getId_proprietaire() {
      return id_proprietaire;
    }
    public int getId_clientele() {
      return id_clientele;
    }
    public int getId_transaction() {
      return id_transaction;
    }
    // Setters
    public void setJour(int jour) {
      this.jour = jour;
    }
    public void setMois(int mois) {
      this.mois = mois;
    }
    public void setsomme(double somme) {
      this.somme = somme;
    }
    public void setAnnee(int annee) {
      this.annee = annee;
    }
    public void setType(boolean type) {
      this.type = type;
    }
    public void setEtat(boolean etat) {
      this.etat = etat;
    }
    public void setId_proprietaire(int id_proprietaire) {
      this.id_proprietaire = id_proprietaire;
    }
    public void setId_clientele(int id_clientele) {
      this.id_clientele = id_clientele;
    }
    public void setId_transaction(int id_transaction) {
      this.id_transaction = id_transaction;
    }
    public Node getNext() {
      return next;
    }
    public void setNext(Node next) {
      this.next = next;
    }
  }
  private Node head;
  private int size;
  Transactions() {
    this.head = null;
    this.size = 0;
  }
  public void Initialiser(int jour, int mois, int annee, boolean type,
    int id_proprietaire, int id_clientele,
    double somme, boolean etat) {
    Node newNode =
      new Node(jour, mois, annee, type, id_proprietaire, id_clientele,
        ++size, somme, etat);
    if (head == null) {
      head = newNode;
    } else {
      Node current = head;
      while (current.getNext() != null) {
        current = current.getNext();
      }
      current.setNext(newNode);
    }
  }
  public void Initialisercomp() {
    Initialiser(6, 5, 2024, false, 4, 4, 25000,false);
    Initialiser(13, 7, 2024, true, 4, 4, 250000000,true);
    Initialiser(16, 12, 2024, false, 4, 4, 25000,true);
    Initialiser(8, 1, 2024, false, 4, 4, 25000,true);
    Initialiser(12, 6, 2024, true, 4, 4, 250000000,false);
  }
  static public String customFormat(String pattern, double value) { // custmFormat est aussi utile dans cette classe
    DecimalFormat myFormatter = new DecimalFormat(pattern);
    String output = myFormatter.format(value);
    return output;
  }
  
  
  public void ajouter() {
    System.out.println("Ajout d'une transaction:");
    Scanner scanner = new Scanner(System.in);
    boolean continuer = true;
    boolean saisieValide = false;
    int jour = 0;
    while (continuer) {
      saisieValide = false;
      while (!saisieValide) {
        try {
          System.out.print("Entrez le jour de la transaction: ");
          jour = scanner.nextInt();
          saisieValide = true;
          if (jour > 32 || jour < 1) {
            System.out.println("Saisie incorrecte, veuillez inserer un chiffre entre ou egal a 1 et 31");
            saisieValide = false;
          }
        } catch (InputMismatchException e) {
          System.out.println("La saisie est incorrecte. Veuillez saisir une valeur numerique valide.");
          scanner.next();
        }
      }


      int mois = 0;
      saisieValide = false;
      while (!saisieValide) {
        try {
          System.out.print("Entrez le mois de la transaction: ");
          mois = scanner.nextInt();
          saisieValide = true;
          if (mois > 12 || mois < 1) {
            System.out.println("Saisie incorrecte, veuillez inserer un chiffre entre ou egal a 1 et 12");
            saisieValide = false;
          }
        } catch (InputMismatchException e) {
          System.out.println("La saisie est incorrecte. Veuillez saisir une valeur numC)rique valide.");
          scanner.next();
        }
      }


      int annee = 0;
      saisieValide = false;
      while (!saisieValide) {
        try {
          System.out.print("Entrez l'annC)e de la transaction: ");
          annee = scanner.nextInt();
          saisieValide = true;
          if (annee > 2030 || annee < 2010) {
            System.out.println("Saisie incorrecte, veuillez inserer un chiffre entre ou egal a 2010 et 2030");
            saisieValide = false;
          }
        } catch (InputMismatchException e) {
          System.out.println("La saisie est incorrecte. Veuillez saisir une valeur numC)rique valide.");
          scanner.next();
        }
      }


      boolean type = false;
      saisieValide = false;
      while (!saisieValide) {
        try { // Verification que c'est bien un chiffre qui est introduit
          System.out.print("Entrez le type de la transaction (1 pour vente / 0 pour location): ");
          int x = scanner.nextInt();
          saisieValide = true;
          if (x == 1) { // Verification que c'est soit un 1 soit un 0 qui est introduit
            type = true;
          } else {
            if (x == 0) {
              type = false;
            } else {
              saisieValide = false;
              System.out.println("Veuillez saisir soit un 1 soit un 0!");
            }
          }
        } catch (InputMismatchException e) {
          System.out.println("La saisie est incorrecte. Veuillez saisir une valeur booleenne.");
          scanner.next();
        }
      }
      
     
     boolean etat = false;
      saisieValide = false;
      while (!saisieValide) {
        try { // Verification que c'est bien un chiffre qui est introduit
          System.out.print("Entrez l'etat de la transaction (1 effectuee / 0 non effectuee): ");
          int x = scanner.nextInt();
          saisieValide = true;
          if (x == 1) { // Verification que c'est soit un 1 soit un 0 qui est introduit
            etat = true;
          } else {
            if (x == 0) {
              etat = false;
            } else {
              saisieValide = false;
              System.out.println("Veuillez saisir soit un 1 soit un 0!");
            }
          }
        } catch (InputMismatchException e) {
          System.out.println("La saisie est incorrecte. Veuillez saisir une valeur booleenne.");
          scanner.next();
        }
      }



      int id_proprietaire = 0;
      saisieValide = false;
      while (!saisieValide) {
        try {
          System.out.print("Entrez l'ID du propriC)taire: ");
          id_proprietaire = scanner.nextInt();
          saisieValide = true;
          if (id_proprietaire < 0) {
            System.out.println("Saisie incorrecte, veuillez inserer un chiffre positif");
            saisieValide = false;
          }
        } catch (InputMismatchException e) {
          System.out.println("La saisie est incorrecte. Veuillez saisir une valeur numC)rique valide.");
          scanner.next();
        }
      }



      int id_clientele = 0;
      saisieValide = false;
      while (!saisieValide) {
        try {
          System.out.print("Entrez l'ID de la clientC(le: ");
          id_clientele = scanner.nextInt();
          saisieValide = true;
          if (id_clientele < 0) {
            System.out.println("Saisie incorrecte, veuillez inserer un chiffre positif");
            saisieValide = false;
          }
        } catch (InputMismatchException e) {
          System.out.println("La saisie est incorrecte. Veuillez saisir une valeur numC)rique valide.");
          scanner.next();
        }
      }



      double somme = 0;
      saisieValide = false;
      while (!saisieValide) {
        try {
          System.out.print("Entrez la somme de la transaction: ");
          somme = scanner.nextDouble();
          saisieValide = true;
          if (somme < 0) { // La somme ne peut pas etre negative
            System.out.println("Saisie incorrecte, veuillez inserer un chiffre positif");
            saisieValide = false;
          }
        } catch (InputMismatchException e) {
          System.out.println("La saisie est incorrecte. Veuillez saisir une valeur numC)rique valide.");
          scanner.next();
        }
      }
      
      Node newNode =new Node(jour, mois, annee, type, id_proprietaire, id_clientele,++size, somme, etat);
      if (head == null) {
        head = newNode;
      } else {
        Node current = head;
        while (current.getNext() != null) {
          current = current.getNext();
        }
        current.setNext(newNode);
      }
      boolean choixValide = false;
      while (!choixValide) { // On reste dans le while si on doit entrer une autre transaction
        System.out.print("Voulez-vous ajouter une autre transaction ? (oui/non): ");;
        String choix = scanner.next();
        if (choix.equalsIgnoreCase("oui")) {
          continuer = true;
          choixValide = true;
        } else if (choix.equalsIgnoreCase("non")) {
          continuer = false;
          choixValide = true;
        } else {
          System.out.println("Veuillez répondre par 'oui' ou 'non'.");
        }
      }
    }
  }
  
  // Methode contrat qui genere un contrat
  // Certains champs du contrat devrons etre remplis apres l'impression
  void contrat() {
    System.out.println("Selection de la generation du contrat");
    boolean saisieValide = false;
    int idTransactionRechercher = 0;
    Scanner scanner = new Scanner(System.in); // DC)claration de scanner ici
    while (!saisieValide) {
      try { // Verification que l'id saisi est du bon type
        System.out.print("Entrez l'identifiant de la transaction: ");
        idTransactionRechercher = scanner.nextInt(); // Correction du nom de variable
        saisieValide = true;
      } catch (InputMismatchException e) {
        System.out.println("La saisie est incorrecte. Veuillez saisir une valeur numérique valide.");
        scanner.next();
      }
    }
    Node transaction = rechercher(idTransactionRechercher);
    System.out.println("Je sousigne __________________ m'engage a payer la Somme de: " +
      Transactions.customFormat("###,###,###,###,###",transaction.getsomme()) // Utilisation de customFormat
      + "de Dinars ");System.out.print((transaction.isType() ? "" : " par mois, "));
    System.out.print("pour " +(transaction.isType() ? "l'achat" : " la location"));
    System.out.println("de la propriete immobiliere de Mr/Mme ____________________. ");
    System.out.println(" Acte Le: " + transaction.getJour() + "/" +transaction.getMois() + "/" + transaction.getAnnee());
    System.out.println("Signature du proprietaire        x");
    System.out.println("Signature du client        x");
  }
  
  
  // Methode pour rechercher une transaction par son id_transaction
  Node rechercher(int id_transaction) {
    Node current = head;
    while (current != null) {
      if (current.getId_transaction() == id_transaction) {
        return current;
      }
      current = current.getNext();
    }
    return null;
  }
  
  
   // Methode pour modifier un parametre d'une transaction.
  void modifier() {
    System.out.println("Selection de la modification d'une transaction:");
    boolean continuer = true;
    while (continuer) { // premier while pour reacceder a modifier
      boolean continuer2 = true;
      boolean saisieValide = false;
      int idTransactionRechercher = 0;
      Scanner scanner = new Scanner(System.in);
      while (!saisieValide) {
        try {
          System.out.print("Entrez l'identifiant de la transaction: ");
          idTransactionRechercher = scanner.nextInt(); // Correction du nom de variable
          saisieValide = true;
        } catch (InputMismatchException e) {
          System.out.println("La saisie est incorrecte. Veuillez saisir une valeur numérique valide.");
          scanner.next();
        }
      }
      Node transaction = rechercher(idTransactionRechercher);
      while (continuer2) { //deuxieme while pour modifier un parametre de la meme transaction de nouveau
        if (transaction != null) {
          System.out.println("Quel attribut voulez-vous modifier ?");
          System.out.println("0. Exit");
          System.out.println("1. Jour");
          System.out.println("2. Mois");
          System.out.println("3. Annee");
          System.out.println("4. Type");
          System.out.println("5. ID Proprietaire");
          System.out.println("6. ID Clientele");
          System.out.println("7. Somme");
          System.out.println("8. Etat");
          boolean verifier = false;
          int choix = 0;
          while (verifier == false) {
            try {
              choix = scanner.nextInt();
              verifier = true;
              if(choix<0 || choix>8){
                  verifier = false;
                  System.out.println("Veuillez inserer une valeur entre ou egale a 0 et 7");
              }
            } catch (InputMismatchException e) {
              System.out.println("La saisie est incorrecte. Veuillez saisir une valeur numérique valide entre ou egale a 0 et 7.");
              scanner.next();
            }
          }
          switch (choix) { // On reintroduit les memes conditions que pour la focntin ajouter
            case 0:
              break;
            case 1:
              int jour = 0;
              saisieValide = false;
              while (!saisieValide) {
                try {
                  System.out.print("Entrez le nouveau jour de la transaction: ");
                  jour = scanner.nextInt();
                  saisieValide = true;
                  if (jour > 32 || jour < 1) {
                    System.out.println("Saisie incorrecte, veuillez inserer un chiffre entre ou egal a 1 et 31");
                    saisieValide = false;
                  }
                } catch (InputMismatchException e) {
                  System.out.println("La saisie est incorrecte. Veuillez saisir une valeur numC)rique valide.");
                  scanner.next();
                }
              }
              transaction.setJour(jour);
              break;
            case 2:
              int mois = 0;
              saisieValide = false;
              while (!saisieValide) {
                try {
                  System.out.print("Entrez le mois de la transaction: ");
                  mois = scanner.nextInt();
                  saisieValide = true;
                  if (mois > 12 || mois < 1) {
                    System.out.println("Saisie incorrecte, veuillez inserer un chiffre entre ou egal a 1 et 12");
                    saisieValide = false;
                  }
                } catch (InputMismatchException e) {
                  System.out.println("La saisie est incorrecte. Veuillez saisir une valeur numC)rique valide.");
                  scanner.next();
                }
              }
              transaction.setMois(mois);
              break;
            case 3:
              int annee = 0;
              saisieValide = false;
              while (!saisieValide) {
                try {
                  System.out.print("Entrez l'annC)e de la transaction: ");
                  annee = scanner.nextInt();
                  saisieValide = true;
                  if (annee > 2030 || annee < 2010) {
                    System.out.println("Saisie incorrecte, veuillez inserer un chiffre entre ou egal a 2010 et 2030");
                    saisieValide = false;
                  }
                } catch (InputMismatchException e) {
                  System.out.println("La saisie est incorrecte. Veuillez saisir une valeur numC)rique valide.");
                  scanner.next();
                }
              }
              transaction.setAnnee(annee);
              break;
            case 4:
              boolean type = false;
              saisieValide = false;
              while (!saisieValide) {
                try {
                  System.out.print("Entrez le type de la transaction (1 pour vente / 0 pour location): ");
                  int x = scanner.nextInt();
                  saisieValide = true;
                  if (x == 1) {
                    type = true;
                  } else {
                    if (x == 0) {
                      type = false;
                    } else {
                      saisieValide = false;
                      System.out.println("Veuillez saisir soit un 1 soit un 0!");
                    }
                  }
                } catch (InputMismatchException e) {
                  System.out.println("La saisie est incorrecte. Veuillez saisir une valeur booleenne.");
                  scanner.next();
                }
              }
              transaction.setType(type);
              break;
            case 5:
              int id_proprietaire = 0;
              saisieValide = false;
              while (!saisieValide) {
                try {
                  System.out.print("Entrez l'ID du propriC)taire: ");
                  id_proprietaire = scanner.nextInt();
                  saisieValide = true;
                  if (id_proprietaire < 0) {
                    System.out.println("Saisie incorrecte, veuillez inserer un chiffre positif");
                    saisieValide = false;
                  }
                } catch (InputMismatchException e) {
                  System.out.println("La saisie est incorrecte. Veuillez saisir une valeur numC)rique valide.");
                  scanner.next();
                }
              }
              transaction.setId_proprietaire(id_proprietaire);
              break;
            case 6:
              int id_clientele = 0;
              saisieValide = false;
              while (!saisieValide) {
                try {
                  System.out.print("Entrez l'ID de la clientele: ");
                  id_clientele = scanner.nextInt();
                  saisieValide = true;
                  if (id_clientele < 0) {
                    System.out.println("Saisie incorrecte, veuillez inserer un chiffre positif");
                    saisieValide = false;
                  }
                } catch (InputMismatchException e) {
                  System.out.println("La saisie est incorrecte. Veuillez saisir une valeur numC)rique valide.");
                  scanner.next();
                }
              }
              transaction.setId_clientele(id_clientele);
              break;
            case 7:
              double somme = 0;
              saisieValide = false;
              while (!saisieValide) {
                try {
                  System.out.print("Entrez la somme de la transaction: ");
                  somme = scanner.nextDouble();
                  saisieValide = true;
                  if (somme < 0) {
                    System.out.println("Saisie incorrecte, veuillez inserer un chiffre positif");
                    saisieValide = false;
                  }
                } catch (InputMismatchException e) {
                  System.out.println("La saisie est incorrecte. Veuillez saisir une valeur numC)rique valide.");
                  scanner.next();
                }
              }
              transaction.setsomme(somme);
              break;
            case 8:
              boolean etat = false;
              saisieValide = false;
              while (!saisieValide) {
                try {
                  System.out.print("Entrez l'etat de la transaction (1  effectuee / 0 non effectuee): ");
                  int y = scanner.nextInt();
                  saisieValide = true;
                  if (y == 1) {
                    etat = true;
                  } else {
                    if (y == 0) {
                      etat = false;
                    } else {
                      saisieValide = false;
                      System.out.println("Veuillez saisir soit un 1 soit un 0!");
                    }
                  }
                } catch (InputMismatchException e) {
                  System.out.println("La saisie est incorrecte. Veuillez saisir une valeur booleenne.");
                  scanner.next();
                }
              }
              transaction.setEtat(etat);
              break;
            default:
              System.out.println("Choix invalide.");
              return;
          }
          System.out.println("Modification effectuee avec succes");
        } else {
          System.out.println("Modification non effectuee, aucune transaction ne correspond a l'identifiant fourni");
          return;
        }
        boolean choixValide = false;
        while (!choixValide) { // Second while
          System.out.print("Voulez-vous modifier la meme transaction ? (oui/non): ");;
          String choix = scanner.next();
          if (choix.equalsIgnoreCase("oui")) {
            continuer2 = true;
            choixValide = true;
          } else if (choix.equalsIgnoreCase("non")) {
            continuer2 = false;
            choixValide = true;
          } else {
            System.out.println("Veuillez répondre par 'oui' ou 'non'.");
          }
        }
      }
      boolean choixValide = false;
      while (!choixValide) { // Premier while
        System.out.print("Voulez-vous modifier une autre transaction ? (oui/non): ");;
        String choix = scanner.next();
        if (choix.equalsIgnoreCase("oui")) {
          continuer = true;
          choixValide = true;
        } else if (choix.equalsIgnoreCase("non")) {
          continuer = false;
          choixValide = true;
        } else {
          System.out.println("Veuillez répondre par 'oui' ou 'non'.");
        }
      }
    }
  }
  
  
  // Methode pour supprimer une transaction par son id_transaction
  // Tres similaire a la methode supprimer de Agent_Immobilier
  void supprimer() {
    System.out.println("SC)lection de la suppression d'une transaction:");
    boolean saisieValide = false;
    int idTransactionRechercher = 0;
    Scanner scanner = new Scanner(System.in);
    while (!saisieValide) {
      try {
        System.out.print("Entrez l'identifiant de la transaction: ");
        idTransactionRechercher = scanner.nextInt(); 
        saisieValide = true;
      } catch (InputMismatchException e) {
        System.out.println("La saisie est incorrecte. Veuillez saisir une valeur numérique valide.");
        scanner.next();
      }
    }
    if (head == null) {
      System.out.println("Suppression non effectuC)e, liste vide");
      return;
    }
    if (head.getId_transaction() == idTransactionRechercher) {
      head = head.getNext();
      size--;
      System.out.println("Suppression effectuee avec succes");
      return;
    }
    Node current = head;
    while (current.getNext() != null) {
      if (current.getNext().getId_transaction() ==
        idTransactionRechercher) {
        if (current.getNext().getNext() == null) {
          current.setNext(null);
        } else {
          current.setNext(current.getNext().getNext());
        }
        size--;
        System.out.println("Suppression effectuee avec succes");
        return;
      }
      current = current.getNext();
    }
    System.out.println("Suppression non effectuee, aucune transaction avec l'id fourni n'existe");
  }
  
  
  // Methode pour afficher une transaction
  void afficherTransaction() {
    System.out.println("Selection de l'affichage d'une transaction:");
      boolean saisieValide = false;
      int idTransactionRechercher = 0;
      Scanner scanner = new Scanner(System.in);
      while (!saisieValide) {
        try {
          System.out.print("Entrez l'identifiant de la transaction: ");
          idTransactionRechercher = scanner.nextInt(); // Correction du nom de variable
          saisieValide = true;
        } catch (InputMismatchException e) {
          System.out.println("La saisie est incorrecte. Veuillez saisir une valeur numérique valide.");
          scanner.next();
        }
      }
      
    Node transaction = rechercher(idTransactionRechercher);
    System.out.println("ID Transaction: " +
      transaction.getId_transaction());
    System.out.println("Date: " + transaction.getJour() + "/" +
      transaction.getMois() + "/" +
      transaction.getAnnee());
    System.out.println("Type: " +
      (transaction.isType() ? "Vente" : "Location"));
    System.out.println("ID Proprietaire: " +
      transaction.getId_proprietaire());
    System.out.println("ID Clientele: " + transaction.getId_clientele());
    System.out.println("Somme transaction: " +
      Transactions.customFormat("###,###,###,###",transaction.getsomme()));
    System.out.println("Etat: " +
      (transaction.isEtat() ? "Transaction effectuee" : "Transaction non effectuee"));
    System.out.println("-----------------------------------------");
  }
  
  
  // Methode pour afficher toutes les transactions de la liste
  void afficherTransactions() {
    System.out.
    println("SC)lection de l'affichage de toutes les transactions:");
    Node transaction = head;
    while (transaction != null) {
      System.out.println("ID Transaction: " +
        transaction.getId_transaction());
      System.out.println("Date: " + transaction.getJour() + "/" +
        transaction.getMois() + "/" +
        transaction.getAnnee());
      System.out.println("Type: " +
        (transaction.isType() ? "Vente" : "Location"));
      System.out.println("ID Proprietaire: " +
        transaction.getId_proprietaire());
      System.out.println("ID Clientele: " +
        transaction.getId_clientele());
      System.out.println("Somme transaction: " +
        Transactions.customFormat("###,###,###,###",
          transaction.getsomme()));
      System.out.println("Etat: " +
      (transaction.isEtat() ? "Transaction effectuee" : "Transaction non effectuee"));
      System.out.println("-----------------------------------------");
      transaction = transaction.getNext();
    }
  }
  
  
   // La methode menu la plus importante
  void Menu() {

    if (this.size == 0) { // On initialise la liste et la remplis avec quelques transactions
      Initialisercomp();
    }
    Scanner scanner = new Scanner(System.in);
    int choix = 0;
    boolean continuer = true;
    while (continuer) {
      System.out.println("À quelle fonction voulez-vous accéder ?");
      System.out.println("0. Exit");
      System.out.println("1. Ajout");
      System.out.println("2. Suppression");
      System.out.println("3. Modification");
      System.out.println("4. Affichage");
      System.out.println("5. Contrat");
      boolean verifier = false;
      while (verifier == false) {
        try {
          choix = scanner.nextInt();
          verifier = true;
        } catch (InputMismatchException e) {
          System.out.println("La saisie est incorrecte. Veuillez saisir une valeur numérique valide entre ou egale a 0 et 7.");
          scanner.next();
        }
      }
      switch (choix) {
        case 0:
          break;
        case 1:
          ajouter();
          break;
        case 2:
          supprimer();
          break;
        case 3:
          modifier();
          break;
        case 4:
          int choix2 = 0;
          System.out.println("Voulez vous afficher toutes les transactions ou une seule transaction? (0 pour toutes/ 1 pour une seule)");
          boolean retourne = false;
          while (!retourne) {
            try {
              choix2 = scanner.nextInt();
              retourne = true;
              if (choix2 == 1) {} else {
                if (choix2 == 0) {} else {
                  retourne = false;
                  System.out.println("Veuillez saisir soit un 1 soit un 0!");
                }
              }
            } catch (InputMismatchException e) {
              System.out.println("La saisie est incorrecte. Veuillez saisir une valeur numérique valide entre ou egale a 0 et 7.");
              scanner.next();
            }
            if (choix2 == 0) {
              afficherTransactions();
            } else {
              afficherTransaction();
            }
          }
          break;
        case 5:
          contrat();
          break;
        default:
          System.out.println("Choix invalide.");
      }
      boolean choixValide = false;
      while (!choixValide) {
        System.out.print("Voulez-vous de nouveau acceder au menu des transactions ? (oui/non): ");;
        String choix2 = scanner.next();
        if (choix2.equalsIgnoreCase("oui")) {
          continuer = true;
          choixValide = true;
        } else if (choix2.equalsIgnoreCase("non")) {
          continuer = false;
          choixValide = true;
        } else {
          System.out.println("Veuillez répondre par 'oui' ou 'non'.");
        }
      }
    }
    System.out.println("Sortie du systeme de gestion des transactions");
  }
}
