package basicprogramsforinterview.designpattern.stateDesignPatternVendingMachine;


/**
 * We are going to create a VENDING Machine by implementing the State design pattern
 *
 * There are total 3 state of a vending machine:
 * 1. no coin inserted state
 * 2. coin inserted state
 * 3. dispense state
 *
 * based on three states 3 functions can be performed by the vending machine on 3 different actions form the user
 *
 */
public interface State {
    void insertCoin(double amt);
    void pressButton(int aisleNo);
    void dispense(int aisleNo);
}
