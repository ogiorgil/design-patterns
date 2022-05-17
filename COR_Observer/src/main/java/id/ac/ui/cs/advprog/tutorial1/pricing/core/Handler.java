package id.ac.ui.cs.advprog.tutorial1.pricing.core;

public interface Handler<T> {
    void setNext(Handler<T> handler);
    T handle(int request);
}
