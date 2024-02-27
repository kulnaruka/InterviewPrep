package basicprogramsforinterview.designpattern.decoraterDesignPatternBurger.burger;

public class ZingerBurger extends KFCBurger {

    @Override
    public String getDescription() {
        return "Zinger Burger";
    }

    @Override
    public int getCost() {
        return 100;
    }

    @Override
    public String toString() {
        return "Burger name:: " + this.getDescription() + ", cost:: " + this.getCost();
    }
}
