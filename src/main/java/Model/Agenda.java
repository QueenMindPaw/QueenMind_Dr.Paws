package Model;

public class Agenda extends BDObject {
    private int petId;
    private int vetId;
    private int assistantId;
    private String datetime;

    public Agenda(int id, int petId, int vetId, int assistantId, String datetime) {
        super(id);
        this.petId = petId;
        this.vetId = vetId;
        this.assistantId = assistantId;
        this.datetime = datetime;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public int getVetId() {
        return vetId;
    }

    public void setVetId(int vetId) {
        this.vetId = vetId;
    }

    public int getAssistantId() {
        return assistantId;
    }

    public void setAssistantId(int assistantId) {
        this.assistantId = assistantId;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }
}
