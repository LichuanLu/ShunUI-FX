package models;

/**
 * Created with IntelliJ IDEA.
 * User: labuser
 * Date: 15/07/13
 * Time: 04:00
 * To change this template use File | Settings | File Templates.
 */


/** Data extra values for high and low. */
public class LineExtraValues <Y> {
    private Y high;
    private Y low;

    public LineExtraValues(Y low, Y high) {
        this.high = high;
        this.low = low;
    }

    public Y getHigh() {
        return high;
    }

    public Y getLow() {
        return low;
    }


}