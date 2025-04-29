package hus.oop.statistics;

public abstract class AbstractDataSet implements DataSet {
    /**
     * Mô tả tập dữ liệu.
     * @return mô tả tập dữ liệu dạng [a1, a2, a3, ..., an].
     */
    @Override
    public String toString() {
        /* TODO */
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < elements(0, size()).length; i++) {
            if (i == elements(0, size()).length - 1) {
                sb.append(elementAt(i));
            } else {
                sb.append(elementAt(i)).append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }
}
