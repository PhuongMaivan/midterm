package hus.oop.gkk1_2425.statistics;

public class BasicStatistic implements Statistic {
    private DataSet dataSet;

    public BasicStatistic() {
        this.dataSet = new ArrayDataSet();
    }

    public void setDataSet(DataSet dataSet) {
        this.dataSet = dataSet;
    }

    @Override
    public int size() {
        return dataSet.size();
    }

    @Override
    public double max() {
        if (size() == 0) throw new IllegalStateException("Dataset is empty");
        double max = dataSet.getAt(0);
        for (int i = 1; i < size(); i++) {
            double current = dataSet.getAt(i);
            if (current > max) max = current;
        }
        return max;
    }

    @Override
    public double min() {
        if (size() == 0) throw new IllegalStateException("Dataset is empty");
        double min = dataSet.getAt(0);
        for (int i = 1; i < size(); i++) {
            double current = dataSet.getAt(i);
            if (current < min) min = current;
        }
        return min;
    }

    @Override
    public double mean() {
        if (size() == 0) throw new IllegalStateException("Dataset is empty");
        double sum = 0;
        for (int i = 0; i < size(); i++) {
            sum += dataSet.getAt(i);
        }
        return sum / size();
    }

    @Override
    public double variance() {
        if (size() == 0) throw new IllegalStateException("Dataset is empty");
        double mean = mean();
        double sum = 0;
        for (int i = 0; i < size(); i++) {
            double diff = dataSet.getAt(i) - mean;
            sum += diff * diff;
        }
        return sum / size();
    }

    @Override
    public double[] rank() {
        if (size() == 0) throw new IllegalStateException("Dataset is empty");
        double[] ranks = new double[size()];
        for (int i = 0; i < size(); i++) {
            int count = 1;
            for (int j = 0; j < size(); j++) {
                if (dataSet.getAt(j) < dataSet.getAt(i)) {
                    count++;
                }
            }
            ranks[i] = count;
        }
        return ranks;
    }

    @Override
    public double median() {
        if (size() == 0) throw new IllegalStateException("Dataset is empty");
        double[] sorted = dataSet.getAll(0, size() - 1);
        java.util.Arrays.sort(sorted);
        if (size() % 2 == 1) {
            return sorted[size() / 2];
        } else {
            return (sorted[size() / 2 - 1] + sorted[size() / 2]) / 2;
        }
    }
}