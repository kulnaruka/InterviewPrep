package basicprogramsforinterview.designpattern.observerDesignPatternWeatherStation;

import basicprogramsforinterview.designpattern.observerDesignPatternWeatherStation.dataset.DataSets;
import basicprogramsforinterview.designpattern.observerDesignPatternWeatherStation.observable.WeatherStation;
import basicprogramsforinterview.designpattern.observerDesignPatternWeatherStation.observers.SystemOne;
import basicprogramsforinterview.designpattern.observerDesignPatternWeatherStation.observers.SystemTwo;

import java.util.List;

/**
 * The Observable design pattern is a behavioral pattern that facilitates communication between objects in a system by
 * defining a one-to-many dependency between objects.
 * In this pattern, when the state of one object changes, all its dependents (observers) are notified and updated automatically.
 * This promotes loose coupling between objects, as the subject (the object being observed) doesn't need to know
 * anything about its observers, only that they implement a certain interface.
 *
 * Here's a basic overview of the participants in the Observable pattern:
 *
 * - > Subject (Observable): This is the object being observed. It maintains a list of observers and provides methods
 * to add, remove, and notify observers of any changes in its state.
 *
 * -> Observer: This is the interface that defines the method(s) to be called when the subject's state changes.
 * Observers register with the subject to receive notifications.
 *
 * -> Concrete Subject: This is the actual implementation of the subject interface.
 * It maintains the state and sends notifications to its observers when the state changes.
 *
 * -> Concrete Observer: This is the actual implementation of the observer interface.
 * It registers itself with the subject to receive notifications and implements the method(s) to be called when notified.
 *
 * Usage of the Observable pattern:
 *
 * -> Event Handling: Observable pattern is widely used in event handling systems.
 * For instance, in graphical user interfaces (GUIs), components often act as subjects that notify observers (event listeners)
 * when events like button clicks or mouse movements occur.
 *
 * -> Model-View-Controller (MVC): In MVC architecture, the Observable pattern can be used to implement the model layer.
 * The model maintains the application state and notifies views (observers) of any changes,
 * allowing the views to update accordingly.
 *
 * -> Publish-Subscribe Systems: Observable pattern forms the basis of publish-subscribe systems,
 * where publishers (subjects) publish messages and subscribers (observers) receive notifications for the messages they are interested in.
 *
 * -> Caching and Dependency Management: Observable pattern can be used in caching systems or dependency management
 * frameworks, where objects need to be notified of changes to data or dependencies.
 *
 * Overall, the Observable pattern promotes a decoupled and flexible design, making it easier to maintain
 * and extend systems by allowing objects to communicate without being tightly coupled.
 */

public class ObserverDesignPatternImpl {


    public static void main(String[] args) {
        SystemOne sys1 = new SystemOne();
        SystemTwo sys2 = new SystemTwo();

        WeatherStationObservable weatherStation = new WeatherStation();
        weatherStation.addObserver(sys1);
        weatherStation.addObserver(sys2);
        DataSets dataSets = new DataSets(24, 56);
        weatherStation.notify(weatherStation.getObserverList(),dataSets);

        System.out.println(weatherStation.getObserverList());
        //weatherStation.getObserverList().forEach(observer -> System.out.println(observer.toString()));

    }

}
