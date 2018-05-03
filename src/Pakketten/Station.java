
package Pakketten;

/**
 *
 * @author Olink
 */
class Station extends Pakket {
    private String naam;
    private String kiosklocatie;

    public Station(String treinkoerier) {
        super(treinkoerier);
    }
    
    public String getNaam() {
        return this.naam;
    }
    
    public String getKioskLocatie() {
        return this.kiosklocatie;
    }
}
