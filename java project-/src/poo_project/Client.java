
/* realise par BOUSSAIDI Raouf */

package poo_project;


import java.util.LinkedList;
import java.util.Scanner;


public class Client {

		 private String nom;
		 private String prenom;
		 private String number_phone;
		 private int id_client ;
		 private static int id = 1;
		 private int Prix ;
		 private int budjet ;
		 private char type ;
		 private int Id_immobilier = -1 ; // pour si le type acheteur  intialiser -1
	

		  public static final LinkedList<Client > clients = new LinkedList<Client>();
		
	     public Client() {}
	     
	public Client(int id_client, String nom , String prenom , String number_phone ,char type ,  int budjet   , int Prix , int Id_immobilier ) 
	{
		this.id_client = id ;
		id ++ ;
		this.nom =nom;
		this.prenom = prenom ;
		this.number_phone =number_phone;
		this.type = type;
		this.Prix = Prix ;
		this.budjet = budjet ;
		this.Id_immobilier = Id_immobilier ;
		
	}

	public int getId_immobilier() {
		return Id_immobilier;
	}
	public void setId_immobilier(int id_immobilier) {
		Id_immobilier = id_immobilier;
	}
	public int getPrix() {
		return Prix;
	}

	public void setPrix(int Prix) {
		this.Prix = Prix;
	}

	public int getBudjet() {
		return budjet;
	}

	public void setBudjet(int budjet) {
		this.budjet = budjet;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNumber_phone() {
		return number_phone;
	}

	public void setNumber_phone(String number_phone) {
		this.number_phone = number_phone;
	}

	public int getId_client() {
		return id_client;
	}

public void setId_client(int id_client) {
		this.id_client = id_client;
	}

	
	

	
	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		Client.id = id;
	}

	public String EnterPhoneNumber() {
	      Scanner numb= new Scanner(System.in);
	      String number_phone = null;
	      boolean bool = false;
	      
	      while (!bool) {
	          number_phone = numb.nextLine();
	          
	          // Validez si le numéro de téléphone ne contient que des chiffres et comporte exactement 10 chiffres
	          if (number_phone.matches("[0-9]+") && number_phone.length() == 10) {
	              this.number_phone = number_phone;
	              bool = true;
	          } else {
	              System.out.println("le format de numero de telephone incorect s'il vous plait reentrer votre numero de telephone (10 Chiffres)");
	          }
	      }
		return number_phone;
		
	  }
	 
	 
	 private char choice;
	 Scanner scanner = new Scanner(System.in);
	 private boolean type_faux;	
	 
	 public void addClient() {
	       
		 do {
	        System.out.println("Veuillez entrer votre nom:");
	        String nom = scanner.nextLine();

	        System.out.println("Veuillez entrer votre prénom:");
	        String prenom = scanner.nextLine();

	        //Enter your phone number 
	        System.out.println("Enter votre  numero de telephone (10 Chiffres): ");
	        String numeroTelephone = EnterPhoneNumber();

	      do {
	    	    System.out.println("donne le type : A pour Acheteur, P pour propriétaire, T pour acheteur et proprietaire au meme temps ");
	      
	            type = Character.toUpperCase(scanner.next().charAt(0));
	            scanner.nextLine();

	            type_faux = (type == 'A' || type == 'P' || type == 'T' );
	        
	            if(!type_faux)
	            {System.out.println("Type invalide !!"); }
	        	
	          }while(!type_faux);
	        		           
	        
	        int budget = 0;
	        int Pris = 0;
           
	            // les informations de Acheteur 
	     
	        if (type == 'A' ) {        	
	        	  budget = exception("Veuillez entrer votre budget:");
	        	  
	            // les information de Proritaire 
	        } else if (type == 'P') {	          
	            Pris = exception("Veuillez entrer votre prix:");
	            Id_immobilier = exception("Entrez l'identifiant de votre immobilier (id) :");
            
	            // les informations les deux 
	        } else if (type == 'T') {	        	
	            budget = exception("Veuillez entrer votre budget:");	           
	            Pris = exception("Veuillez entrer votre prix:");
	            Id_immobilier = exception("Entrez l'identifiant de votre immobilier (id) :");
	            
	        }

	        Client Client = new Client(id_client,nom, prenom, numeroTelephone, type, budget, Pris,Id_immobilier);
	      
			clients.add(Client);

	        System.out.println("Person added successfully");
	      
	        System.out.println("Voulez-vous ajouter un autre client ? (O/N)");
	        choice = Character.toUpperCase(scanner.next().charAt(0));
	        scanner.nextLine();
	        
		  } while (choice == 'O');
	 }
	    

