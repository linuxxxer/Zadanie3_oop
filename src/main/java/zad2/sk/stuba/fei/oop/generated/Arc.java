
package zad2.sk.stuba.fei.oop.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element ref="{}id"/&gt;
 *         &lt;element name="type" type="{}arc_type"/&gt;
 *         &lt;element ref="{}sourceId"/&gt;
 *         &lt;element ref="{}destinationId"/&gt;
 *         &lt;element ref="{}multiplicity"/&gt;
 *         &lt;element ref="{}breakPoint" maxOccurs="unbounded" minOccurs="0"/&gt;
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
    "id",
    "type",
    "sourceId",
    "destinationId",
    "multiplicity",
    "breakPoint"
})
@XmlRootElement(name = "arc")
public class Arc {

    protected int id;
    @XmlElement(required = true, defaultValue = "regular")
    @XmlSchemaType(name = "string")
    protected ArcType type;
    protected int sourceId;
    protected int destinationId;
    protected int multiplicity;
    protected List<BreakPoint> breakPoint;

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link ArcType }
     *     
     */
    public ArcType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArcType }
     *     
     */
    public void setType(ArcType value) {
        this.type = value;
    }

    /**
     * Gets the value of the sourceId property.
     * 
     */
    public int getSourceId() {
        return sourceId;
    }

    /**
     * Sets the value of the sourceId property.
     * 
     */
    public void setSourceId(int value) {
        this.sourceId = value;
    }

    /**
     * Gets the value of the destinationId property.
     * 
     */
    public int getDestinationId() {
        return destinationId;
    }

    /**
     * Sets the value of the destinationId property.
     * 
     */
    public void setDestinationId(int value) {
        this.destinationId = value;
    }

    /**
     * Gets the value of the multiplicity property.
     * 
     */
    public int getMultiplicity() {
        return multiplicity;
    }

    /**
     * Sets the value of the multiplicity property.
     * 
     */
    public void setMultiplicity(int value) {
        this.multiplicity = value;
    }

    /**
     * Gets the value of the breakPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.copyAll
     * This is why there is not a <CODE>set</CODE> method for the breakPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBreakPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BreakPoint }
     * 
     * 
     */
    public List<BreakPoint> getBreakPoint() {
        if (breakPoint == null) {
            breakPoint = new ArrayList<BreakPoint>();
        }
        return this.breakPoint;
    }

}
