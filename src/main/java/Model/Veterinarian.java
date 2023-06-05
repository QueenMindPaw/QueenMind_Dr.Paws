package Model;

public class Veterinarian extends BDObject {
    private int personId;
    private String specialization;

    public Veterinarian(int id, int personId, String specialization) {
        super(id);
        this.personId = personId;
        this.specialization = specialization;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
