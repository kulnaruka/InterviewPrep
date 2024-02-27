package basicprogramsforinterview.designpattern.decoraterDesignPatternBurger.burgeraddons;

import basicprogramsforinterview.designpattern.decoraterDesignPatternBurger.burger.KFCBurger;

public class ExtraMayo extends BurgerDecorators {
    private KFCBurger burger;

    public ExtraMayo(KFCBurger burger){
        this.burger = burger;
    }

    @Override
    public String getDescription() {
        return burger.getDescription() + " with Extra Mayo";
    }

    @Override
    public int getCost() {
        return burger.getCost() + 30;
    }

    @Override
    public String toString() {
        return "Burger name:: " + this.getDescription() + ", cost:: " + this.getCost();
    }
}
