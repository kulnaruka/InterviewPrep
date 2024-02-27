package basicprogramsforinterview.designpattern.decoraterDesignPatternBurger;

import basicprogramsforinterview.designpattern.decoraterDesignPatternBurger.burger.KFCBurger;
import basicprogramsforinterview.designpattern.decoraterDesignPatternBurger.burger.ZingerBurger;
import basicprogramsforinterview.designpattern.decoraterDesignPatternBurger.burgeraddons.ExtraCheese;
import basicprogramsforinterview.designpattern.decoraterDesignPatternBurger.burgeraddons.ExtraMayo;

/**
 * Decorator design pattern is the usage and simple implementation or achieved by the classic use of run-time polymorphism
 *
 * Other example of it are :
 * 1. calculating Hotel charges of a room with extra facilities like spa, items from freezers, laundry costs etc
 * 2.
 */


public class DecoratorDesignPatternMain {

    public static void main(String[] args) {
        KFCBurger burger = new ZingerBurger();
        System.out.println(burger);

        burger = new ExtraCheese(burger);
        System.out.println(burger);
        burger = new ExtraMayo(burger);
        System.out.println(burger);
    }


}
