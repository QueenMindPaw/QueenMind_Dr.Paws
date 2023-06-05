package Model;

public class AppoEquip {
    private int appoId;
    private int equipId;
    private int quantity;

    public AppoEquip(int appoId, int equipId, int quantity) {
        this.appoId = appoId;
        this.equipId = equipId;
        this.quantity = quantity;
    }

    public int getAppoId() {
        return appoId;
    }

    public void setAppoId(int appoId) {
        this.appoId = appoId;
    }

    public int getEquipId() {
        return equipId;
    }

    public void setEquipId(int equipId) {
        this.equipId = equipId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
