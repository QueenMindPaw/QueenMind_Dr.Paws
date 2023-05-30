package Model;

public class veterinarian extends person {

    private int vetID; //Autoincremental en la BD
    private String speciality;

    public veterinarian(){
    }

    public veterinarian(int vetID, int personID,  String name, String appat, String ammat, String telf ,String email, String password ,String speciality) {
        super(personID, name, appat, ammat, telf, email, password);
        this.vetID = vetID;
        this.speciality = speciality;
    }

    public veterinarian(int vetID, String name, String appat, String ammat, String telf ,String email, String password ,String speciality) {
        super(name, appat, ammat, telf, email, password);
        this.vetID = vetID;
        this.speciality = speciality;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
