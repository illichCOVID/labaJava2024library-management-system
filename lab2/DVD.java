package items;

public class DVD extends Item {
    private int duration; // in minutes

    public DVD(String title, String uniqueID, int duration) {
        super(title, uniqueID);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public void borrowItem() {
        if (!isBorrowed()) {
            setBorrowed(true);
        }
    }

    @Override
    public void returnItem() {
        if (isBorrowed()) {
            setBorrowed(false);
        }
    }
}
