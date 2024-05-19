
/* realise par HALOUI Moussa */
package poo_project;
import java.util.LinkedList;
import java.util.Scanner;

public class DatabaseBienImmobilier {

    static public LinkedList<BienImmobilier> mydata = new LinkedList<BienImmobilier>();
    private BienImmobilier newitem;
   
    Scanner scan = new Scanner(System.in);

    /*  Constructeur de la classe DatabaseBienImmobilier   */
    public DatabaseBienImmobilier() {

       
    }

    /*------------------------------------------------------------------------- */
	
		public void afficherListe() {
			if (mydata.isEmpty()) {
					System.out.println("La liste est vide.");
			} else {
				  System.out.println("-----------------------------------");
					System.out.println("Contenu de la liste :");
					for (BienImmobilier bien : mydata) {
						System.out.println("-----------------------------------");
						System.out.println("ID du bien immobilier : " + bien.getId_bien());
						System.out.println("Type : " + bien.getType());
						System.out.println("Taille : " + bien.getTaille());
						System.out.println("Prix : " + bien.getPrix());
						System.out.println("Localisation : " + bien.getLocalisation().toString());
						System.out.println("Service : " + bien.getService());
						System.out.println("Description : " + bien.getDescription());
						System.out.println("Prix total : " + bien.getPrix_totale());
						System.out.println("Agent responsable : " + bien.getAgent_respo());
						System.out.println("-----------------------------------");
					}
			}
		}
		
   
    /*-----------------------------------------------------------------------*/

    

    public BienImmobilier rechercherParId(){
        int id=0;
				boolean bool = false;
				do {
					
					try {
						System.out.println("Donnez l'ID de l'immobilier à rechercher :");
            id = scan.nextInt();
						
						bool=true;
						
					} catch (Exception e) {
						System.out.println("try again");
						scan.next();
					}
				} while (!bool);
        

        // Parcourir la liste pour trouver l'élément avec l'ID spécifié
        for (BienImmobilier item : mydata) {
            if (item.getId_bien() == id) {
                // Retourner l'élément s'il est trouvé
                return item;
            }
        }
        // Retourner null si aucun élément n'est trouvé avec l'ID spécifié
        return null;
    }
    
