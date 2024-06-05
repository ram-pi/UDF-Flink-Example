package io.confluent.flink.table.modules.remoteudf;

import com.github.javafaker.Faker;
import org.apache.flink.table.functions.ScalarFunction;

import java.util.Random;

/**
 * Item Name retrieve function for demo.
 */
public class RetrieveItemName extends ScalarFunction {

//    String[] products = {
//            "Chair", "Car", "Computer", "Gloves", "Pants", "Shirt", "Table",
//            "Shoes", "Hat", "Plate", "Knife", "Bottle", "Coat", "Lamp",
//            "Keyboard", "Bag", "Bench", "Clock", "Watch", "Wallet"
//    };

    public static void main(String[] args) {
        RetrieveItemName retrieveItemName = new RetrieveItemName();
        System.out.println(retrieveItemName.eval("item_04"));
    }

    static long stringToSeed(String s) {
        if (s == null) {
            return 0;
        }
        long hash = 0;
        for (char c : s.toCharArray()) {
            hash = 31L * hash + c;
        }
        return hash;
    }

    public String eval(String s1) {
        Faker faker = new Faker(new Random(stringToSeed(s1)));
        return getRandomItemName(faker);
    }

    public String getRandomItemName(Faker faker) {
        return faker.commerce().productName();
    }

//    public String eval(String s1) {
//        Random random = new Random(stringToSeed(s1));
//        return products[random.nextInt(products.length)];
//    }
}


