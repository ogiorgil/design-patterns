package id.ac.ui.cs.advprog.tutorial1.pricing.core;

public interface Kurir {
    String getName();
    int calculatePrice(int weight);
    int getPricePerKilo();
    int getSpecialAddon();
    String getMessage(int weight);
}
