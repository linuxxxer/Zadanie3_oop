
package zad2.sk.stuba.fei.oop.generated;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{}transition" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{}place" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{}arc" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "transition",
    "place",
    "arc"
})
@XmlRootElement(name = "document")
public class Document {

    @XmlElement(required = true)
    protected List<Transition> transition;
    protected List<Place> place;
    protected List<Arc> arc;

    public void addTransition(String label, int id, int x, int y) {
        Transition transition = new Transition();
        transition.setId(id);
        transition.setLabel(label);
        transition.setX(x);
        transition.setY(y);
        if (this.transition == null){
            this.transition = new ArrayList<>();
        }
        this.transition.add(transition);
    }

    public void addPlace(String label, int id, int tokens, int x, int y) {
        Place place = new Place();
        place.setId(id);
        place.setIsStatic(false);
        place.setStatic(false);
        place.setLabel(label);
        place.setTokens(tokens);
        place.setX(x);
        place.setY(y);
        if (this.place == null){
            this.place = new ArrayList<>();
        }
        this.place.add(place);
    }

    public void addArc(ArcType type, int id, int multiplicity, int dest, int source) {
        Arc arc = new Arc();
        arc.setType(type);
        arc.setId(id);
        arc.setMultiplicity(multiplicity);
        arc.setDestinationId(dest);
        arc.setSourceId(source);
        if (this.arc == null){
            this.arc = new ArrayList<>();
        }
        this.arc.add(arc);
    }

    /**
     * Gets the value of the transition property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the transition property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTransition().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Transition }
     * 
     * 
     */
    public List<Transition> getTransition() {
        if (transition == null) {
            transition = new ArrayList<Transition>();
        }
        return this.transition;
    }

    /**
     * Gets the value of the place property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the place property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPlace().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Place }
     * 
     * 
     */
    public List<Place> getPlace() {
        if (place == null) {
            place = new ArrayList<Place>();
        }
        return this.place;
    }

    /**
     * Gets the value of the arc property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the arc property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArc().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Arc }
     * 
     * 
     */
    public List<Arc> getArc() {
        if (arc == null) {
            arc = new ArrayList<Arc>();
        }
        return this.arc;
    }

}
