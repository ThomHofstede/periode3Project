
package Pakketten;

import java.util.*;

/**
 *
 * @author Olink
 */
public class Pakketlevering extends Pakket {
    private ArrayList<Pakket> pakket;
    private Date deadline;
    private int oplevering;
    private Date datum;
    private Date vertrektijd;
    private Date aankomsttijd;

    public Pakketlevering(String treinkoerier) {
        super(treinkoerier);
    }
    
    public Date getDeadline() {
        return deadline;
    }

    public int getOplevering() {
        return oplevering;
    }

    public Date getDatum() {
        return datum;
    }

    public Date getVertrektijd() {
        return vertrektijd;
    }

    public Date getAankomsttijd() {
        return aankomsttijd;
    }
    
    
}
