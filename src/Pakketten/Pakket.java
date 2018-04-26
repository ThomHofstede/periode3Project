
package Pakketten;

/**
 *
 * @author Olink
 */
public class Pakket {
    private int pakketid;
    private String pakketstatus;
    private Station vertrek;
    private Station aankomst;
    
    public Pakket() {
        
    }
    
    public int getPakketId() {
        return this.pakketid;
    }
    
    public String getPakketStatus() {
        return this.pakketstatus;
    }
    
    public void setPakketStatus() {
        this.pakketstatus = pakketstatus;
    }
}
