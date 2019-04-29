// Write your Valley Verde Volleyball Program Here
import java.util.*;
import java.io.*;
import java.util.stream.*;

class VerdeVolleyball  {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Boolean rosterOpen = false;
        int willRun = 1;
        String fileName;


        while (rosterOpen == false) {
            System.out.println("1. Open a roster");
            System.out.println("2. List top 3 attackers");
            System.out.println("3. List top 3 blockers");
            System.out.println("4. Make and display scrimmage teams");
            System.out.println("5. Quit");
            System.out.print("Enter selection number: ");
            int selection = Integer.parseInt(input.nextLine());
            if (selection == 1) {
                System.out.print("\nEnter file name: ");
                fileName = input.nextLine();
                Roster roster = new Roster(fileName);
                rosterOpen = true;
                while (rosterOpen == true && willRun >=0){
                    System.out.println("\n1. Open a roster");
                    System.out.println("2. List top 3 attackers");
                    System.out.println("3. List top 3 blockers");
                    System.out.println("4. Make and display scrimmage teams");
                    System.out.println("5. Quit");
                    System.out.print("Enter selection number: ");
                    selection = Integer.parseInt(input.nextLine());
                    if (selection == 2){
                        System.out.println("");
                        roster.listTopAtk ();
                    }
                    else if (selection == 3) {
                        System.out.println("");
                        roster.listTopDef();
                    }
                    else if (selection == 4) {
                        System.out.println("");
                        roster.createTeam();
                    }
                    else {
                        return;
                    }
                }
            }
            else if (selection == 5) {
                willRun = 0;
                return;
            }
            else {
                System.out.println("Please open a roster.\n");
            }


        }
    }
}


class Player {
    String firstName;
    String lastName;
    double attack;
    double defence;

    void init(String initFirstname, String initLastName, double initAtk, double initDef) {
        firstName = initFirstname;
        lastName = initLastName;
        attack = initAtk;
        defence = initDef;        
    }

    double getAttack() {
        return attack;    
    }

    double getDefence() {
        return defence;    
    }

    String getName() {
        String fullName = firstName + " " + lastName;
        System.out.println(fullName);
        return fullName;
    }

    void print() {
        System.out.println(firstName + " " + lastName + " " + attack + " " + defence);       
    }
}

class Roster {
    ArrayList<Player> players = new ArrayList<Player>();

