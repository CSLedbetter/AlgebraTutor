import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    // instantiate the Catabase object
    Catabase cb = new Catabase();
    // add one cat per day for three days
    cb.addCat("Alfi");
    cb.updateDaysInShelter();
    cb.addCat("Benny");
    cb.updateDaysInShelter();
    cb.addCat("Chichi");
    cb.updateDaysInShelter();
    // display all cats
    cb.print();
    // find a cat named "benny"
    int index = cb.findCatByName("Benny");
    System.out.println("Benny found at index: " + index);
    // delete Benny
    cb.removeCat(index);
    // display all cats
    cb.print();
  }
}

class Cat {
	String name;
	int days_in_center;
	
	Cat(String init_name, int init_days) {
		name = init_name;
		days_in_center = init_days;
	}
	
	void print() {
		System.out.println(name + " " + days_in_center);
	}
}

class Catabase {
	ArrayList<Cat> cats = new ArrayList<Cat>();

  void addCat(String name) {
    // a Cat with this name will be instantiated
    Cat new_cat = new Cat(name, 0);
    // Cat will be stored in the ArrayList
    cats.add(new_cat);
  }

  void updateDaysInShelter() {
    // loop through all of the Cats in the array
    for (Cat cat : cats) {
      //  and add 1 to their days_in_center variable
      cat.days_in_center += 1;
    }
  }

  int findCatByName(String name_to_search_for) {
    //  iterate over all the Cats in the array
   for (int index = 0; index < cats.size(); index++) {
       // if we find a Cat with this name
      if(cats.get(index).name.equals(name_to_search_for)) {
        //  return the index of that Cat in the Array
        return index;
      }
    }
    // If we do not find a Cat with this name, then we will return -1
    return -1;
  }

  void removeCat(int index_to_remove) {
    cats.remove(index_to_remove);
  }

  // a convenient method to print out info on all cats in the shelter
  void print() {
    for (Cat cat : cats) {
      cat.print();
    }
  }
}
