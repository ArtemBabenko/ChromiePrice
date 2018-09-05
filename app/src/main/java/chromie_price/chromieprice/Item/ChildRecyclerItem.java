package chromie_price.chromieprice.Item;

public class ChildRecyclerItem {

    private String name;
    private int image;
    private int current;
    private int previous;
    private int difference;
    private int toPay;

    public ChildRecyclerItem(String name, int image, int current, int previous, int difference, int toPay) {

        this.name = name;
        this.image = image;
        this.current = current;
        this.previous = previous;
        this.difference = difference;
        this.toPay = toPay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getPrevious() {
        return previous;
    }

    public void setPrevious(int previous) {
        this.previous = previous;
    }

    public int getDifference() {
        return difference;
    }

    public void setDifference(int difference) {
        this.difference = difference;
    }

    public int getToPay() {
        return toPay;
    }

    public void setToPay(int toPay) {
        this.toPay = toPay;
    }
}
