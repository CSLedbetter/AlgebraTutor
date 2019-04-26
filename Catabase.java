//Every morning, the number of days in the center should be incremented for each cat in the shelter's care.  Add a method to the Catabase class called update() that uses a for-each loop to increment each cat's days_in_center by 1.  It doesn't need to take any parameters or return any values.

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

class Catabase{
    Cat [] cats;
    int cats_in_center;

    Catabase(){
        cats = new Cat[50];
        cats_in_center = 0;

        for(int index=0; index < cats.length; index++)
            cats[index] = new Cat();
    }
    
    void update() {
         for(Cat current_cat : cats){
           if(current_cat.name != null){
               current_cat.days_in_center = current_cat.days_in_center + 1;
            }
          }
    }

    void add_cat(String name, int days) {
        cats[cats_in_center].init(name, days);
        cats_in_center++;
    }

    void print(){
        for(Cat current_cat : cats){
            if(current_cat.name != null){
                current_cat.print();
            }
        }
    }
}

public class CatabaseTest {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Catabase shelter_cats = new Catabase();

        shelter_cats.add_cat("Duke", 0);
        shelter_cats.add_cat("Ella", 1);
        shelter_cats.add_cat("Diamond", 2);
        shelter_cats.add_cat("Mercedes", 3);

        shelter_cats.update();
        shelter_cats.print();
    }
}