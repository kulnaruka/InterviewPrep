package basicprogramsforinterview.designpattern.observerDesignPatternWeatherStation.observers;

import basicprogramsforinterview.designpattern.observerDesignPatternWeatherStation.dataset.DataSets;
import basicprogramsforinterview.designpattern.observerDesignPatternWeatherStation.Observer;

public class SystemTwo implements Observer {

    DataSets dataSets;

    @Override
    public String toString() {
        return "SystemTwo{" +
                "dataSets=" + dataSets +
                '}';
    }

    @Override
    public void update(DataSets dataSets) {
        this.dataSets = dataSets;
        System.out.println("The system two new data sets defined are: " + dataSets);
    }
}
