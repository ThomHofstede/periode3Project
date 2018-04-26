
package Pakketten;

import java.util.*;

/**
 *
 * @author Olink
 */
public class Pakketlevering extends Pakket {
    private ArrayList<Pakket> pakket;
    private String deadline;
    private int oplevering;
    private Date datum;
    private Date vertrektijd;
    private Date aankomsttijd;
    
    public Pakketlevering() {
        
    }

    public String getDeadline() {
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
