package hus.oop.gkk1_2425.statistics;

import java.util.ArrayList;
import java.util.List;

public class ListDataSet extends AbstractDataSet {
    private List<Double> data;

    public ListDataSet() {
        data = new ArrayList<>();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public double getAt(int index) {
        return data.get(index);
    }

    @Override
    public double[] getAll(int from, int to) {
        double[] result = new double[to - from + 1];
        for (int i = from; i <= to; i++) {
            result[i - from] = data.get(i);
        }
        return result;
    }

    @Override
    public void append(double value) {
        data.add(value);
    }

    @Override
    public void insert(int index, double value) {
        data.add(index, value);
    }

    @Override
    public void remove(int index) {
        data.remove(index);
    }

    @Override
    public void remove(double value) {
        data.removeIf(d -> d == value);
    }
}