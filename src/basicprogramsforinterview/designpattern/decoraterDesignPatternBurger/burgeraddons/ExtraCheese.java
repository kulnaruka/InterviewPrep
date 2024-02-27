package basicprogramsforinterview.designpattern.decoraterDesignPatternBurger.burgeraddons;

import basicprogramsforinterview.designpattern.decoraterDesignPatternBurger.burger.KFCBurger;

public class ExtraCheese extends BurgerDecorators {

    private KFCBurger burger;

    public ExtraCheese(KFCBurger burger){
        this.burger = burger;
    }

    @Override
    public String getDescription() {
        return burger.getDescription() + " with Extra cheese";
    }

    @Override
    public int getCost() {
        return burger.getCost() + 20;
    }

    @Override
    public String toString() {
        return "Burger name:: " + this.getDescription() + ", cost:: " + this.getCost();
    }
}
