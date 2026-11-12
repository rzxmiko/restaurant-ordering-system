package observer;

public enum OrderStatus {
    ACCEPTED("Accepted"),
    PREPARING("Preparing"),
    READY("Ready");

    private final String title;

    OrderStatus(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}