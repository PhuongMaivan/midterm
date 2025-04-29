package hus.oop.gk2023_2024.decorator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class BreadStore {
	private List<Bread> breads;

	public BreadStore() {
		breads = new ArrayList<>();
	}

	public void init() {
		// Generate a random number between 5 and 10
		Random random = new Random();
		int n = random.nextInt(6) + 5; // Range [5, 10]

		// Initialize the store with different types of bread
		// ThickcrustBread with only cheese
		for (int i = 0; i < n; i++) {
			add(new Cheese(new ThickcrustBread()));
		}

		// ThickcrustBread with only olives
		for (int i = 0; i < n; i++) {
			add(new Olives(new ThickcrustBread()));
		}

		// ThickcrustBread with cheese and then olives
		for (int i = 0; i < n; i++) {
			add(new Olives(new Cheese(new ThickcrustBread())));
		}

		// ThickcrustBread with olives and then cheese
		for (int i = 0; i < n; i++) {
			add(new Cheese(new Olives(new ThickcrustBread())));
		}

		// ThincrustBread with only cheese
		for (int i = 0; i < n; i++) {
			add(new Cheese(new ThincrustBread()));
		}

		// ThincrustBread with only olives
		for (int i = 0; i < n; i++) {
			add(new Olives(new ThincrustBread()));
		}

		// ThincrustBread with cheese and then olives
		for (int i = 0; i < n; i++) {
			add(new Olives(new Cheese(new ThincrustBread())));
		}

		// ThincrustBread with olives and then cheese
		for (int i = 0; i < n; i++) {
			add(new Cheese(new Olives(new ThincrustBread())));
		}
	}

	/**
	 * Thêm bánh mỳ vào cửa hàng.
	 */
	public void add(Bread bread) {
		breads.add(bread);
	}

	/**
	 * Giả sử cửa hàng bán một cái bánh mỳ nào đó,
	 * Bánh mỳ được lấy ra để bán là bánh mỳ đầu tiên theo yêu cầu
	 *  của khác hàng (ví dụ, ThickcrustBread + Cheese + Olives)
	 * Nếu còn bánh mỳ để bán thì trả về giá trị true,
	 *  nếu không còn trả về giá trị false.
	 */
	public boolean sell(String breadDescription) {
		for (int i = 0; i < breads.size(); i++) {
			if (breads.get(i).getDescription().equals(breadDescription)) {
				breads.remove(i);
				return true;
			}
		}
		return false;
	}

	/**
	 * In ra những bánh mỳ còn trong cửa hàng.
	 */
	public void print() {
		System.out.println("Remaining breads in store:");
		for (Bread bread : breads) {
			System.out.println(bread);
		}
		System.out.println();
	}

	/**
	 * Trả ra các bánh mỳ còn lại trong cửa hàng được sắp xếp theo giá, thứ tự được cho bởi order,
	 *  nếu order là true, sắp xếp theo thứ tự tăng dần,
	 *  nếu order là false, sắp xếp theo thứ tự giảm dần.
	 * Chú ý: việc sắp xếp không làm thay đổi thứ tự của bánh mỳ trong cửa hàng.
	 */
	public List<Bread> sort(boolean order) {
		List<Bread> sortedBreads = new ArrayList<>(breads);

		if (order) {
			// Sort in ascending order
			Collections.sort(sortedBreads, new Comparator<Bread>() {
				@Override
				public int compare(Bread b1, Bread b2) {
					return Double.compare(b1.cost(), b2.cost());
				}
			});
		} else {
			// Sort in descending order
			Collections.sort(sortedBreads, new Comparator<Bread>() {
				@Override
				public int compare(Bread b1, Bread b2) {
					return Double.compare(b2.cost(), b1.cost());
				}
			});
		}

		return sortedBreads;
	}

	/**
	 * Lọc ra howMany cái bánh mỳ có giá cao nhất hoặc thấp nhất,
	 *  nếu order là true thì lọc ra bánh mỳ có giá cao nhất,
	 *  nếu order là false thì lọc ra bánh mỳ có giá thấp nhất.
	 */
	public List<Bread> filter(int howMany, boolean order) {
		List<Bread> sortedBreads = sort(!order); // Reverse order for getting highest/lowest

		int count = Math.min(howMany, sortedBreads.size());
		return sortedBreads.subList(0, count);
	}

	public static void main(String args[]) {
		// Create a bread store with initial breads from init() method
		BreadStore store = new BreadStore();
		store.init();

		// Print all breads in the store
		System.out.println("Initial breads in store:");
		store.print();

		// Sell 5 breads from the store
		String[] breadsToBuy = {
				"ThickcrustBread + Cheese",
				"ThincrustBread + Olives",
				"ThickcrustBread + Cheese + Olives",
				"ThincrustBread + Olives + Cheese",
				"ThickcrustBread + Olives"
		};

		for (int i = 0; i < breadsToBuy.length; i++) {
			System.out.println("Selling bread: " + breadsToBuy[i]);
			boolean sold = store.sell(breadsToBuy[i]);

			if (sold) {
				System.out.println("Successfully sold: " + breadsToBuy[i]);
			} else {
				System.out.println("Failed to sell: " + breadsToBuy[i] + " (Not available)");
			}

			// Print remaining breads
			store.print();

			// Print breads in descending order of price
			System.out.println("Breads sorted by price (descending):");
			List<Bread> sortedBreads = store.sort(false);
			for (Bread bread : sortedBreads) {
				System.out.println(bread);
			}
			System.out.println();
		}

		// Print up to 10 most expensive breads
		System.out.println("Top 10 most expensive breads:");
		List<Bread> expensiveBreads = store.filter(10, true);
		for (Bread bread : expensiveBreads) {
			System.out.println(bread);
		}
	}
}