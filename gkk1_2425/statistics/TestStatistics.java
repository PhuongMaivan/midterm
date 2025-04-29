package hus.oop.gkk1_2425.statistics;

import java.util.Random;

public class TestStatistics {
    public static void main(String[] args) {
        System.out.println("Testing ArrayDataSet:");
        testArrayDataSet();

        System.out.println("\nTesting ListDataSet:");
        testListDataSet();
    }

    public static void testArrayDataSet() {
        Random random = new Random();
        int n = 10 + random.nextInt(11); // Random between 10-20

        ArrayDataSet dataSet = new ArrayDataSet();
        BasicStatistic stats = new BasicStatistic();
        stats.setDataSet(dataSet);

        // Add random numbers
        System.out.println("Adding " + n + " random numbers:");
        for (int i = 0; i < n; i++) {
            double value = random.nextDouble() * 100;
            dataSet.append(value);
        }

        printStatistics(dataSet, stats);

        // Remove first and last elements
        if (n > 1) {
            dataSet.remove(0);
            dataSet.remove(dataSet.size() - 1);
            System.out.println("\nAfter removing first and last elements:");
            printStatistics(dataSet, stats);
        }
    }

    public static void testListDataSet() {
        Random random = new Random();
        int n = 10 + random.nextInt(11); // Random between 10-20

        ListDataSet dataSet = new ListDataSet();
        BasicStatistic stats = new BasicStatistic();
        stats.setDataSet(dataSet);

        // Add random numbers
        System.out.println("Adding " + n + " random numbers:");
        for (int i = 0; i < n; i++) {
            double value = random.nextDouble() * 100;
            dataSet.append(value);
        }

        printStatistics(dataSet, stats);

        // Remove first and last elements
        if (n > 1) {
            dataSet.remove(0);
            dataSet.remove(dataSet.size() - 1);
            System.out.println("\nAfter removing first and last elements:");
            printStatistics(dataSet, stats);
        }
    }

    private static void printStatistics(DataSet dataSet, BasicStatistic stats) {
        System.out.println("Dataset: " + dataSet.toString());
        System.out.println("Size: " + stats.size());
        System.out.println("Max: " + stats.max());
        System.out.println("Min: " + stats.min());
        System.out.println("Mean: " + stats.mean());
        System.out.println("Variance: " + stats.variance());

        System.out.print("Rank: [");
        double[] ranks = stats.rank();
        for (int i = 0; i < ranks.length; i++) {
            System.out.print(ranks[i]);
            if (i < ranks.length - 1) System.out.print(", ");
        }
        System.out.println("]");

        System.out.println("Median: " + stats.median());
    }
}