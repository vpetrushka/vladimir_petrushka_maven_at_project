package needstobesorted.classwork.day20;

public class Ingridient {

    public String itemdescription;
    public int quantity;

    public Ingridient(String itemdescription, int quantity) {
        this.itemdescription = itemdescription;
        this.quantity = quantity;
    }

    public String getItemdescription() {
        return itemdescription;
    }

    public void setItemdescription(String itemdescription) {
        this.itemdescription = itemdescription;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ingridient)) return false;

        Ingridient that = (Ingridient) o;

        if (quantity != that.quantity) return false;
        return itemdescription != null ? itemdescription.equals(that.itemdescription) : that.itemdescription == null;
    }

    @Override
    public int hashCode() {
        int result = itemdescription != null ? itemdescription.hashCode() : 0;
        result = 31 * result + quantity;
        return result;
    }
}
