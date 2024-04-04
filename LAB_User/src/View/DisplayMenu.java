package View;

public abstract class DisplayMenu {
    public String[] options;

    public DisplayMenu(String[] options) {
        this.options = options;
    }

    public abstract void display();
    public abstract void handleChoice();
}
