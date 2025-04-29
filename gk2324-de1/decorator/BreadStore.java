package com.decorator;

import java.util.*;

public class BreadStore {
	private List<Bread> breads;

	public BreadStore() {
		breads = new LinkedList<>();
	}

	/**
	 * Giả sử bánh mỳ được làm không cho một loại gia vị nhiều hơn một lần.
	 * Bắt đầu, tạo ra và cho vào cửa hàng:
	 *  5 bánh mỳ ThickcrustBread chỉ có cheese,
	 *  5 bánh mỳ ThickcrustBread chỉ có olives,
	 *  5 bánh mỳ ThickcrustBread có cả cheese và olives,
	 *  5 bánh mỳ ThincrustBread chỉ có cheese,
	 *  5 bánh mỳ ThincrustBread chỉ có olives,
	 *  5 bánh mỳ ThincrustBread có cả cheese và olives.
	 */
	public void init() {
		 /* TODO */
		for (int i = 0; i < 5; i++) {
			Bread bread = new ThickcrustBread();
			Bread cheese = new Cheese(bread);
			breads.add(cheese);
		}
		for (int i = 0; i < 5; i++) {
			Bread bread = new ThickcrustBread();
			Bread olives = new Olives(bread);
			breads.add(olives);
		}
		for (int i = 0; i < 5; i++) {
			Bread bread = new ThickcrustBread();
			Bread cheese = new Cheese(bread);
			Bread olives = new Olives(cheese);
			breads.add(olives);
		}
		for (int i = 0; i < 5; i++) {
			Bread bread = new ThincrustBread();
			Bread cheese = new Cheese(bread);
			breads.add(cheese);
		}
		for (int i = 0; i < 5; i++) {
			Bread bread = new ThincrustBread();
			Bread olives = new Olives(bread);
			breads.add(olives);
		}
		for (int i = 0; i < 5; i++) {
			Bread bread = new ThincrustBread();
			Bread cheese = new Cheese(bread);
			Bread olives = new Olives(cheese);
			breads.add(olives);
		}
	}

	/**
	 * Thêm bánh mỳ vào cửa hàng.
	 */
	public void add(Bread bread) {
		/* TODO */
		breads.add(bread);
	}

	/**
	 * Giả sử cửa hàng bán một cái bánh mỳ nào đó,
	 * Bánh mỳ được lấy ra để bán là bánh mỳ đầu tiên có giá bằng giá
	 *  bánh mỳ yêu cầu.
	 * Nếu còn bánh mỳ để bán thì trả về giá trị true,
	 *  nếu không còn trả về giá trị false.
	 */
	public boolean sell(Bread bread) {
		/* TODO */
		for (Bread breadAt : breads) {
			if (breadAt.cost() == bread.cost()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * In ra những bánh mỳ còn trong cửa hàng.
	 */
	public void print() {
		/* TODO */
		for (Bread bread : breads) {
			System.out.println(bread.getDescription());
		}
	}

	public void print(List<Bread> breads) {
		/* TODO */
		for (Bread bread : breads) {
			System.out.println(bread.getDescription());
		}
	}

	/**
	 * Sắp xếp các bánh mỳ còn lại theo thứ tự được cho bởi order,
	 * nếu order là true, sắp xếp theo thứ tự tăng dần,
	 * nếu order là false, sắp xếp theo thứ tự giảm dần.
	 * Việc sắp xếp không làm thay đổi thứ tự của bánh mỳ trong cửa hàng.
	 */
	public List<Bread> sort(boolean order) {
		/* TODO */
		List<Bread> temp = new ArrayList<>(breads);
		Comparator<Bread> sortStrategy = new Comparator<Bread>() {
			public int compare(Bread o1, Bread o2) {
				if (o1.cost() > o2.cost()) {
					return 1;
				} else if (o1.cost() < o2.cost()) {
					return -1;
				}
				return 0;
			}
		};
		if (order) {
			temp.sort(sortStrategy);
		} else {
			temp.sort(Collections.reverseOrder(sortStrategy));
		}
		return temp;
	}

	/**
	 * Lọc ra howMany cái bánh mỳ có giá cao nhất hoặc thấp nhất,
	 * nếu order là true thì lọc ra bánh mỳ có giá cao nhất,
	 * nếu order là false thì lọc ra bánh mỳ có giá thấp nhất.
	 */
	public List<Bread> filter(int howMany, boolean order) {
		/* TODO */
		List<Bread> temp = new ArrayList<>(sort(!order));
		List<Bread> filtered = new ArrayList<>();
		for (int i = 0; i < howMany; i++) {
			if (i >= temp.size()) {
				return filtered;
			}
			filtered.add(temp.get(i));
		}
		return filtered;
	}

	public static void main(String[] args) {
		BreadStore breadStore = new BreadStore();
		breadStore.init();

		/*
		* Sau khi khởi tạo số bánh mỳ cho cửa hàng, viết chương trình demo:
		* - Thêm một số bánh mỳ vào cửa hàng
		* - Bán một số bánh mỳ từ cửa hàng
		* - In ra số bánh mỳ còn lại theo thứ tự giá tăng dần.
		* - In ra nhiều nhất 10 cái bánh mỳ có giá thấp nhất còn trong cửa hàng.
		*/
		/* TODO */
		breadStore.add(new Cheese(new Olives(new ThickcrustBread())));

		Bread toSell = new Cheese(new ThickcrustBread());
		System.out.println(breadStore.sell(toSell));
		System.out.println(breadStore.sell(toSell));
		System.out.println(breadStore.sell(toSell));

		System.out.println(	);
		breadStore.print(breadStore.sort(true));

		System.out.println();
		breadStore.print(breadStore.filter(7, false));
	}
}
