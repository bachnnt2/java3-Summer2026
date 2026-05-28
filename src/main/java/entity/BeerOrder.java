package entity;

public class BeerOrder {
    // tạo các thuộc
    private int orderId;
    private int customerId;
    private String customerName;
    private String beerName;
    private int quantity;

    public BeerOrder(int quantity, String beerName, String customerName, int customerId, int orderId) {
        this.quantity = quantity;
        this.beerName = beerName;
        this.customerName = customerName;
        this.customerId = customerId;
        this.orderId = orderId;
    }

    public BeerOrder(String customerName, String beerName, int quantity) {
        this.customerName = customerName;
        this.beerName = beerName;
        this.quantity = quantity;
    }

    public BeerOrder() {
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getBeerName() {
        return beerName;
    }

    public void setBeerName(String beerName) {
        this.beerName = beerName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "BeerOrder{" +
                "orderId=" + orderId +
                ", customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", beerName='" + beerName + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
