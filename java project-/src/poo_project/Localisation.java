/* ------ realise par HALOUI Moussa  -------*/

package poo_project;

public class Localisation {

  private String wilaya;
  private String ville;
  private String rue;


  public String getWilaya() {
    return wilaya;
  }
  public void setWilaya(String wilaya) {
    this.wilaya = wilaya;
  }
  
  public String getVille() {
    return ville;
  }
  public void setVille(String ville) {
    this.ville = ville;
  }
  public String getRue() {
    return rue;
  }
  public void setRue(String rue) {
    this.rue = rue;
  }
  public Localisation(String wilaya,String ville, String rue) {
    this.wilaya = wilaya; 
    this.ville = ville;
    this.rue = rue;
  }

  public Localisation(){
    
  }


  public String toString() {
    return wilaya+", "+ville+", "+rue+".";
  
  }

}
