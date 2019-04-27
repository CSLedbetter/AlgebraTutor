class Cat {
    String name;
    int days_in_center;

    void init(String init_name, int init_days) {
        name = init_name;
        days_in_center = init_days;
    }

    void print() {
        System.out.println(name + " " + days_in_center);
    }
}

class Catabase {
    Cat[] cats;
    int cats_in_center;

    Catabase() {
        cats = new Cat[50];
        cats_in_center = 0;

        for (int index = 0; index < cats.length; index++)
            cats[index] = new Cat();
    }

    // When we add a cat we will insert them into array with cats who have been in
    // the shelter the longest at index [0]
    void add_cat(String name, int days) {
        if (cats_in_center == cats.length)
            return; // Center is full, can't add any more!

        Cat new_cat = new Cat();
        new_cat.init(name, days);

        int index_to_insert = 0;
        while (index_to_insert < cats_in_center && cats[index_to_insert].days_in_center > new_cat.days_in_center) {
            index_to_insert++;
        }

        for (int index = cats_in_center; index >= index_to_insert; index--) {
            cats[index + 1] = cats[index];
        }

        cats[index_to_insert] = new_cat;
        cats_in_center++;
    }

    void delete_cat(int index_to_delete) {
        if (index_to_delete < 0 || index_to_delete >= cats_in_center) {
            return;
        }

        for (int index = index_to_delete; index < cats_in_center - 1; index++) {
            cats[index] = cats[index + 1];
        }

        cats[cats_in_center - 1] = new Cat();
        cats_in_center--;
    }

    void print() {
        for (Cat current_cat : cats) {
            if (current_cat.name != null) {
                current_cat.print();
            }
        }
    }

    void update() {
        for (Cat current_cat : cats) {
            if (current_cat.name != null) {
                current_cat.days_in_center++;
            }
        }
    }

    int search(String search_name) {
        int found_index = -1;
        for (int index = 0; index < cats.length; index++) {
            if (search_name.equals(cats[index].name)) {
                found_index = index;
            }
        }
        return found_index;
    }

    void sort_by_name() {
        Cat temp_cat = new Cat();
        for (int sort_iters = 0; sort_iters < cats_in_center; sort_iters++) {

            for (int index = 0; index < cats_in_center - sort_iters - 1; index++) {

                if (cats[index].name.compareTo(cats[index + 1].name) > 0) {
                    // Swap
                    temp_cat = cats[index];
                    cats[index] = cats[index + 1];
                    cats[index + 1] = temp_cat;
                }
            }
        }
    }

    void sort_by_days() {
        Cat temp_cat = new Cat();
        for (int sort_iters = 0; sort_iters < cats_in_center; sort_iters++) {

            for (int index = 0; index < cats_in_center - sort_iters - 1; index++) {

                if (cats[index].days_in_center < cats[index + 1].days_in_center) {
                    // Swap
                    temp_cat = cats[index];
                    cats[index] = cats[index + 1];
                    cats[index + 1] = temp_cat;
                }
            }
        }
    }
}

public class CatabaseTest {

    public static void main(String[] args) {

        int found_index = 0;
        Catabase shelter_cats = new Catabase();

        shelter_cats.add_cat("Duke", 0);
        shelter_cats.add_cat("Ella", 1);
        shelter_cats.add_cat("Mercedes", 3);
        shelter_cats.add_cat("Diamond", 2);

        shelter_cats.update();
        shelter_cats.sort_by_name();
        System.out.println("Sorted by Name:");
        shelter_cats.print();

        shelter_cats.sort_by_days();
        System.out.println("\nSorted by Days in Shelter:");
        shelter_cats.print();

        String name_to_find = "Ella";

        found_index = shelter_cats.search(name_to_find);
        if (found_index >= 0) {
            System.out.println("Found " + name_to_find + " at index: " + found_index);
        } else
            System.out.println(name_to_find + " not found.");
    }
}