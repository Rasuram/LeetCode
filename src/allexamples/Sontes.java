package allexamples;

import java.util.Arrays;

// you can also use imports, for example:
import java.util.*;

/*
const products = [
  {
    productId: "FOO1234",
    price: 20.0
  },
  {
    productId: "BAR543",
    price: 15.99
  },
  {
    productId: "BAZ987",
    price: 35.75
  }
];

const coupons = [
  {
    code: "SAVE10PCT",
    discountType: "PERCENT_OFF_ORDER",
    discountAmount: 10
  },
  {
    code: "FIVEBUXOFF",
    discountType: "DOLLARS_OFF_ORDER",
    discountAmount: 5
  },
  {
    code: "CHEAPFOO",
    discountType: "DOLLARS_OFF_ITEM",
    discountAmount: 2,
    productId: "FOO1234"
  }
];
*/

public class Sontes {



    public static class Product{
        String productId;
        double price;

        Product(String productId, double price){
            this.productId = productId;
            this.price = price;
        }
    }


    public static class Coupon {
        String code;
        String discountType;
        int discountAmount;
        String productId;
        Coupon(String code, String discountType, int discount, String productId){
            this.productId = productId;
            this.code = code;
            this.discountType = discountType;
            this.discountAmount = discount;
        }
    }



    public String getMaxDiscountCouponCode(List<Product> products, List<Coupon> coupons){


        String maxCouponCode="";
        double discountAmount = 0.0;
        for(Coupon coupon : coupons){

            double orderAmount = totalOrderAmopunt(products);//70
            if(coupon.discountType=="PERCENT_OFF_ORDER"){
                double currentDiscount = orderAmount%coupon.discountAmount;//7
                if(discountAmount<currentDiscount){
                    maxCouponCode = coupon.code;
                }
            }

            if(coupon.discountType=="DOLLARS_OFF_ORDER"){
                if(discountAmount<(coupon.discountAmount)){
                    maxCouponCode = coupon.code;
                }
            }

            if(coupon.discountType=="DOLLARS_OFF_ITEM"){
                if(isProductExist(products, coupon.productId) && discountAmount<(coupon.discountAmount)){
                    maxCouponCode = coupon.code;
                }
            }
        }
        return maxCouponCode;
    }


    public boolean isProductExist(List<Product> products, String productId){
        for(Product p : products){
            if(productId.equals(p.productId)){
                return true;
            }
        }
        return false;
    }


    public double totalOrderAmopunt(List<Product> products){
        double totalAmount=0.0;
        for(Product p : products){
            totalAmount+=p.price;
        }
        return totalAmount;
    }






    public final static void main(String [] args) {
        // you can write to stdout for debugging purposes, e.g.
        System.out.println("This is a debug message");
        final String s ="s";



        Product p1 = new Product("FOO1234",20.0);
        Product p2 = new Product("BAR543",15.99);
        Product p3 = new Product("BAZ987",35.75);
        int[] input = {5, 12, 3, 21, 8, 7, 19, 102, 201};
        List<Integer> evens = new ArrayList<Integer>();
        List<Integer> odds = new ArrayList<Integer>();
        for (int i : input) {
            if (i % 2 == 0) {
                evens.add(i);
            } else {
                odds.add(i);
            }
        }
        System.out.println(evens.addAll(odds));
    }
}

