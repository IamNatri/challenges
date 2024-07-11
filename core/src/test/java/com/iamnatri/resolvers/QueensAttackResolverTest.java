package com.iamnatri.resolvers;

import org.junit.jupiter.api.Test;


import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

@QuarkusTest
public class QueensAttackResolverTest {

    @Test
    @TestTransaction
    public void testQueensAttackResolverObstaclesURDL(){
        List<List<Integer>> obstacles = new ArrayList<>();
        List<Integer> obstacle1 = new ArrayList<>();
        List<Integer> obstacle2 = new ArrayList<>();
        List<Integer> obstacle3 = new ArrayList<>();
        obstacle1.add(5);
        obstacle1.add(5);
        obstacle2.add(4);
        obstacle2.add(2);
        obstacle3.add(2);
        obstacle3.add(3);
        
        obstacles.add(obstacle1);
        obstacles.add(obstacle2);
        obstacles.add(obstacle3);


        int result = QueensAttackResolver.queensAttack(5,3, 4, 3, obstacles);

        assertEquals(10, result);

    }

    @Test
    public void testQueensAttackResolverNoObstacles(){
        List<List<Integer>> obstacles = new ArrayList<>();
        List<Integer> obstacle1 = new ArrayList<>();
        obstacles.add(obstacle1);
        int result = QueensAttackResolver.queensAttack(4,0, 4, 4, obstacles);
        assertEquals(9, result);
    }

    @Test
    public void testQueensAttackResolverObstacleInAllDirectionsNoMoves(){
        List<List<Integer>> obstacles = new ArrayList<>();
        List<Integer> obstacle1 = new ArrayList<>();
        List<Integer> obstacle2 = new ArrayList<>();
        List<Integer> obstacle3 = new ArrayList<>();
        List<Integer> obstacle4 = new ArrayList<>();
        List<Integer> obstacle5 = new ArrayList<>();
        List<Integer> obstacle6 = new ArrayList<>();
        List<Integer> obstacle7 = new ArrayList<>();
        List<Integer> obstacle8 = new ArrayList<>();
        obstacle1.add(1);
        obstacle1.add(1);
        obstacle2.add(1);
        obstacle2.add(2);
        obstacle3.add(1);
        obstacle3.add(3);
        obstacle4.add(2);
        obstacle4.add(1);
        obstacle5.add(2);
        obstacle5.add(3);
        obstacle6.add(3);
        obstacle6.add(1);
        obstacle7.add(3);
        obstacle7.add(2);
        obstacle8.add(3);
        obstacle8.add(3);
        obstacles.add(obstacle1);
        obstacles.add(obstacle2);
        obstacles.add(obstacle3);
        obstacles.add(obstacle4);
        obstacles.add(obstacle5);
        obstacles.add(obstacle6);
        obstacles.add(obstacle7);
        obstacles.add(obstacle8);

        int result = QueensAttackResolver.queensAttack(3,8, 2, 2, obstacles);
        assertEquals(0, result);
    }

    @Test
    public void testQueensAttackResolverObstaclesInAllDirectionsWithMove(){
        List<List<Integer>> obstacles = new ArrayList<>();
        List<Integer> obstacle1 = new ArrayList<>();
        List<Integer> obstacle2 = new ArrayList<>();
        List<Integer> obstacle3 = new ArrayList<>();
        List<Integer> obstacle4 = new ArrayList<>();
        List<Integer> obstacle5 = new ArrayList<>();
        List<Integer> obstacle6 = new ArrayList<>();
        List<Integer> obstacle7 = new ArrayList<>();
        List<Integer> obstacle8 = new ArrayList<>();
        List<Integer> obstacle9 = new ArrayList<>();
        List<Integer> obstacle10 = new ArrayList<>();
        
        obstacle1.add(1);
        obstacle1.add(1);
        obstacle2.add(2);
        obstacle2.add(2);
        obstacle3.add(2);
        obstacle3.add(4);
        obstacle4.add(2);
        obstacle4.add(6);
        obstacle5.add(4);
        obstacle5.add(3);
        obstacle6.add(4);
        obstacle6.add(6);
        obstacle7.add(6);
        obstacle7.add(6);
        obstacle8.add(7);
        obstacle8.add(4);
        obstacle9.add(6);
        obstacle9.add(2);
        obstacle10.add(5);
        obstacle10.add(5);
        obstacles.add(obstacle1);
        obstacles.add(obstacle2);
        obstacles.add(obstacle3);
        obstacles.add(obstacle4);
        obstacles.add(obstacle5);
        obstacles.add(obstacle6);
        obstacles.add(obstacle7);
        obstacles.add(obstacle8);
        obstacles.add(obstacle9);
        obstacles.add(obstacle10);

        int result = QueensAttackResolver.queensAttack(8,10, 4, 4, obstacles);
        assertEquals(7, result);


    }
    
}
