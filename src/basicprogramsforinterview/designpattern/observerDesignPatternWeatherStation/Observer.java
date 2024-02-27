package basicprogramsforinterview.designpattern.observerDesignPatternWeatherStation;

import basicprogramsforinterview.designpattern.observerDesignPatternWeatherStation.dataset.DataSets;

public interface Observer {
    void update(DataSets dataSets);
}
