package basicprogramsforinterview.designpattern.decoraterDesignPatternBurger.burger;

public abstract class KFCBurger {

    private String description;
    private int cost;

    public abstract String getDescription();
    public abstract int getCost();

    @Override
    public abstract String toString();
}
