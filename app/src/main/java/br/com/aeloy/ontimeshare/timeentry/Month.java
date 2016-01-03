package br.com.aeloy.ontimeshare.timeentry;

/**
 * Created by hastronauta on 1/3/16.
 */
public enum Month {
    JANUARY(1),
    FEBRUARY(2),
    MARCH(3),
    APRIL(4),
    MAY(5),
    JUNE(6),
    JULY(7),
    AUGUST(8),
    SEPTEMBER(9),
    OCTOBER(10),
    NOVEMBER(11),
    DECEMBER(12);

    private int index;

    private Month(int index) {
        this.index = index;
    }

    public String numeric() {
        return Integer.toString(index);
    }
}
