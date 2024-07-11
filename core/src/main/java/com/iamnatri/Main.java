package com.iamnatri;

import java.util.ArrayList;
import java.util.List;

import com.iamnatri.resolvers.QueensAttackResolver;

import io.quarkus.runtime.Quarkus;

public class Main {

    public static void main(String[] args) {
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