	 public void afficherClients() {
		 
		 if (clients.isEmpty()) {
		        System.out.println("La liste est vide, il n'existe aucun client.");
		        return;
		    }

		    System.out.println("Liste des clients :");
		    System.out.println("-------------------------------------");
		    for (Client client : clients) {
		    	
		        System.out.println("ID Client: " + client.getId_client());	       
		        System.out.println("Nom: " + client.getNom());
		        System.out.println("Prénom: " + client.getPrenom());
		        System.out.println("Numéro de téléphone: " + client.getNumber_phone());
		      //  System.out.println("Type: " + client.getType());
		        if (client.getType() == 'A' ) {
		            System.out.println("Type: Acheteur ");
		            System.out.println("Budget: " + client.getBudjet());
		        } else if (client.getType() == 'P' ) {
		            System.out.println("Type: propriétaire ");
		            System.out.println("Prix : " + client.getPrix());
		            System.out.println("Id_immobilier : " + client.getId_immobilier());
		        } else if (client.getType() == 'T' ) {
		            System.out.println("Type: Acheteur et  propriétaire");
		            System.out.println("Budget: " + client.getBudjet());
		            System.out.println("Prix: " + client.getPrix());
		            System.out.println("Id_immobilier : " + client.getId_immobilier());
		        }
		        System.out.println("-------------------------------------");
		    }
		}
	
	
	
	 public void afficher_Client(int idClient) {
		
		 System.out.println("-------------------------------------");
		    System.out.println("Liste des clients :");
		    boolean clientFound = false;
		    for (Client client : clients) {
		    	if (client.getId_client() == idClient) {
		    		 clientFound = true;
		        System.out.println("ID Client: " + client.getId_client());		       
		        System.out.println("Nom: " + client.getNom());
		        System.out.println("Prénom: " + client.getPrenom());
		        System.out.println("Numéro de téléphone: " + client.getNumber_phone());
		      
		        if (client.getType() == 'A') {
		            System.out.println("Type: Acheteur  ");
		            System.out.println("Budget: " + client.getBudjet());
		        } 
		        else if (client.getType() == 'P') {
		            System.out.println("Type: propriétaire ");
		            System.out.println("Prix: " + client.getPrix());
		            System.out.println("Id_immobilier : " + client.getId_immobilier());
		        }
		        else if (client.getType() == 'T') {
		            System.out.println("Type: Acheteur et propriétaire");
		            System.out.println("Budget: " + client.getBudjet());
		            System.out.println("Prix : " + client.getPrix());
		            System.out.println("Id_immobilier : " + client.getId_immobilier());
		        }
		         System.out.println("-------------------------------------");
		         return;
		    	 }  
		        
		    	}
		    if (!clientFound) {
		        System.out.println(" Désolé Le client avec l'ID " + idClient + " n'existe pas.");
		        System.out.println("-------------------------------------");
		      }
	 }
		    
	 
	 public void supprimerClient(int idClient) {
		  
		    for (Client client : clients) {
		        // Si l'ID du client correspond à l'ID 
		        if (client.getId_client() == idClient) {
		            
		            clients.remove(client);
		            System.out.println("Client supprimé avec succès.");
		            return; // Sortez de la méthode après avoir supprimé le client
		        }
		    }
		    // Si aucun client avec l'ID donné n'est trouvé
		    System.out.println("Aucun client trouvé avec l'ID spécifié.");
		}
	 
	 
	 
