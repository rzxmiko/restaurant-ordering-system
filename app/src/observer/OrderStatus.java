package observer;

public enum OrderStatus {
    ACCEPTED("Принят"),
    PREPARING("Готовится"),
    READY("Готов");

    private final String title;

    OrderStatus(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}