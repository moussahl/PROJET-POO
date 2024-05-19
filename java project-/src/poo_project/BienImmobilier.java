
/* realise par HALOUI Moussa */
package poo_project;

import java.util.Scanner;
import java.lang.Exception;

public class BienImmobilier {
  private static int id = 1;
  private int id_bien;
  private String type;
  private double taille;
  private double prix;
  private Localisation localisation;
  private String service;
  private String description;
  private double prix_totale;
  private int agent_respo;
  ;
  //Getters and setters
 

  public int getId_bien() {
    return id_bien;
  }
  public void setId_bien() {
    id_bien = id++;
  }

  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }

  public double getTaille() {
    return taille;
  }
  public void setTaille(double taille) {
    this.taille = taille;
  }

  public double getPrix() {
    return prix;
  }
  public void setPrix(double prix) {
    this.prix = prix;
  }

  public Localisation getLocalisation() {
    return localisation;
  }
  public void setlocalisation(Scanner scan) {
    this.localisation = new Localisation();
    this.localisation.setWilaya(scan.nextLine());
    this.localisation.setVille(scan.nextLine());
    this.localisation.setRue(scan.nextLine());
  }

  public String getService() {
    return service;
  }
  public void setService(String service) {
    this.service = service;
  }

  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  public void setPrix_totale(double prix_totale) {
    this.prix_totale = prix_totale;
  }
  public double getPrix_totale() {
    return prix_totale;
  }

  public int getAgent_respo() {
    return agent_respo;
  }
  public void setAgent_respo(int agent_respo) {
    this.agent_respo = agent_respo;
  }

  //implicite constructer
  public BienImmobilier() {}
  //------------------------------------------------------
  //insert type method
  public void insert_type(Scanner scan) {
    int type;
    do {
      System.out.println("Precise le type d'imobilier");
      System.out.println("1 : pour type Appartement ");
      System.out.println("2 : pour type Villa  ");
      System.out.println("3 : pour type Terrin ");
      type = scan.nextInt();
    } while (type < 1 || type > 3);
    switch (type) {
      case 1:
        this.type = "Appartement";
        break;
      case 2:
        this.type = "Villa";
        break;
      case 3:
        this.type = "Terrin";
        break;
      default:
        break;
    }
  }
  /* --------------------------------------------------------------------    */
  //insert taille method
  public void insert_taille(Scanner scan) {
    do {
      System.out.println("donner la taille de votre immobilier");
      this.taille = scan.nextDouble();
    } while (this.taille < 0);
    //scan.close();
  }
  /* ------------------------------------------------------------------------ */
  //insert prix method
  public void insert_prix(Scanner scan) {
    do {
      System.out.println("Donner le prix de m2 pour votre immobilier");
      this.prix = scan.nextInt();
    } while (this.prix < 0);
  }
  /* ------------------------------------------------------------------------ */
  // insert locaisation method
  public void insert_localisation(Scanner scan) {
    System.out.println("donner la wilaya");
    String wilaya = scan.nextLine();
    System.out.println("donner la ville");
    String ville = scan.nextLine();
    System.out.println("donner la rue");
    String rue = scan.nextLine();
    this.localisation = new Localisation(wilaya, ville, rue);
  }
  /* --------------------------------------------------- */
  // insert service method
  public void insert_service(Scanner scan) {
    int service;
    do {
      System.out.println("inserer votre sevice");
      System.out.println("1 : Pour vente");
      System.out.println("2 : Pour location");
      service = scan.nextInt();
    } while (service != 1 && service != 2);
    if (service == 1) this.service = "Vente";
    else this.service = "Location";
  }
  /* --------------------------------------------------- */
  // insert description method
  public void insert_descrition(Scanner scan) {
    System.out.println("dooner votre description");
    this.description = scan.nextLine();
  }
  /* --------------------------------------------------- */
  // calcule prix totale method
  public void calcule_prix_totale() {
    prix_totale = prix * taille;
  }
  /* --------------------------------------------------- */
  // insert agent reposable method
  public void insert_agent_respo(Scanner scan) {
    do {
      System.out.println("dooner l'id d'agent respo ");
      this.agent_respo = scan.nextInt();
    }
    while (this.agent_respo <= 0);
  }

  /* ---------------------------------------------------------- */
  // toString method
  @Override
  public String toString() {
    return "[BienImmobilier : id_bien=" + id_bien + ", type=" + type + ", taille=" + taille + ", prix du m2=" + prix +
      ", le prix totale=" + prix_totale + ", localisation=" + localisation + ", service=" + service + ", description=" +
      description + "]";
  }
  /* ------------------------------------------------ */
  // all previous insert methods with try catch
  public void try_insert_type(Scanner scan) {
    boolean bool = false;
    do {
      try {
        insert_type(scan);
        bool = true;
      } catch (Exception e) {
        System.out.println("try again");
        scan.next();
      }
    } while (!bool);
  }
  public void try_insert_taille(Scanner scan) {
    boolean bool = false;
    do {
      try {
        insert_taille(scan);
        bool = true;
      } catch (Exception e) {
        System.out.println("try again");
        scan.next();
      }
    }
    while (!bool);
  }
  public void try_insert_prix(Scanner scan) {
    boolean bool = false;
    do {
      try {
        insert_prix(scan);
        bool = true;
      } catch (Exception e) {
        System.out.println("try again");
        scan.next();
      }
    }
    while (!bool);
  }
  public void try_insert_service(Scanner scan) {
    boolean bool = false;
    do {
      try {
        insert_service(scan);
        bool = true;
      } catch (Exception e) {
        System.out.println("try again");
        scan.next();
      }
    }
    while (!bool);
  }
  public void try_insert_agent_respo(Scanner scan) {
    boolean bool = false;
    do {
      try {
        insert_agent_respo(scan);
        bool = true;
      } catch (Exception e) {
        System.out.println("try again");
        scan.next();
      }
    }
    while (!bool);
  }
}