	 public void modifierClient(int idClient) {
		    Scanner scanner = new Scanner(System.in);
		    // Recherche du client dans la liste 
		    for (Client client : clients) {
		        // Si l'ID du client correspond à l'ID fourni
		        if (client.getId_client() == idClient) {
		            System.out.println("Modifier les informations du client:");

		            // Demander à l'utilisateur ce qu'il souhaite changer
		            System.out.println("Voulez-vous modifier le nom? (O/N)");
		            char modifierNom = Character.toUpperCase( scanner.next().charAt(0));
		            scanner.nextLine(); // Pour consommer la nouvelle ligne

		            if (modifierNom == 'O') {
		                System.out.println("Nouveau nom:");
		                String nouveauNom = scanner.nextLine();
		                client.setNom(nouveauNom);
		            }

		            System.out.println("Voulez-vous modifier le prénom? (O/N)");
		            char modifierPrenom = Character.toUpperCase(scanner.next().charAt(0));
		            scanner.nextLine();

		            if (modifierPrenom == 'O') {
		                System.out.println("Nouveau prénom:");
		                String nouveauPrenom = scanner.nextLine();
		                client.setPrenom(nouveauPrenom);
		            }

		            System.out.println("Voulez-vous modifier le numéro de téléphone? (O/N)");
		            char modifierNumero = Character.toUpperCase(scanner.next().charAt(0));
		            scanner.nextLine();

		            if (modifierNumero == 'O') {
		               
		            	  System.out.println("Enter votre Nouveau numero de telephone (10 Chiffres): ");
		                  String nouveauNumero = EnterPhoneNumber();
		                  client.setNumber_phone(nouveauNumero);		               
		            }

		            System.out.println("Voulez-vous modifier le type? (O/N)");
		            char modifierType = Character.toUpperCase(scanner.next().charAt(0));
		            scanner.nextLine();

		            if (modifierType == 'O') {
		            	 boolean type_faux2;
		                 char nouveauType;
		              do {
		            	  System.out.println("Nouveau type (A pour Acheteur, P pour propriétaire, T pour acheteur et proprietaire au meme temps):");
			               
		                 nouveauType = Character.toUpperCase(scanner.next().charAt(0));
		                  scanner.nextLine();
		               
		                type_faux2 = (nouveauType == 'A' || nouveauType == 'P' || nouveauType == 'T');
		                if (!type_faux2) {
		                    System.out.println("Invalid type!!");}
		                } while(!type_faux2);
                    	 
		              client.setType(nouveauType);
		                // Modifier le budget ou la demande selon le type
		                if (nouveauType == 'A') {

		                    int nouveauBudget =exception("Nouveau budget:");
		                    client.setBudjet(nouveauBudget);
		                    client.setPrix(-1); // Réinitialiser la demande
		                    client.setId_immobilier(-1);
		                } else if (nouveauType == 'P' ) {
		                   
		                    
		                    int nouvellePrix =  exception("Nouvelle Prix :");
		                    client.setPrix(nouvellePrix);           
		                    int nouvelleid_immobiler =  exception("Nouvelle id_immobilier:");
		                    client.setId_immobilier(nouvelleid_immobiler);
		                    
		                    client.setBudjet(-1); // Réinitialiser le budget
		                } else if (nouveauType == 'T') {
		                    int nouveauBudget =exception("Nouveau budget:");
                            client.setBudjet(nouveauBudget);
		                    
		                    int nouvellePrix =  exception("Nouvelle Prix :");
		                    client.setPrix(nouvellePrix);
		                    
		                    int nouvelleid_immobiler =  exception("Nouvelle id_immobilier:");
                            client.setId_immobilier(nouvelleid_immobiler);
		                   
		                }
		            }

		            System.out.println("Informations du client modifiées avec succès.");
		            return; // Sortir de la méthode après avoir modifié le client
		        }
		    }
		    // Si aucun client avec l'ID donné n'est trouvé
		    System.out.println("Aucun client trouvé avec l'ID spécifié.");
		}
	 
	 public int exception(String message) {
         int value = 0;
         boolean valid = false;
       
		do {
             System.out.println(message);
             try {
                 value = scanner.nextInt();
                 valid = true;
             } catch (Exception e) {
                 System.out.println("Entrée invalide. Veuillez entrer un nombre.");
                 scanner.next(); // clear the invalid input
             }
         } while (!valid);
         scanner.nextLine(); // clear the buffer
         return value;
     }

	 

	    

	     public void menu_client() {
	         Scanner scanner = new Scanner(System.in);
	         char choix2;

	         do {
	             System.out.println("Menu Client:");
	             System.out.println("1. Ajouter un client");
	             System.out.println("2. Supprimer un client");
	             System.out.println("3. Modifier un client");
	             System.out.println("4. Afficher tous les clients");
	             System.out.println("5. Afficher un client spécifique");
	             System.out.println("6. Quitter");

	             System.out.println("Entrez votre choix:");
	             choix2 = scanner.next().charAt(0);
	             scanner.nextLine(); // Consommer la nouvelle ligne

	             switch (choix2) {
	                 case '1':
	                     addClient();
	                     break;
	                 case '2':
	                       System.out.println("Entrez l'ID du client à supprimer:");
	                       int idSupprimer = scanner.nextInt();
	                     supprimerClient(idSupprimer);
	                     break;
	                 case '3':
	                     System.out.println("Entrez l'ID du client à modifier:"); 
	                     int idModifier = scanner.nextInt();
	                     modifierClient(idModifier);
	                     break;
	                 case '4':
	                     afficherClients();
	                     break;
	                 case '5':
	                      System.out.println("Entrez l'ID du client à afficher:");
	                      int idAfficher = scanner.nextInt();
	                   
	                     afficher_Client(idAfficher);
	                     break;
	                 case '6':
	                     System.out.println("Au revoir !");
	                     break;
	                 default:
	                     System.out.println("Choix invalide. Veuillez choisir un numéro entre 1 et 6.");
	             }
	         } while (choix2 != '6');
	     }
	    
}

