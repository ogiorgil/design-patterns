package id.ac.ui.cs.advprog.tutorial1.pricing.core;

public class BetaAsuransi implements Asuransi, Handler<Asuransi> {
    private int price;
    private String name;
    private Handler<Asuransi> nextHandler;
    
    public BetaAsuransi(int price) {
        // TODO
        this.name = "Beta";
        this.price = price;
    }

    @Override
    public String getName() {
        // TODO
        return this.name;
    }

    @Override
    public int getPrice() {
        // TODO
        return this.price;
    }

    @Override
    public String getMessage() {
        return String.format("Menggunakan asuransi %s" +
                ". fee: %d civil credits", getName(), getPrice());
    }

    @Override
    public void setNext(Handler<Asuransi> handler) {
        this.nextHandler = handler;
    }

    @Override
    public Asuransi handle(int request) {
        if (request < 1000) {
            return this;
        }
        return this.nextHandler.handle(request);
    }
}
