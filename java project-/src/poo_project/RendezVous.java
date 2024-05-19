package poo_project;

/* ------ realise par DJERMOM Anis  -------*/


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

public class RendezVous {
    public static class Agent {
        private int idAgent;

        public Agent(int idAgent) {
            this.idAgent = idAgent;
        }

        public int getIdAgent() {
            return idAgent;
        }
    }

    public static class Client {
        private int idClient;
        private LinkedList<RendezVous> historique;

        public Client(int idClient) {
            this.idClient = idClient;
            this.historique = new LinkedList<>();
        }

        public int getIdClient() {
            return idClient;
        }

        public LinkedList<RendezVous> getHistorique() {
            return historique;
        }

        public void addRendezVous(RendezVous rdv) {
            historique.add(rdv);
        }

        public void removeRendezVous(RendezVous rdv) {
            historique.remove(rdv);
        }

        public void modifyRendezVous(RendezVous oldRdv, RendezVous newRdv) {
            if (historique.contains(oldRdv)) {
                historique.remove(oldRdv);
                historique.add(newRdv);
            }
        }

        public RendezVous research(Date date) {
            for (RendezVous rdv : historique) {
                if (rdv.getDate().equals(date)) {
                    return rdv;
                }
            }
            return null; // Rendez-vous not found
        }

        public void afficher() {
            System.out.println("Historique des rendez-vous pour le client " + idClient + ":");
            for (RendezVous rdv : historique) {
                System.out.println("- Date: " + rdv.getDate() + ", Agent: " + rdv.agent.getIdAgent() + ", Type: " + rdv.type);
            }
        }
    }

    public enum Type {
        ACHAT, VISITE, PREMIER
    }

    private Date date;
    private Agent agent;
    private Type type;

    public RendezVous(Date date, Agent agent, Type type) {
        this.date = date;
        this.agent = agent;
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public static RendezVous creerRendezVous(Scanner scanner) throws ParseException {
        System.out.println("Entrez la date du rendez-vous (format dd/MM/yyyy HH:mm) : ");
        String dateString = scanner.nextLine();

        System.out.println("Entrez l'identifiant de l'agent : ");
        int agentId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.println("Entrez le type de rendez-vous (ACHAT, VISITE, PREMIER) : ");
        String typeString = scanner.nextLine().toUpperCase();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date date = dateFormat.parse(dateString);

        Agent agent = new Agent(agentId);
        Type type = Type.valueOf(typeString);

        return new RendezVous(date, agent, type);
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Entrez l'identifiant du client : ");
            int clientId = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            Client client = new Client(clientId);
            boolean continueMenu = true;

            while (continueMenu) {
                System.out.println("\nMenu:");
                System.out.println("1: Ajouter un rendez-vous");
                System.out.println("2: Supprimer un rendez-vous");
                System.out.println("3: Modifier un rendez-vous");
                System.out.println("4: Afficher l'historique des rendez-vous");
                System.out.println("0: Quitter");
                System.out.print("Veuillez choisir une option : ");

                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                switch (choice) {
                    case 1:
                        try {
                            RendezVous newRdv = creerRendezVous(scanner);
                            client.addRendezVous(newRdv);
                            System.out.println("Rendez-vous ajouté avec succès.");
                        } catch (ParseException e) {
                            System.out.println("Erreur lors de la création du rendez-vous : " + e.getMessage());
                        }
                        break;
                    case 2:
                        System.out.println("Entrez la date du rendez-vous à supprimer (format dd/MM/yyyy HH:mm) : ");
                        String dateString = scanner.nextLine();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                        Date dateToRemove = dateFormat.parse(dateString);
                        RendezVous rdvToRemove = client.research(dateToRemove);

                        if (rdvToRemove != null) {
                            client.removeRendezVous(rdvToRemove);
                            System.out.println("Rendez-vous supprimé avec succès.");
                        } else {
                            System.out.println("Aucun rendez-vous trouvé pour la date spécifiée.");
                        }
                        break;
                    case 3:
                        System.out.println("Fonction de modification de rendez-vous à implémenter.");
                        break;
                    case 4:
                        client.afficher();
                        break;
                    case 0:
                        continueMenu = false;
                        System.out.println("Au revoir !");
                        break;
                    default:
                        System.out.println("Option invalide. Veuillez choisir une option valide.");
                        break;
                }
            }

            scanner.close(); // Close the scanner
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}