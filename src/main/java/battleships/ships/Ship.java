package battleships.ships;

public interface Ship {
    // Ships length
    int length = 0;

    // Ships width
    int width = 0;

    // Getter Setter
    public abstract int getLength();

    public abstract void setLength(int length);

    public abstract int getWidth();

    public abstract void setWidth(int width);
}
