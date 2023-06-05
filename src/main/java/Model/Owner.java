package Model;

public class Owner extends BDObject {
    private int personId;

    public Owner(int id, int personId) {
        super(id);
        this.personId = personId;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }
}
