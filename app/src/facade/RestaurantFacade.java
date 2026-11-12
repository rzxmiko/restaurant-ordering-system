package facade;

import builder.OrderRequest;
import observer.CustomerObserver;
import observer.KitchenObserver;
import observer.Order;
import observer.OrderStatus;
import strategy.CashPayment;
import strategy.PaymentProcessor;

public class RestaurantFacade {
    private final KitchenObserver kitchen = new KitchenObserver();
    private final PaymentProcessor paymentProcessor;
    private int nextOrderId;

    public RestaurantFacade(int firstOrderId) {
        this.nextOrderId = firstOrderId;
        this.paymentProcessor = new PaymentProcessor(new CashPayment());
    }

    public RestaurantFacade() {
        this(100);
    }

    public Order placeOrder(OrderRequest request) {
        System.out.println("\n>>> New order from " + request.getCustomerName()
                + (request.isTakeaway() ? " (takeaway)" : " (table " + request.getTableNumber() + ")"));
        if (!request.getNote().isEmpty()) {
            System.out.println("    Note: " + request.getNote());
        }

        Order order = new Order(nextOrderId++, request.getDish());
        order.attach(kitchen);
        order.attach(new CustomerObserver(request.getCustomerName()));
        order.setStatus(OrderStatus.ACCEPTED);

        paymentProcessor.setStrategy(request.getPaymentStrategy());
        double paid = paymentProcessor.pay(request.getDish().getCost());

        order.setStatus(OrderStatus.PREPARING);
        order.setStatus(OrderStatus.READY);

        printReceipt(order, request, paid);
        return order;
    }

    private void printReceipt(Order order, OrderRequest request, double paid) {
        System.out.println("----- Receipt #" + order.getId() + " -----");
        System.out.println("Customer: " + request.getCustomerName());
        System.out.println("Dish:     " + request.getDish().getDescription());
        System.out.println("Price:    " + request.getDish().getCost() + " KZT");
        System.out.println("Payment:  " + request.getPaymentStrategy().getName());
        System.out.println("Paid:     " + paid + " KZT");
        System.out.println("Status:   " + order.getStatus().getTitle());
        System.out.println("-------------------------");
    }
}