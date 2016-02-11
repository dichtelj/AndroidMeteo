package durotm_dichtelj.javaClasses;

/**
 * Created by dichtelj on 17/12/2015.
 */
public class Station {

    private String nom;
    private String libelle;
    private String latitude;
    private String longitude;
    private String altitude;

    public Station(String nom, String libelle, String latitude, String longitude, String altitude) {
        this.nom = nom;
        this.libelle = libelle;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getAltitude() {
        return altitude;
    }

    public void setAltitude(String altitude) {
        this.altitude = altitude;
    }
}
