package edu.hillel.nikolenko.homeworks.homework14_stream;

import java.time.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        Product book1 = new Product("Book", 50, true, "2023-01-01");
        Product book2 = new Product("Book", 250, false, "2022-05-20");
        Product book3 = new Product("Book", 300, true, "2022-08-10");

        Product phone1 = new Product("Phone", 10000, false, "2022-03-09");
        Product phone2 = new Product("Phone", 15000, false, "2023-02-01");
        Product phone3 = new Product("Phone", 20000, true, "2022-10-08");

        Product sofa1 = new Product("Furniture", 8000, false, "2023-04-05");
        Product sofa2 = new Product("Furniture", 12000, true, "2023-07-30");
        Product sofa3 = new Product("Furniture", 18000, false, "2022-09-19");

        List<Product> products = new ArrayList<>(Arrays.asList(book1, book2, book3, phone1, phone2, phone3, sofa1, sofa2, sofa3));

        System.out.println("productsList: " + products);
        System.out.println();

        System.out.println("getProductByPrice: " + getProductByPrice(products, "Book", 250));
        System.out.println("getProductWithDiscount: " + getProductWithDiscount(products, "Book", 10));
        System.out.println("getTheCheapestProduct: " + getTheCheapestProduct(products, "Book"));
//        System.out.println("getTheCheapestProduct: " + getTheCheapestProduct(products, "Clothes")); --Exception
        System.out.println("getLastThreeProduct: " + getLastThreeProduct(products));
        System.out.println("getTotalPrice: " + getTotalPrice(products, "Book", 75));
        System.out.println("getGroupOfProducts: " + getGroupOfProducts(products));

    }

    public static List<Product> getProductByPrice(List<Product> list, String category, double price) {
        return list.stream()
                .filter(product -> product.getType() == category)
                .filter(product -> product.getPrice() >= price)
                .collect(Collectors.toList());
    }

    public static List<Product> getProductWithDiscount(List<Product> list, String category, double discount) {
        List<Product> collect = list.stream()
                .filter(product -> product.getType() == category)
                .filter(product -> product.isApplyDiscount())
                .map(product -> {
                    product.setPrice(product.getPrice() - product.getPrice() * discount / 100);
                    return product;
                })
                .collect(Collectors.toList());
        return collect;
    }

    public static Product getTheCheapestProduct(List<Product> list, String category) throws Exception {
        Optional<Product> min = list.stream()
                .filter(product -> product.getType() == category)
                .min(Comparator.comparing(Product::getPrice));

        if(min.isPresent()) {
            return min.get();
        } else {
            throw new Exception("Product from category " + category + " was not found");
        }
    }

    public static List<Product> getLastThreeProduct(List<Product> list) {
        List<Product> l = new ArrayList<>(list);
        List<Product> lastThree = new ArrayList<>();

        for(int i = 0; i < 3; i++) {
            LocalDate date = l.stream()
                    .map(Product::getAddingDate)
                    .max(LocalDate::compareTo)
                    .get();

            Product max = l.stream()
                    .filter(product -> product.getAddingDate() == date)
                    .collect(Collectors.toList())
                    .get(0);

            lastThree.add(max);
            l.remove(max);
        }

        return lastThree;
    }

    public static double getTotalPrice(List<Product> list, String category, double price) {
        double totalPrice = 0;

        List<Product> collect = list.stream()
                .filter(product -> product.getAddingDate().getYear() == 2023)
                .filter(product -> product.getPrice() <= price)
                .collect(Collectors.toList());
        for (Product product : collect) {
            totalPrice += product.getPrice();
        }

        return totalPrice;
    }

    public static Map<String, List<Product>> getGroupOfProducts(List<Product> list) {
        Map<String, List<Product>> categories = list.stream()
                .collect(Collectors.groupingBy(Product::getType));
        return categories;
    }
}