    /* ------------------------------------------------------------------------------- */


public LinkedList<BienImmobilier> rechercherBudgetMax( LinkedList<BienImmobilier> mydata) {
	LinkedList<BienImmobilier> biensTrouves = new LinkedList<>();
	
     double budgetMax=0 ;
     boolean bool =false;
	
	do {
		
		try {
			System.out.println("Entrez votre budget maximale : ");
			 budgetMax = scan.nextDouble();
			
			bool=true;
			
		} catch (Exception e) {
			System.out.println("try again");
			scan.next();
		}
	 } while (!bool);
	


	boolean aucunBienTrouve = true;

	for (BienImmobilier bien : mydata) {
			if (bien.getPrix_totale() <= budgetMax) {
					aucunBienTrouve = false;
					System.out.println("ID du bien immobilier : " + bien.getId_bien());
					System.out.println("Type : " + bien.getType());
					System.out.println("Taille : " + bien.getTaille());
					System.out.println("Prix : " + bien.getPrix());
					
					// Affichage de la localisation
					System.out.println("Localisation : " + bien.getLocalisation().toString());
					// Affichage du service
					System.out.println("Service : " + bien.getService());
					// Affichage de la description
					System.out.println("Description : " + bien.getDescription());
					// Affichage du prix total
					System.out.println("Prix Total : " + bien.getPrix_totale());
					// Affichage de l'agent responsable
					System.out.println("Agent Responsable : " + bien.getAgent_respo());
					System.out.println("-----------------------------------");
					biensTrouves.add(bien);
					
			}
	}

	if (aucunBienTrouve) {
			System.out.println("Aucun bien immobilier trouvé dans votre budget.");
	}
	return biensTrouves;
}


/* ------------------------------------------------------------------ */

public  LinkedList<BienImmobilier> rechercherType( LinkedList<BienImmobilier> mydata) {
	LinkedList<BienImmobilier> biensTrouves = new LinkedList<>();

	
	int choixType=0;
	boolean bool = false;
	do {
		
		try {
			// Demandez à l'utilisateur de saisir le type d'immobilier à rechercher
	System.out.println("Entrez le type d'immobilier que vous souhaitez rechercher :");
	System.out.println("1 : pour type appartement");
	System.out.println("2 : pour type villa");
	System.out.println("3 : pour type terrain");

	// Lisez l'entrée de l'utilisateur
	  choixType = scan.nextInt();
			
			bool=true;
			
		} catch (Exception e) {
			System.out.println("try again");
			scan.next();
		}
	} while (!bool);



	
	String typeRecherche = "";
	do {
	// Convertissez le choix de l'utilisateur en type de bien immobilier
	switch (choixType) {
			
			case 1:
					typeRecherche = "Appartement";
					break;
			case 2:
					typeRecherche = "Villa";
					break;
			case 3:
					typeRecherche = "Terrain";
					break;
			default:
					System.out.println("Choix invalide !");
				 
					break ;// Sortez de la méthode si le choix est invalide
	}
}while (choixType<1 || choixType>3);
	// Parcourez la liste des biens immobiliers et affichez ceux du type recherché
	boolean aucunBienTrouve = true;
	for (BienImmobilier bien : mydata) {
			if (bien.getType().equalsIgnoreCase(typeRecherche)) {
					aucunBienTrouve = false;
					System.out.println(bien.toString());
				
			}
			biensTrouves.add(bien);
	}

	// Si aucun bien immobilier n'est trouvé, affichez un message approprié
	if (aucunBienTrouve) {
			System.out.println("Aucun bien immobilier de type " + typeRecherche + " n'a été trouvé.");
	}
return biensTrouves;
	
}

/*----------------------------------------------------------------------------------------- */

// Méthode de recherche par wilaya uniquement
public  LinkedList<BienImmobilier> rechercherEtAfficherParWilaya( LinkedList<BienImmobilier> mydata) {
	LinkedList<BienImmobilier> biensTrouves = new LinkedList<>();
	Scanner scanner = new Scanner(System.in);

	// Demandez à l'utilisateur s'il veut rechercher par wilaya uniquement
	System.out.println("Voulez-vous rechercher par wilaya uniquement ? (Oui/Non)");
	String reponse = scanner.nextLine();

	if (reponse.equalsIgnoreCase("Oui")) {
			
			// Parcourez la liste des biens immobiliers et affichez ceux de la wilaya recherchée
		
			biensTrouves = rechercherParWilaya(mydata);
	} else if (reponse.equalsIgnoreCase("Non")) {
			// Sinon, appelez la méthode de recherche par wilaya et ville
			
			
			biensTrouves =	rechercherParWilayaEtVille(mydata);
	} else {
			System.out.println("Réponse invalide. Veuillez répondre 'Oui' ou 'Non'.");
	}

	return biensTrouves;
}




// Méthode de recherche par wilaya uniquement



private  LinkedList<BienImmobilier> rechercherParWilaya(  LinkedList<BienImmobilier> mydata) {
	LinkedList<BienImmobilier> biensTrouves = new LinkedList<>();

	// Demandez à l'utilisateur de saisir la wilaya à rechercher
	System.out.println("Entrez la wilaya que vous souhaitez rechercher :");
	String wilayaRecherche = scan.nextLine();

	boolean aucunBienTrouve = true;
	for (BienImmobilier bien : mydata) {
			Localisation localisation = bien.getLocalisation();
			if (localisation.getWilaya().equalsIgnoreCase(wilayaRecherche)) {
					aucunBienTrouve = false;
					System.out.println(bien.toString());
					biensTrouves.add(bien);
			}

	}


	// Si aucun bien immobilier n'est trouvé, affichez un message approprié
	if (aucunBienTrouve) {
			System.out.println("Aucun bien immobilier dans la wilaya " + wilayaRecherche + " n'a été trouvé.");
	}

	return biensTrouves;
}

// Méthode de recherche par wilaya et ville
private  LinkedList<BienImmobilier> rechercherParWilayaEtVille( LinkedList<BienImmobilier> mydata) {
	
	LinkedList<BienImmobilier> biensTrouves = new LinkedList<>();
	
	// Demandez à l'utilisateur de saisir la wilaya à rechercher
	System.out.println("Entrez la wilaya que vous souhaitez rechercher :");
	String wilayaRecherche = scan.nextLine();

	// Demandez à l'utilisateur de saisir la ville à rechercher
	System.out.println("Entrez la ville que vous souhaitez rechercher :");
	String villeRecherche = scan.nextLine();
	// Parcourez la liste des biens immobiliers et affichez ceux de la wilaya et ville recherchées
	boolean aucunBienTrouve = true;
	for (BienImmobilier bien : mydata) {
			Localisation localisation = bien.getLocalisation();
			if (localisation.getWilaya().equalsIgnoreCase(wilayaRecherche) &&
					localisation.getVille().equalsIgnoreCase(villeRecherche)) {
					aucunBienTrouve = false;
					System.out.println(bien.toString());
					biensTrouves.add(bien);
			}
	}

	// Si aucun bien immobilier n'est trouvé, affichez un message approprié
	if (aucunBienTrouve) {
			System.out.println("Aucun bien immobilier dans la wilaya " + wilayaRecherche +
												 " et la ville " + villeRecherche + " n'a été trouvé.");
	}
	return biensTrouves;
}


/* ------------------------------------------ */

public   LinkedList<BienImmobilier> rechercherEtAfficherParTailleMaximale( LinkedList<BienImmobilier> mydata) {
	LinkedList<BienImmobilier> biensTrouves = new LinkedList<>();
	Scanner scanner = new Scanner(System.in);
  double tailleMax=0;
	boolean bool = false;
	do {
		
		try {
	 // Demandez à l'utilisateur de saisir la taille maximale
	 System.out.println("Entrez la taille maximale (en mètres carrés) :");
	 tailleMax = scanner.nextDouble();
	 bool=true;
			
		} catch (Exception e) {
			System.out.println("try again");
			scan.next();
		}
	} while (!bool);

	// Affichez les biens immobiliers dont la taille est inférieure ou égale à la taille maximale
	boolean aucunBienTrouve = true;
	for (BienImmobilier bien : mydata) {
			double tailleBien = bien.getTaille();
			if (tailleBien <= tailleMax) {
					aucunBienTrouve = false;
					System.out.println(bien.toString());
					biensTrouves.add(bien);
			}
	}

	// Si aucun bien immobilier n'est trouvé dans la taille maximale spécifiée, affichez un message approprié
	if (aucunBienTrouve) {
			System.out.println("Aucun bien immobilier trouvé dans la taille maximale spécifiée.");
	}

	
	
	return biensTrouves;
}



/* -------------------------------------------- */

