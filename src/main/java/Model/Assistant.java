package Model;

public class Assistant extends BDObject {
    private int personId;

    public Assistant(int id, int personId) {
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
