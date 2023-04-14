package com.multithreadedstore;

import com.multithreadedstore.customer.Customer;
import com.multithreadedstore.product.Product;
import com.multithreadedstore.store.Store;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main thread has started..");
        Product shirt = new Product("Gucci", 12000, 10);
        Product sneakers = new Product("Nike", 10000, 10);
        Product belt = new Product("Prada", 12000, 10);
        Product glasses = new Product("Givenchy", 1000, 10);
        Product socks = new Product("Off White", 2000, 10);
        List<Product> products = new ArrayList<>(List.of(shirt, sneakers, belt, glasses, socks));
        Store store = new Store("Jasperking Stores", products, 20000);


        Customer c1 = new Customer("Tony", 1_200, store);
        Customer c2 = new Customer("Tinubu", 200_000, store);
        Customer c3 = new Customer("Isaac", 500_000, store);
        Customer c4 = new Customer("Bola", 100_000, store);
        Customer c5 = new Customer("Stephen", 5000, store);
        Customer c6 = new Customer("Joseph",1000, store);

        c1.addToCart(shirt, 2);
        c1.addToCart(sneakers, 2);
        c1.addToCart(belt, 1);

        c2.addToCart(shirt, 1);

        c3.addToCart(shirt, 1);

        c4.addToCart(shirt, 1);
        c4.addToCart(belt, 1);
        c5.addToCart(glasses, 3);
        c6.addToCart(shirt, 5000);



        Thread t1 = new Thread(c1, c1.getName());
        Thread t2 = new Thread(c2, c2.getName());
        Thread t3 = new Thread(c3, c3.getName());
        Thread t4 = new Thread(c4, c4.getName());
        Thread t5 = new Thread(c5, c5.getName());
        Thread t6 = new Thread(c6,c6.getName());


        t1.start(); t2.start(); t3.start(); t4.start(); t5.start(); t6.start();
        try {
            t1.join();t2.join();t3.join();t4.join(); t5.join(); t6.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Store products: " + store.getStoreProducts());
        System.out.println("Store balance: $" + store.getStoreBalance());
        System.out.println("Main thread has ended..");
    }
}