 // Méthode de recherche par type de transaction (vente ou location)
 public  LinkedList<BienImmobilier> rechercherEtAfficherParTypeTransaction(LinkedList<BienImmobilier> mydata) {
	LinkedList<BienImmobilier> biensTrouves = new LinkedList<>();
	Scanner scanner = new Scanner(System.in);

	// Demandez à l'utilisateur de saisir le type de transaction (vente ou location)
	System.out.println("Entrez le type de transaction (Vente/Location) :");
	String typeTransaction = scanner.nextLine().toLowerCase(); // Convertissez en minuscules pour la comparaison

	// Affichez les biens immobiliers correspondant au type de transaction spécifié
	boolean aucunBienTrouve = true;
	for (BienImmobilier bien : mydata) {
			String transactionBien = bien.getService().toLowerCase(); // Convertissez en minuscules pour la comparaison
			if (transactionBien.equals(typeTransaction)) {
					aucunBienTrouve = false;
					System.out.println(bien.toString());
					biensTrouves.add(bien);
			}
	}

	// Si aucun bien immobilier n'est trouvé pour le type de transaction spécifié, affichez un message approprié
	if (aucunBienTrouve) {
			System.out.println("Aucun bien immobilier trouvé pour le type de transaction spécifié.");
	}
	
	return biensTrouves;
}









public void supprimerBienImmobilier(){
	Scanner scanner = new Scanner(System.in);

	// Demandez à l'utilisateur l'ID du bien immobilier à supprimer
	System.out.println("Entrez l'ID du bien immobilier à supprimer :");
	int idBien = scanner.nextInt();

	// Parcourez la liste des biens immobiliers pour trouver celui avec l'ID spécifié
	boolean bienTrouve = false;
	for (BienImmobilier bien : mydata) {
			if (bien.getId_bien() == idBien) {
					mydata.remove(bien);
					bienTrouve = true;
					System.out.println("Le bien immobilier avec l'ID " + idBien + " a été supprimé.");
					break; // Sortez de la boucle une fois que le bien immobilier est trouvé et supprimé
			}
	}

	// Si aucun bien immobilier n'est trouvé avec l'ID spécifié, affichez un message approprié
	if (!bienTrouve) {
			System.out.println("Aucun bien immobilier trouvé avec l'ID " + idBien + ".");
	}

	
}

















public void modifierAttributs() {
	int choix=0;
	boolean bool = false;
  BienImmobilier item = rechercherParId();
	System.out.println("Quel attribut voulez-vous modifier ?");
	System.out.println("1. Type");
	System.out.println("2. Taille");
	System.out.println("3. Prix");
	System.out.println("4. Service");
  System.out.println("5. localisation");
	System.out.println("6. Description");
	System.out.println("7. Agent Responsable");
	do {
		try {
	
			System.out.print("Votre choix : ");
	    choix = scan.nextInt();
			bool =true;
			} 
			catch (Exception e) {
				System.out.println("try again");
				scan.next();
			}
	} while (!bool);
	
	
	
	scan.nextLine(); // Consommer la nouvelle ligne
	do {
	switch (choix) {
			case 1:
			newitem.try_insert_type(scan);
					break;
			case 2:
			newitem.try_insert_taille(scan);
			newitem.calcule_prix_totale();
					break;
			case 3:
			newitem.try_insert_prix(scan);
			newitem.calcule_prix_totale();
			scan.nextLine();// consume line
					break;
			case 4:
			newitem.try_insert_service(scan);
			scan.nextLine();// consume line
					break;
			case 5:
			newitem.insert_localisation(scan);
					break;
			case 6:
			item.insert_descrition(scan);
		  scan.nextLine();// consume line
					break;
			case 7:
			item.try_insert_agent_respo(scan);
			scan.nextLine();// consume line
			default:
					System.out.println("Choix invalide.");
					break;
	}
}while (choix<1 || choix>7);
}


/* ---------------------------------------------------------- */
public void ajouterBienImmobilier(){
 int continuer1=1;
 boolean bool = false;
	do {
		newitem = new BienImmobilier();// cree l'objet
		newitem.setId_bien();
		newitem.try_insert_type(scan);
		newitem.try_insert_taille(scan);
		newitem.try_insert_prix(scan);
		scan.nextLine();// consume line
		newitem.try_insert_service(scan);
		scan.nextLine();// consume line
		newitem.insert_localisation(scan);
		newitem.insert_descrition(scan);
		newitem.calcule_prix_totale();
		newitem.try_insert_agent_respo(scan);
		scan.nextLine();// consume line
		mydata.add(newitem);

do{
try {
	System.out.println("voulez vous ajouter un autre immobilier donnez 1. Sinon, donnez 0.");
		continuer1 = scan.nextInt(); 
		scan.nextLine();
	 bool = true;
} catch (Exception e) {
	System.out.println("try again");
	scan.next();
}
} while (!bool);

		
} while (continuer1 == 1);
}















public void menu_bien_immobilier(){
	
	int continuer=0;
	LinkedList<BienImmobilier> biensTrouves = new LinkedList<>();
	BienImmobilier bimm = new BienImmobilier();
	int choixtype= 0;

Scanner scan = new Scanner(System.in);

System.out.println("Choisissez une option :");
System.out.println("1. afficher la liste d'immobiliers");
System.out.println("2. ajouter un immobilier");
System.out.println("3. modifier les informations d'un immobilier");
System.out.println("4. supprimmer un immobilier");
System.out.println("5. Rechercher par id immobilier");
System.out.println("6. Rechercher par le budget maximal");
System.out.println("7. Rechercher par le type d'immobilier");
System.out.println("8. Rechercher par la localisation");
System.out.println("9. Rechercher par la taille maximale");
System.out.println("10. Rechercher par le type de transaction");
System.out.println("0. Quitter le menu");

boolean bool =false;
do {
	try {

		System.out.println("Entrez votre choix : ");

    choixtype = scan.nextInt(); 
		bool =true;
		} 
		catch (Exception e) {
			System.out.println("try again");
			scan.next();
		}
} while (!bool);






do {
switch (choixtype) {
  case 0:
	break;
	case 1:
	afficherListe();
	scan.nextLine();// consume line
	   break;

	case 2:
	ajouterBienImmobilier();
	scan.nextLine();// consume line
			break;

	case 3:
  modifierAttributs();
  scan.nextLine();// consume line
			break;

	case 4:
	supprimerBienImmobilier();
	scan.nextLine();// consume line
			break;

	case 5:
	bimm = rechercherParId();
	scan.nextLine();// consume line
    break;
  case 6:
	 biensTrouves = rechercherBudgetMax(mydata);
	 scan.nextLine();// consume line
		 break;

	case 7:
	biensTrouves = rechercherType(mydata);
	scan.nextLine();// consume line
     break;

		 case 8:
		 biensTrouves =	rechercherEtAfficherParWilaya(mydata);
		 scan.nextLine();// consume line
		 break;
		 case 9:
		 biensTrouves =	rechercherEtAfficherParTailleMaximale(mydata);
		 scan.nextLine();// consume line
			break;
		 case 10:
		 biensTrouves =	rechercherEtAfficherParTypeTransaction(mydata);
		 break;
	default:
			System.out.println("Choix invalide !");
		 
			break ;// Sortez de la méthode si le choix est invalide
		}
}while (choixtype<0 || choixtype>10);

bool =false;
do {
	try {

		System.out.println("si vous voulez continuer dans le menu tapez 1 sinon 0");
		continuer = scan.nextInt();
		bool =true;
		} 
		catch (Exception e) {
			System.out.println("try again");
			scan.next();
		}
} while (bool == false);




while(continuer == 1){
	System.out.println("Choisissez une option :");
	System.out.println("1. afficher la liste d'immobiliers");
	System.out.println("2. ajouter un immobilier");
	System.out.println("3. modifier les informations d'un immobilier");
	System.out.println("4. supprimmer un immobilier");
	System.out.println("5. Rechercher par id immobilier");
	System.out.println("6. Rechercher par le budget maximal");
	System.out.println("7. Rechercher par le type d'immobilier");
	System.out.println("8. Rechercher par la localisation");
	System.out.println("9. Rechercher par la taille maximale");
	System.out.println("10. Rechercher par le type de transaction");
	System.out.println("0. Quitter le menu");
	
	bool = false;

 do {
	
	try {
		
    System.out.println("Entrez votre choix : ");
	  choixtype = scan.nextInt();
		bool =true;

	} 
	catch (Exception e) {
		System.out.println("try again");
		scan.next();
	}
} while (bool == false);
 

	
	
	do {
	switch (choixtype) {
		case 0:
		break;
		case 1:
		afficherListe();
		scan.nextLine();// consume line
			 break;
	
		case 2:
		ajouterBienImmobilier();
		scan.nextLine();// consume line
				break;
	
		case 3:
		modifierAttributs();
		scan.nextLine();// consume line
				break;
	
		case 4:
		supprimerBienImmobilier();
		scan.nextLine();// consume line
				break;
	
		case 5:
		bimm = rechercherParId();
		scan.nextLine();// consume line
			break;
		case 6:
		 biensTrouves = rechercherBudgetMax(biensTrouves);
		 scan.nextLine();// consume line
			 break;
	
		case 7:
		biensTrouves = rechercherType(biensTrouves);
		scan.nextLine();// consume line
			 break;
	
			 case 8:
			 biensTrouves =	rechercherEtAfficherParWilaya(biensTrouves);
			 scan.nextLine();// consume line
			 break;
			 case 9:
			 biensTrouves =	rechercherEtAfficherParTailleMaximale(biensTrouves);
			 scan.nextLine();// consume line
				break;
			 case 10:
			 biensTrouves =	rechercherEtAfficherParTypeTransaction(biensTrouves);
			 break;
		default:
				System.out.println("Choix invalide !");
			 
				break ;// Sortez de la méthode si le choix est invalide
			}
	}while (choixtype<0 || choixtype>10);

	
  




   bool =false;
	
	do {
		
		try {
			System.out.println("si vous voulez continuer dans le menu tapez 1 sinon 0");
      continuer = scan.nextInt();
			bool=true;
			
		} catch (Exception e) {
			System.out.println("try again");
			scan.next();
		}
	} while (!bool);
	


}

biensTrouves.clear();
}
}




















  

  
