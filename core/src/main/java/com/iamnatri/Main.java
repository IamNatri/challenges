package com.iamnatri;

import java.util.ArrayList;
import java.util.List;

import com.iamnatri.resolvers.pairsum.pairsumResolver;
import com.iamnatri.resolvers.queensattack.QueensAttackResolver;

import io.quarkus.runtime.Quarkus;

public class Main {

    public static void main(String[] args) {
        // Quarkus.run(args);
        // queensAttackRun();
        var result = pairsumResolver.pairSum(new int[]{3, 5, -4, 8, 11, 1, -1, 6}, 10);
        System.out.println(result[0] + " " + result[1]);

 
    }

    static void queensAttackRun() {
        List<List<Integer>> obstacles = new ArrayList<>();
        List<Integer> obstacle1 = new ArrayList<>();
        List<Integer> obstacle2 = new ArrayList<>();
        List<Integer> obstacle3 = new ArrayList<>();
        List<Integer> obstacle4 = new ArrayList<>();
        obstacle1.add(5);
        obstacle1.add(5);
        obstacle2.add(4);
        obstacle2.add(2);
        obstacle3.add(2);
        obstacle3.add(3);
        obstacle4.add(3);
        obstacle4.add(2);
        obstacles.add(obstacle1);
        obstacles.add(obstacle2);
        obstacles.add(obstacle3);
        obstacles.add(obstacle4);


        int result = QueensAttackResolver.queensAttack(5,4, 4, 3, obstacles);
        System.out.println(result);
    }
    
}
