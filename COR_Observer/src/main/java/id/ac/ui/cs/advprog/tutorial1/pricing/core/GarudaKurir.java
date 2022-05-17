package id.ac.ui.cs.advprog.tutorial1.pricing.core;

public class GarudaKurir implements Kurir, Handler<Kurir> {
    private int pricePerKilogram;
    private String name;
    private Handler<Kurir> nextHandler;
    private int specialAddon = 2000;
    
    public GarudaKurir(int pricePerKilogram) {
        // TODO
        this.pricePerKilogram = pricePerKilogram;
        this.name = "Garuda";
    }

    @Override
    public int getSpecialAddon() {
        return specialAddon;
    }

    @Override
    public String getMessage(int weight) {
        return String.format("Menggunakan Kurir %s. " +
                        "fee: %d x %d + %d = %d civil credits",
                getName(), weight, pricePerKilogram, getSpecialAddon(), calculatePrice(weight));
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
        return specialAddon + (weight * this.pricePerKilogram);
    }

    @Override
    public void setNext(Handler<Kurir> handler) {
        this.nextHandler = handler;
    }

    @Override
    public Kurir handle(int request) {
        if (request > 50) {
            return this;
        }
        return this.nextHandler.handle(request);
    }
}
