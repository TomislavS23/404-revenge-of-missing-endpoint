
package dev.rme.model.rpc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import jakarta.annotation.Generated;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


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
 *         &lt;element name="DatumTermin"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Datum" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="Termin" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Grad" maxOccurs="unbounded"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="GradIme" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="Lat" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *                   &lt;element name="Lon" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *                   &lt;element name="Podatci"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="Temp" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *                             &lt;element name="Vlaga" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/&gt;
 *                             &lt;element name="Tlak" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *                             &lt;element name="TlakTend" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *                             &lt;element name="VjetarSmjer" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="VjetarBrzina" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *                             &lt;element name="Vrijeme" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="VrijemeZnak" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *                 &lt;attribute name="autom" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" /&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
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
    "datumTermin",
    "grad"
})
@XmlRootElement(name = "Hrvatska")
@Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.2", date = "2025-05-08T20:13:25+02:00")
public class Hrvatska {

    @XmlElement(name = "DatumTermin", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.2", date = "2025-05-08T20:13:25+02:00")
    protected Hrvatska.DatumTermin datumTermin;
    @XmlElement(name = "Grad", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.2", date = "2025-05-08T20:13:25+02:00")
    protected List<Hrvatska.Grad> grad;

    /**
     * Gets the value of the datumTermin property.
     * 
     * @return
     *     possible object is
     *     {@link Hrvatska.DatumTermin }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.2", date = "2025-05-08T20:13:25+02:00")
    public Hrvatska.DatumTermin getDatumTermin() {
        return datumTermin;
    }

    /**
     * Sets the value of the datumTermin property.
     * 
     * @param value
     *     allowed object is
     *     {@link Hrvatska.DatumTermin }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.2", date = "2025-05-08T20:13:25+02:00")
    public void setDatumTermin(Hrvatska.DatumTermin value) {
        this.datumTermin = value;
    }

    /**
     * Gets the value of the grad property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the grad property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGrad().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Hrvatska.Grad }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.2", date = "2025-05-08T20:13:25+02:00")
    public List<Hrvatska.Grad> getGrad() {
        if (grad == null) {
            grad = new ArrayList<Hrvatska.Grad>();
        }
        return this.grad;
    }


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
     *         &lt;element name="Datum" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="Termin" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/&gt;
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
        "datum",
        "termin"
    })
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.2", date = "2025-05-08T20:13:25+02:00")
    public static class DatumTermin {

        @XmlElement(name = "Datum", required = true)
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.2", date = "2025-05-08T20:13:25+02:00")
        protected String datum;
        @XmlElement(name = "Termin")
        @XmlSchemaType(name = "unsignedByte")
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.2", date = "2025-05-08T20:13:25+02:00")
        protected short termin;

        /**
         * Gets the value of the datum property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.2", date = "2025-05-08T20:13:25+02:00")
        public String getDatum() {
            return datum;
        }

        /**
         * Sets the value of the datum property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.2", date = "2025-05-08T20:13:25+02:00")
        public void setDatum(String value) {
            this.datum = value;
        }

        /**
         * Gets the value of the termin property.
         * 
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.2", date = "2025-05-08T20:13:25+02:00")
        public short getTermin() {
            return termin;
        }

        /**
         * Sets the value of the termin property.
         * 
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.2", date = "2025-05-08T20:13:25+02:00")
        public void setTermin(short value) {
            this.termin = value;
        }

    }


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
     *         &lt;element name="GradIme" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="Lat" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
     *         &lt;element name="Lon" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
     *         &lt;element name="Podatci"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="Temp" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
     *                   &lt;element name="Vlaga" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/&gt;
     *                   &lt;element name="Tlak" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
     *                   &lt;element name="TlakTend" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
     *                   &lt;element name="VjetarSmjer" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element name="VjetarBrzina" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
     *                   &lt;element name="Vrijeme" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element name="VrijemeZnak" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *       &lt;attribute name="autom" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "gradIme",
        "lat",
        "lon",
        "podatci"
    })
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.2", date = "2025-05-08T20:13:25+02:00")
    public static class Grad {

        @XmlElement(name = "GradIme", required = true)
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.2", date = "2025-05-08T20:13:25+02:00")
        protected String gradIme;
        @XmlElement(name = "Lat", required = true)
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.2", date = "2025-05-08T20:13:25+02:00")
        protected BigDecimal lat;
        @XmlElement(name = "Lon", required = true)
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.2", date = "2025-05-08T20:13:25+02:00")
        protected BigDecimal lon;
        @XmlElement(name = "Podatci", required = true)
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.2", date = "2025-05-08T20:13:25+02:00")
        protected Hrvatska.Grad.Podatci podatci;
        @XmlAttribute(name = "autom", required = true)
        @XmlSchemaType(name = "unsignedByte")
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.2", date = "2025-05-08T20:13:25+02:00")
        protected short autom;

        /**
         * Gets the value of the gradIme property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.2", date = "2025-05-08T20:13:25+02:00")
        public String getGradIme() {
            return gradIme;
        }

        /**
         * Sets the value of the gradIme property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.2", date = "2025-05-08T20:13:25+02:00")
        public void setGradIme(String value) {
            this.gradIme = value;
        }

        /**
         * Gets the value of the lat property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.2", date = "2025-05-08T20:13:25+02:00")
        public BigDecimal getLat() {
            return lat;
        }

        /**
         * Sets the value of the lat property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.2", date = "2025-05-08T20:13:25+02:00")
        public void setLat(BigDecimal value) {
            this.lat = value;
        }

        /**
         * Gets the value of the lon property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.2", date = "2025-05-08T20:13:25+02:00")
        public BigDecimal getLon() {
            return lon;
        }

        /**
         * Sets the value of the lon property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.2", date = "2025-05-08T20:13:25+02:00")
        public void setLon(BigDecimal value) {
            this.lon = value;
        }

        /**
         * Gets the value of the podatci property.
         * 
         * @return
         *     possible object is
         *     {@link Hrvatska.Grad.Podatci }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.2", date = "2025-05-08T20:13:25+02:00")
        public Hrvatska.Grad.Podatci getPodatci() {
            return podatci;
        }

        /**
         * Sets the value of the podatci property.
         * 
         * @param value
         *     allowed object is
         *     {@link Hrvatska.Grad.Podatci }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.2", date = "2025-05-08T20:13:25+02:00")
        public void setPodatci(Hrvatska.Grad.Podatci value) {
            this.podatci = value;
        }

        /**
         * Gets the value of the autom property.
         * 
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.2", date = "2025-05-08T20:13:25+02:00")
        public short getAutom() {
            return autom;
        }

        /**
         * Sets the value of the autom property.
         * 
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.2", date = "2025-05-08T20:13:25+02:00")
        public void setAutom(short value) {
            this.autom = value;
        }


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
         *         &lt;element name="Temp" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
         *         &lt;element name="Vlaga" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/&gt;
         *         &lt;element name="Tlak" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
         *         &lt;element name="TlakTend" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
         *         &lt;element name="VjetarSmjer" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element name="VjetarBrzina" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
         *         &lt;element name="Vrijeme" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element name="VrijemeZnak" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
            "temp",
            "vlaga",
            "tlak",
            "tlakTend",
            "vjetarSmjer",
            "vjetarBrzina",
            "vrijeme",
            "vrijemeZnak"
        })
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.2", date = "2025-05-08T20:13:25+02:00")
        public static class Podatci {

            @XmlElement(name = "Temp", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.2", date = "2025-05-08T20:13:25+02:00")
            protected BigDecimal temp;
            @XmlElement(name = "Vlaga")
            @XmlSchemaType(name = "unsignedByte")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.2", date = "2025-05-08T20:13:25+02:00")
            protected short vlaga;
            @XmlElement(name = "Tlak", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.2", date = "2025-05-08T20:13:25+02:00")
            protected BigDecimal tlak;
            @XmlElement(name = "TlakTend", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.2", date = "2025-05-08T20:13:25+02:00")
            protected BigDecimal tlakTend;
            @XmlElement(name = "VjetarSmjer", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.2", date = "2025-05-08T20:13:25+02:00")
            protected String vjetarSmjer;
            @XmlElement(name = "VjetarBrzina", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.2", date = "2025-05-08T20:13:25+02:00")
            protected BigDecimal vjetarBrzina;
            @XmlElement(name = "Vrijeme", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.2", date = "2025-05-08T20:13:25+02:00")
            protected String vrijeme;
            @XmlElement(name = "VrijemeZnak", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.2", date = "2025-05-08T20:13:25+02:00")
            protected String vrijemeZnak;

            /**
             * Gets the value of the temp property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.2", date = "2025-05-08T20:13:25+02:00")
            public BigDecimal getTemp() {
                return temp;
            }

            /**
             * Sets the value of the temp property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.2", date = "2025-05-08T20:13:25+02:00")
            public void setTemp(BigDecimal value) {
                this.temp = value;
            }

            /**
             * Gets the value of the vlaga property.
             * 
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.2", date = "2025-05-08T20:13:25+02:00")
            public short getVlaga() {
                return vlaga;
            }

            /**
             * Sets the value of the vlaga property.
             * 
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.2", date = "2025-05-08T20:13:25+02:00")
            public void setVlaga(short value) {
                this.vlaga = value;
            }

            /**
             * Gets the value of the tlak property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.2", date = "2025-05-08T20:13:25+02:00")
            public BigDecimal getTlak() {
                return tlak;
            }

            /**
             * Sets the value of the tlak property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.2", date = "2025-05-08T20:13:25+02:00")
            public void setTlak(BigDecimal value) {
                this.tlak = value;
            }

            /**
             * Gets the value of the tlakTend property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.2", date = "2025-05-08T20:13:25+02:00")
            public BigDecimal getTlakTend() {
                return tlakTend;
            }

            /**
             * Sets the value of the tlakTend property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.2", date = "2025-05-08T20:13:25+02:00")
            public void setTlakTend(BigDecimal value) {
                this.tlakTend = value;
            }

            /**
             * Gets the value of the vjetarSmjer property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.2", date = "2025-05-08T20:13:25+02:00")
            public String getVjetarSmjer() {
                return vjetarSmjer;
            }

            /**
             * Sets the value of the vjetarSmjer property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.2", date = "2025-05-08T20:13:25+02:00")
            public void setVjetarSmjer(String value) {
                this.vjetarSmjer = value;
            }

            /**
             * Gets the value of the vjetarBrzina property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.2", date = "2025-05-08T20:13:25+02:00")
            public BigDecimal getVjetarBrzina() {
                return vjetarBrzina;
            }

            /**
             * Sets the value of the vjetarBrzina property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.2", date = "2025-05-08T20:13:25+02:00")
            public void setVjetarBrzina(BigDecimal value) {
                this.vjetarBrzina = value;
            }

            /**
             * Gets the value of the vrijeme property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.2", date = "2025-05-08T20:13:25+02:00")
            public String getVrijeme() {
                return vrijeme;
            }

            /**
             * Sets the value of the vrijeme property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.2", date = "2025-05-08T20:13:25+02:00")
            public void setVrijeme(String value) {
                this.vrijeme = value;
            }

            /**
             * Gets the value of the vrijemeZnak property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.2", date = "2025-05-08T20:13:25+02:00")
            public String getVrijemeZnak() {
                return vrijemeZnak;
            }

            /**
             * Sets the value of the vrijemeZnak property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.2", date = "2025-05-08T20:13:25+02:00")
            public void setVrijemeZnak(String value) {
                this.vrijemeZnak = value;
            }

        }

    }

}
