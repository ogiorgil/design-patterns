package id.ac.ui.cs.advprog.tutorial1.pricing.core;

public class KudaKurir implements Kurir, Handler<Kurir> {
    private int pricePerKilogram;
    private String name;
    private Handler<Kurir> nextHandler;

    public KudaKurir(int pricePerKilogram) {
        // TODO
        this.pricePerKilogram = pricePerKilogram;
        this.name = "Kuda";
    }

    @Override
    public int getSpecialAddon() {
        return 0;
    }

    @Override
    public String getMessage(int weight) {
        return String.format("Menggunakan Kurir %s. " +
                        "fee: %d x %d = %d civil credits",
                getName(), weight, pricePerKilogram, calculatePrice(weight));
    }

    @Override
    public int getPricePerKilo() {
        return this.pricePerKilogram;
    }


    public String getName() {
        // TODO
        return name;
    }

    public int calculatePrice(int weight) {
        // TODO
        return weight * this.pricePerKilogram;
    }

    @Override
    public void setNext(Handler<Kurir> handler) {
        this.nextHandler = handler;
    }

    @Override
    public Kurir handle(int request) {
        if (10 <= request && request <= 50) {
            return this;
        }
        return this.nextHandler.handle(request);
    }
}
