import java.util.*;
import java.io.*;
import java.util.stream.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;

void listTopAtk () {
    sortByAtk();
    Player [] topAttackers = new Player[3];
    for(int i = 0; i < 3; i++) {
        Player first = (Player)players.get(i);
        topAttackers[i] = first;
    }
    System.out.println(topAttackers[0]);

}