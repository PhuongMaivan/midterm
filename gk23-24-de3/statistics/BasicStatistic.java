package hus.oop.statistics;

import java.util.Arrays;

public class BasicStatistic implements Statistic {
    private DataSet dataSet;

    /**
     * Hàm dựng khởi tạo tập dữ liệu.
     */
    public BasicStatistic() {
        /* TODO */
        this.dataSet = null;
    }

    public void setDataSet(DataSet dataSet) {
        /* TODO */
        this.dataSet = dataSet;
    }

    @Override
    public int size() {
        /* TODO */
        return this.dataSet.size();
    }

    @Override
    public double max() {
        /* TODO */
        double[] arr = dataSet.elements(0, dataSet.size());
        double max = arr[0];
        for (double item : arr) {
            if (max < item) {
                max = item;
            }
        }
        return max;
    }

    @Override
    public double min() {
        /* TODO */
        double[] arr = dataSet.elements(0, dataSet.size());
        double min = arr[0];
        for (double item : arr) {
            if (min > item) {
                min = item;
            }
        }
        return min;
    }

    @Override
    public double mean() {
        /* TODO */
        double[] arr = dataSet.elements(0, dataSet.size());
        double mean = arr[0];
        for (double item : arr) {
            mean += item;
        }
        return mean / arr.length;
    }

    @Override
    public double variance() {
        /* TODO */
        double[] arr = dataSet.elements(0, dataSet.size());
        double mean = mean();
        double variance = 0;
        for (double item : arr) {
            variance += (item - mean) * (item - mean);
        }
        return variance / arr.length;
    }

    @Override
    public double[] rank() {
        /* TODO */
        double[] arr = dataSet.elements(0, dataSet.size());
        Arrays.sort(arr);
        AbstractDataSet dataSet1 = new ArrayDataSet();
        double temp = arr[0];
        dataSet1.insertAtEnd(temp);
        for (double item : arr) {
            if (temp < item) {
                temp = item;
                dataSet1.insertAtEnd(temp);
            }
        }
        return dataSet1.elements(0, dataSet1.size());
    }

    @Override
    public double median() {
        /* TODO */
        double[] arr = dataSet.elements(0, dataSet.size());
        Arrays.sort(arr);
        if (arr.length % 2 == 1) {
            return arr[arr.length / 2];
        }
        return (arr[arr.length / 2] + arr[arr.length / 2 - 1]) / 2;
    }
}
