
package Gebruikers;

/**
 *
 * @author Olink
 */
public class Treinkoerier extends Gebruiker {
    private String voornaam;
    private String achternaam;
    private String treinkoerierstatus;
    
    public String getVoornaam() {
        return this.voornaam;
    }
    
    public String getAchternaam() {
        return this.achternaam;
    }
    
    public String getTreinkoerierstatus() {
        return this.treinkoerierstatus;
    }
    
    public void setTreinkoerierstatus() {
        this.treinkoerierstatus = treinkoerierstatus;
    }
}
