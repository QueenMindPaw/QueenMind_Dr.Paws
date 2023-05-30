package Model;

public class owner {

    private int ownerID; // Auto-generated in the database

    public owner(int ownerID, int personID) {
        super(personID); // Invoking superclass constructor
        this.ownerID = ownerID;
    }
    public owner(String correo, String nombre, String appat, String apmat, String dir, String password) {
        this.correo = correo;
        this.nombre = nombre;
        this.appat = appat;
        this.apmat = apmat;
        this.dir = dir;
        this.password = password;
    }

    public owner(int id_propietario, String correo, String nombre, String appat, String apmat, String dir, String password){
        this(correo, nombre, appat, apmat, dir, password);
        this.id_propietario = id_propietario;
    }

    public owner(int id_propietario, String correo, String nombre, String appat, String apmat, String dir){
        this.id_propietario = id_propietario;
        this.correo = correo;
        this.nombre = nombre;
        this.appat = appat;
        this.apmat = apmat;
        this.dir = dir;

    }
    

    
    public owner(String correo, String password){
        this.correo = correo;
        this.password = password;
    }

    public int getId_propietario() {
        return id_propietario;
    }

    public void setId_propietario(int id_propietario) {
        this.id_propietario = id_propietario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAppat() {
        return appat;
    }

    public void setAppat(String appat) {
        this.appat = appat;
    }

    public String getApmat() {
        return apmat;
    }

    public void setApmat(String apmat) {
        this.apmat = apmat;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
