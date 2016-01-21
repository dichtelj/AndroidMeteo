package durotm_dichtelj.javaClasses;

/**
 * Created by dichtelj on 17/12/2015.
 */
public class Station {

    private String nom;
    private String prenom;
    private double latitude;
    private double longitude;
    private int altitude;

    public Station(String nom, String prenom, double latitude, double longitude, int altitude) {
        this.nom = nom;
        this.prenom = prenom;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }
}
