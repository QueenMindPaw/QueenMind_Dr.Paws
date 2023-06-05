package Model;

public class person extends BDObject{
    private String name;
    private String appat;
    private String ammat;
    private String email;
    private String password;
    
    public person(){
    }

    public person(int id, String name, String appat, String ammat, String email, String password) {
        super(id);
        this.name = name;
        this.appat = appat;
        this.ammat = ammat;
        this.email = email;
        this.password = password;
    }

    public person(String name, String appat, String ammat, String email, String password) {
        super();
        this.name = name;
        this.appat = appat;
        this.ammat = ammat;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAppat() {
        return appat;
    }

    public void setAppat(String appat) {
        this.appat = appat;
    }

    public String getAmmat() {
        return ammat;
    }

    public void setAmmat(String ammat) {
        this.ammat = ammat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return password;
    }

    @Override
    public String toString(){
        return "person{" + "id=" + getId() + ", name=" + name + ", appat=" + appat + ", ammat=" + ammat + ", email=" + email + ", password=" + password + '}';
    }
}