    Roster(String fileName) {
        LineNumberReader lineNumberReader = null;
        try {
            // Construct the LineNumberReader object
            lineNumberReader = new LineNumberReader(new FileReader(fileName));

            String line = null;
            List<String> list = new ArrayList<String>();

            while ((line = lineNumberReader.readLine()) != null) {
                String[] info = line.split(" ");
                Player newPlayer = new Player();
                newPlayer.init(info[0], info[1], Double.parseDouble(info[2]), Double.parseDouble(info[3]));
                players.add(newPlayer);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // Close the LineNumberReader
            try {
                if (lineNumberReader != null) {
                    lineNumberReader.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

    void sortByAtk() {
        for (int sortIters = 0; sortIters < players.size(); sortIters++) {

            for (int index = 0; index < players.size() - sortIters - 1; index++) {
                Player first = (Player)players.get(index);
                Player second = (Player)players.get(index+1);
                if(first.getAttack() < second.getAttack() )
                    Collections.swap(players, index+1, index);
            }
        }
    }

    void sortByDef() {
        for (int sortIters = 0; sortIters < players.size(); sortIters++) {

            for (int index = 0; index < players.size() - sortIters - 1; index++) {
                Player first = (Player)players.get(index);
                Player second = (Player)players.get(index+1);
                if(first.getDefence() < second.getDefence() )
                    Collections.swap(players, index+1, index);
            }
        }
    }

    void listTopAtk () {
        sortByAtk();
        ArrayList<Player> topAttackers = new ArrayList<Player>();
        for(int i = 0; i < 3; i++) {
            Player first = (Player)players.get(i);
            topAttackers.add(first);
        }
        System.out.println("Top 3 attackers: ");
        for (Player player : topAttackers) {
            player.print();
        }
    }

    void listTopDef () {
        sortByDef();
        ArrayList<Player> topDefenders = new ArrayList<Player>();
        for(int i = 0; i < 3; i++) {
            Player first = (Player)players.get(i);
            topDefenders.add(first);
        }
        System.out.println("Top 3 defenders: ");
        for (Player player : topDefenders) {
            player.print();
        }
    }

    void createTeam () {
        ArrayList<Player> team1 = new ArrayList<Player>();
        ArrayList<Player> team2 = new ArrayList<Player>();
        ArrayList<Player> team3 = new ArrayList<Player>();
        ArrayList<Player> team4 = new ArrayList<Player>();
        int count = players.size();
        System.out.println(count - (count%6));

        if (count - (count%6) == 12) {
            for(int i = 0; i < 3; i++) {
                sortByAtk();
                Player first = (Player)players.get(0);
                Player second = (Player)players.get(1);
                team1.add(first);
                team2.add(second);
                players.remove(first);
                players.remove(second);

            }
            for(int i = 0; i < 3; i++) {
                sortByDef();
                Player first = (Player)players.get(0);
                Player second = (Player)players.get(1);
                team1.add(first);
                team2.add(second);
                players.remove(first);
                players.remove(second);

            }
            System.out.println("Team 1: ");
            for (Player player : team1) {
                player.getName();
            }
            System.out.println("\nTeam 2: ");
            for (Player player : team2) {
                player.getName();
            }
        } else if (count - (count%6) <= 18 && count - (count%6) > 12 ) {
            for(int i = 0; i < 3; i++) {
                sortByAtk();
                Player first = (Player)players.get(0);
                Player second = (Player)players.get(1);
                Player third = (Player)players.get(2);
                team1.add(first);
                team2.add(second);
                team3.add(third);
                players.remove(first);
                players.remove(second);
                players.remove(third);

            }
            for(int i = 0; i < 3; i++) {
                sortByDef();
                Player first = (Player)players.get(0);
                Player second = (Player)players.get(1);
                Player third = (Player)players.get(2);
                team1.add(first);
                team2.add(second);
                team3.add(third);
                players.remove(first);
                players.remove(second);
                players.remove(third);

            }
            System.out.println("Team 1: ");
            for (Player player : team1) {
                player.getName();
            }
            System.out.println("\nTeam 2: ");
            for (Player player : team2) {
                player.getName();
            }         
            System.out.println("\nTeam 3: ");
            for (Player player : team3) {
                player.getName();
            }                        
        }
        else {
            for(int i = 0; i < 3; i++) {
                sortByAtk();
                Player first = (Player)players.get(0);
                Player second = (Player)players.get(1);
                Player third = (Player)players.get(2);
                Player fourth = (Player)players.get(3);

                team1.add(first);
                team2.add(second);
                team3.add(third);
                team3.add(fourth);

                players.remove(first);
                players.remove(second);
                players.remove(third);
                players.remove(fourth);

            }
            for(int i = 0; i < 3; i++) {
                sortByDef();
                Player first = (Player)players.get(0);
                Player second = (Player)players.get(1);
                Player third = (Player)players.get(2);
                Player fourth = (Player)players.get(3);

                team1.add(first);
                team2.add(second);
                team3.add(third);
                team3.add(fourth);

                players.remove(first);
                players.remove(second);
                players.remove(third);
                players.remove(fourth);

            }
            System.out.println("Team 1: ");
            for (Player player : team1) {
                player.getName();
            }
            System.out.println("\nTeam 2: ");
            for (Player player : team2) {
                player.getName();
            }         
            System.out.println("\nTeam 3: ");
            for (Player player : team3) {
                player.getName();
            }
            System.out.println("\nTeam 4: ");
            for (Player player : team4) {
                player.getName();
            }
        }
    }


    void print() {
        for (Player player : players) {
            player.print();
        }
    }
}