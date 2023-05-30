package Model;

public class person extends BDObject{
    private int ownerID; // Auto-incremental in the database

    public void owner(int ownerID, int personID) {
        super(personID);
        this.ownerID = ownerID;
    }

    public void owner() {
    }


    public void owner(int ownerID) {
        super();
        this.ownerID = ownerID;
    }


    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }
}
