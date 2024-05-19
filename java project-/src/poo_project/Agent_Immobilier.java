

/* realise par DEHILI Mehdi */

package poo_project;
import java.util.Scanner;
import java.text.*; // Pour la methode customFormat
import java.util.InputMismatchException; // Pour verifier que le bon type est insere 

class Agent_Immobilier {
  public static class Node { // Un element de la liste chainee
    private int id; // Identifiant de l'agent
    private double salaire; // Salaire de l'agent
    private int Telephone; // Numero de telephone de l'agent
    private String Nom; // Nom de l'agent
    private String Prenom; // Prenom de l'agent
    private String EMail; // Adresse mail de l'agent
    private Node next; // Adresse du prochain element de la liste chainee
    Node(int id, double salaire, int Telephone, String Nom, String Prenom,String EMail) { // Constructeur de Node
      this.id = id;
      this.salaire = salaire;
      this.Telephone = Telephone;
      this.Nom = Nom;
      this.Prenom = Prenom;
      this.EMail = EMail;
      this.next = null;
    }
    // Getters et setters pour tout les parametres de Node
    int getTelephone() {
      return Telephone;
    }
    void setTelephone(int Telephone) {
      this.Telephone = Telephone;
    }
    String getNom() {
      return Nom;
    }
    void setNom(String Nom) {
      this.Nom = Nom;
    }
    String getPrenom() {
      return Prenom;
    }
    void setPrenom(String Prenom) {
      this.Prenom = Prenom;
    }
    String getEMail() {
      return EMail;
    }
    void setEMail(String EMail) {
      this.EMail = EMail;
    }
    int getId() {
      return id;
    }
    void setId(int id) {
      this.id = id;
    }
    double getSalaire() {
      return salaire;
    }
    void setSalaire(double salaire) {
      this.salaire = salaire;
    }
    Node getNext() {
      return next;
    }
    void setNext(Node next) {
      this.next = next;
    }
  } // Fin de la classe Node
  // Continuation de la classe Agent_Immobilier
  private Node head; // Tete de la liste chainee
  private int size; // Longueur de la liste utilisee pour les id
  Agent_Immobilier() { // Constructeur de la classe Agent_Immobilier
    this.head = null;
    this.size = 0;
  }
  // Cette methode va creer un nouvel element dans la liste. 
  public void Initialiser(double salaire, int Telephone, String Nom, String Prenom, String EMail) {
    Node newNode = new Node(++size, salaire, Telephone, Nom, Prenom, EMail);
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
  public void Initialisercomp() { // Utilise la fonction ci-dessus pour ajouter des agents 
                                 //a la liste juste apres sa creation
    Initialiser(120000, 652487965, "Dehili", "Mehdi", "DehMeh@gmail.com");
    Initialiser(110000, 647260165, "Haloui", "Moussa", "HalMous@gmail.com");
    Initialiser(142000, 628716087, "Boussaidi", "Raouf", "BouRaouf@gmail.com");
    Initialiser(125000, 694589709, "", "Anis", "Anis@gmail.com");
  }
  static public String customFormat(String pattern, double value) { // Permet de choisir un format d'affichage
    DecimalFormat myFormatter = new DecimalFormat(pattern);
    String output = myFormatter.format(value);
    return output;
  }
  public void ajouter() { // Permet d'ajouter un noeud a la liste
    System.out.println("Selection de l'ajout d'un agent:");
    Scanner scanner = new Scanner(System.in);
    boolean continuer = true;
    while (continuer) { // Premiere boucle while pour verifier si l'utilisateur veut introduire un autre agent 
                       // lorcequ'il a finit la saisie
      double salaire = 0; // Initialisation de salaire en dehors de la boucle(iportant)
      int telephone = 0; // Initialisation de telephone en dehors de la boucle (important)
      boolean saisieValide = false;
      while (!saisieValide) { // deuxieme while pour reintroduire la valeur tant que le type est errone
        try { // Verification que la saisie d el'utilisateur est du bon type
          System.out.print("Entrez le salaire de l'agent: ");
          salaire = scanner.nextDouble();
          saisieValide = true; // on sort de la boucle si le type est valide
        } catch (InputMismatchException e) {
          System.out.println("La saisie est incorrecte. Veuillez saisir une valeur numérique valide.");
          scanner.next();
        }
      }
      saisieValide = false;
      while (!saisieValide) { //Meme commentaires que pour le try catch ci-dessus
        try {
          System.out.print("Entrez le numéro de téléphone de l'agent: ");
          telephone = scanner.nextInt();
          saisieValide = true;
        } catch (InputMismatchException e) {
          System.out.println("La saisie est incorrecte. Veuillez saisir une valeur numérique valide.");
          scanner.next();
        }
      }
      System.out.print("Entrez le nom de l'agent: ");
      String nom = scanner.next();
      System.out.print("Entrez le prénom de l'agent: ");
      String prenom = scanner.next();
      System.out.print("Entrez l'e-mail de l'agent: ");
      String email = scanner.next();
      Node newNode = new Node(++size, salaire, telephone, nom, prenom, email); // Creation du nouveau noeud
      if (head == null) { // le noeud devient la tete de la liste si elle est vide
        head = newNode;
      } else {
        Node current = head;
        while (current.getNext() != null) { // Sinon on parcourt la liste jusqu'a trouer le dernier noeud
          current = current.getNext();
        }
        current.setNext(newNode); // On lie le dernier noeud et le nouveau
      } // Fin de l'ajout
      boolean choixValide = false;
      while (!choixValide) { // Derniere boucle while qui demande si on veut ajouter un autre agent ou non
        System.out.print("Voulez-vous ajouter un autre agent ? (oui/non): ");
        String choix = scanner.next();
        if (choix.equalsIgnoreCase("oui")) { // Si oui
          continuer = true; // On ne sort pas du premier while
          choixValide = true;
        } else if (choix.equalsIgnoreCase("non")) {
          continuer = false; // Si non on en sort
          choixValide = true;
        } else { // Si on introduit autre chose que oui ou non on ne sort pas du while ci-dessus
          System.out.println("Veuillez répondre par 'oui' ou 'non'.");
        }
      }
    }
  } // Fin de la methode
  
  
  // Methode pour rechercher un agent par son id elle retourne le noeud recherche
  Node rechercher(int id) {
    Node current = head;
    while (current != null) {
      if (current.getId() == id) {
        return current;
      }
      current = current.getNext();
    }
    return null;
  }
  
  
  // Methode pour rechercher un agent par son nom ou prenom
  Node rechercher(String Nom) {
    Node current = head;
    while (current != null) {
      if ((current.getPrenom() == Nom) && (current.getNom() == Nom)) {
        return current;
      }
      current = current.getNext();
    }
    return null;
  }
  
  
  // Methode pour modifier un parametre d'un agent
  void modifier() {
    System.out.println("Selection de la modification d'un agent:");
    boolean continuer = true;
    while (continuer) { // Premier while au cas ou l'utilisateur veut modifier un parametre un autre agent
                        // A la fin de cette modification
      boolean continuer2 = true;
      boolean saisieValide = false;
      int IdRechercher = 0;
      int choix2 = 0;
      Scanner scanner = new Scanner(System.in); // Declaration de scanner et autres variables en dehors de leur while
      while (!saisieValide) {
        try { // Verification que le caractere saisi est bien de type int
          System.out.print("Entrez l'identifiant de l'agent: ");
          IdRechercher = scanner.nextInt(); // Correction du nom de variable
          saisieValide = true;
        } catch (InputMismatchException e) {
          System.out.println("La saisie est incorrecte. Veuillez saisir une valeur numérique valide.");
          scanner.next();
        }
      }
      Node agent = rechercher(IdRechercher); 
      while (continuer2) { // deuxieme while au cas ou l'utilisateur veut modifier un parametre du meme agent
        if (agent != null) {
          System.out.println("Quel paramC(tre voulez-vous modifier ?");
          System.out.println("0. Exit");
          System.out.println("1. Salaire");
          System.out.println("2. TC)lC)phone");
          System.out.println("3. Nom");
          System.out.println("4. PrC)nom");
          System.out.println("5. E-mail");
          saisieValide = false;
          while (!saisieValide) {
            try { // Verification que le choix2 insere est bien de type int
              choix2 = scanner.nextInt();
              saisieValide = true;
              if (choix2>5 || choix2<0) { // Verification que choix2 est bien une option valide
                                          // Il est important de mettre le if apres saisievalide = true
                  saisieValide = false; 
                  System.out.println("Veuillez saisir une valeur entre ou egale a 0 et 5"); }
            } catch (InputMismatchException e) {
              System.out.println("La saisie est incorrecte. Veuillez saisir une valeur numérique valide.");
              scanner.next();
            }
          }
          switch (choix2) {
            case 0:
              break;
            case 1:
              double nouveauSalaire = 0;
              saisieValide = false;
              while (!saisieValide) { // Verification des type comme dans la fonction ajouter
                try {
                  System.out.print("Entrez le nouveau salaire de l'agent: ");
                  nouveauSalaire = scanner.nextInt();
                  saisieValide = true;
                } catch (InputMismatchException e) {
                  System.out.println("La saisie est incorrecte. Veuillez saisir une valeur numérique valide.");
                  scanner.next();
                }
              }
              agent.setSalaire(nouveauSalaire);
              break;
            case 2:
              int nouveauTelephone = 0;
              saisieValide = false;
              while (!saisieValide) {
                try {
                  System.out.print("Entrez le nouveau numC)ro de tC)lC)phone: ");
                  nouveauTelephone = scanner.nextInt();
                  saisieValide = true;
                } catch (InputMismatchException e) {
                  System.out.println("La saisie est incorrecte. Veuillez saisir une valeur numérique valide.");
                  scanner.next();
                }
              }
              agent.setTelephone(nouveauTelephone);
              break;
            case 3:
              System.out.print("Entrez le nouveau nom: ");
              String nouveauNom = scanner.next();
              agent.setNom(nouveauNom);
              break;
            case 4:
              System.out.print("Entrez le nouveau prC)nom: ");
              String nouveauPrenom = scanner.next();
              agent.setPrenom(nouveauPrenom);
              break;
            case 5:
              System.out.print("Entrez le nouvel e-mail: ");
              String nouvelEMail = scanner.next();
              agent.setEMail(nouvelEMail);
              break;
            default:
              System.out.println("Choix invalide.");
              return;
          }
          System.out.println("Modification effectuee avec succes");
        } else { // si l'agent n'est pas trouve
          System.out.println("Modification non effectuee, aucun agent ne correspond a l'id fournit");
        }
        boolean choixValide = false;
        while (!choixValide) { // Meme principe que la demande dans ajouter
          System.out.print("Voulez-vous effectuer une autre modification au meme agent ? (oui/non): ");;
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
      while (!choixValide) { // Meme principe que la demande dans ajouter
        System.out.print("Voulez-vous effectuer une modification a un autre agent ? (oui/non): ");;
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
    return;
  } // Fin de la methode modifier
  
  
  // Methode pour supprimer un agent par son id
  void supprimer() {
    System.out.println("Selection de la suppression d'un agent:");
    boolean saisieValide = false;
    int IdRechercher = 0;
    Scanner scanner = new Scanner(System.in); // declaration de scanner et des variables
    while (!saisieValide) {
      try {
        System.out.print("Entrez l'identifiant de l'agent: ");
        IdRechercher = scanner.nextInt(); // Correction du nom de variable
        saisieValide = true;
      } catch (InputMismatchException e) {
        System.out.println("La saisie est incorrecte. Veuillez saisir une valeur numérique valide.");
        scanner.next();
      }
    }
    if (head == null) {
      System.out.println("Supression non effectuee, liste vide");
      return; // Quitter la mC)thode si la liste est vide
    }
    if (head.getId() == IdRechercher) { // Cas ou la tete contient l'element a supprimer
      head = head.getNext();
      size--;
      System.out.println("Supression effectuee avec succes");
      return; 
    }
    Node current = head;
    while (current.getNext() != null) {
      if (current.getNext().getId() == IdRechercher) {
        if (current.getNext().getNext() == null) { // Si l'element est le dernier de la liste
          current.setNext(null); 
        } else { // Si l'element n'est ni la tete ni le dernier de la liste
          current.setNext(current.getNext().getNext());
        }
        size--;
        System.out.println("Supression effectuee avec succes");
        return; 
      }
      current = current.getNext(); // Pour parcourir la liste
    }// Cas ou on ne retourne pas de la methode 
    System.out.println("Supression non effectuee, aucun element avec l'id fournit n'existe");
  }
  
  
  // Methode pour afficher un agent
  void afficherAgent() {
    System.out.println("Selection de l'affichage d'un agent:");
    boolean saisieValide = false;
    int IdRechercher = 0;
    Scanner scanner = new Scanner(System.in); // declaration de scanner et variables
    while (!saisieValide) {
      try {
        System.out.print("Entrez l'identifiant de l'agent: ");
        IdRechercher = scanner.nextInt(); 
        saisieValide = true;
      } catch (InputMismatchException e) {
        System.out.println("La saisie est incorrecte. Veuillez saisir une valeur numérique valide.");
        scanner.next();
      }
    }
    Node current = rechercher(IdRechercher);
    System.out.println("ID: " + current.getId() + ", Salaire: " +
    Agent_Immobilier.customFormat("###,###,###,###", current.getSalaire())); // Utilisation de customFormat
    // Pour que si le prix est grand l'affichage reste correcte
    System.out.println("Numero de telephone: 0" + current.getTelephone());
    System.out.println("Nom: " + current.getNom());
    System.out.println("Prenom: " + current.getPrenom());
    System.out.println("E-Mail: " + current.getEMail());
  }

 // Methode pour afficher tout les agents de la liste
  void afficherAgents() {
    System.out.println("Selection de l'affichage de tout les agents:");
    Node current = head;
    while (current != null) {
      System.out.println("ID: " + current.getId() + ", Salaire: " +
        Agent_Immobilier.customFormat("###,###,###,###", current.getSalaire()));
      System.out.println("Numero de telephone: 0" +
        current.getTelephone());
      System.out.println("Nom: " + current.getNom());
      System.out.println("Prenom: " + current.getPrenom());
      System.out.println("E-Mail: " + current.getEMail());
      System.out.
      println("-----------------------------------------------------");
      current = current.getNext();
    }
  }
  
  
   // Le menu est la methode la plus importante, elle donne l'acces a toutes les methodes de la classe et 
   // l'utilisateur choisir ce qu'il veut faire
  void Menu() {
    if (this.size == 0) {
      Initialisercomp();
    } // Ne lance Initialisercomp que la premiere fois qu'on lance le menu pour remplir la liste
    boolean continuer = true; // Si l'utilisateur veut reacceder au Menu apres avoir complete une tache
    Scanner scanner = new Scanner(System.in);
    int choix = 0;
    while (continuer) {
      boolean saisieValide = false;
      System.out.println("A quelle fonction voulez-vous acceder ?");
      System.out.println("0. Exit");
      System.out.println("1. Ajout");
      System.out.println("2. Supression");
      System.out.println("3. Modification");
      System.out.println("4. Affichage");
      while (!saisieValide) {
        try {
          choix = scanner.nextInt();
          saisieValide = true;
          if(choix<0 || choix>4){
              System.out.println("La saisie est incorrecte, veuillez saisir une valeur entre ou egale a 0 et 4");
          }
        } catch (InputMismatchException e) {
          System.out.println("La saisie est incorrecte. Veuillez saisir une valeur numérique valide.");
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
          System.out.
          println
            ("Voulez vous afficher tout les agents ou un seul agent? (0 pour plusieurs/ 1 pour un seul)");
          saisieValide = false;int choix2 = 0;   
          while (!saisieValide) { 
        try {
          choix2 = scanner.nextInt();
          saisieValide = true;
          if (choix2 == 0) {
            afficherAgents();
          } else {if(choix2==1){
            afficherAgent();
          }else{
              saisieValide = false; System.out.println("Veuillez introduire un 0 ou un 1");}}
          
        } catch (InputMismatchException e) {
          System.out.println("La saisie est incorrecte. Veuillez saisir une valeur numérique valide.");
          scanner.next();
        }
      }    
          if (choix2 == 0) {
            afficherAgents();
          } else {
            afficherAgent();
          }
          break;
        default:
          System.out.println("Choix invalide.");
          return;
      }
      boolean choixValide = false;
      while (!choixValide) {
        System.out.print("Voulez-vous acceder de nouveau au menu des agents ? (oui/non): ");
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
    System.out.println("Sortie du Menu de gestion des Agents Immobiliers.");
  }
}