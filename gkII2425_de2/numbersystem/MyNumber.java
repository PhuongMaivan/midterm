package hus.oop.gkII2425_de2.numbersystem;

import java.util.ArrayList;
import java.util.List;

public class MyNumber {
    private int number;  // Số ban đầu trong hệ thập phân
    private List<NumberConverter> converters;  // Danh sách các converter theo observer pattern

    public MyNumber(int number) {
        this.number = number;
        this.converters = new ArrayList<>();
    }

    /*
     * Thêm vào converter để quan sát số ban đầu.
     * @param converter
     */
    public void addConverter(NumberConverter converter) {
        converters.add(converter);
    }

    /*
     * Hủy quan sát số ban đầu của converter.
     * @param converter
     */
    public void removeConverter(NumberConverter converter) {
        converters.remove(converter);
    }

    /*
     * Khi có sự thay đổi trạng thái (biểu diễn số hoặc cơ số), thông báo cho tất cả
     * các converter đang ký quan sát để cập nhật lại trạng thái theo dữ liệu mới.
     */
    public void notifyConverters() {
        for (NumberConverter converter : converters) {
            converter.update();
        }
    }

    public void setNumber(int number) {
        this.number = number;
        onStateChanged();
    }

    public int getNumber() {
        return number;
    }

    /*
     * Được gọi khi có sự thay đổi về trạng thái (biểu diến số hoặc cơ số),
     * hàm này sẽ gọi hàm để thông báo cho tất cả các observer đang ký quan sát
     * cập nhật lại trạng thái.
     */
    private void onStateChanged() {
        notifyConverters();
    }
}