
package Gebruikers;

/**
 *
 * @author Olink
 */
public class Koerierdienst extends Gebruiker {
    private String bedrijfsnaam;
    private String koerierstatus;

    public Koerierdienst(String gebruikersnaam, String wachtwoord, int telefoonnr) {
        super(gebruikersnaam, wachtwoord, telefoonnr);
    }
    
    
    public String getBedrijfsnaam() {
        return this.bedrijfsnaam;
    }
    
    public String getKoerierstatus() {
        return this.koerierstatus;
    }
    
    public void setKoerierstatus() {
        this.koerierstatus = koerierstatus;
    }
}
