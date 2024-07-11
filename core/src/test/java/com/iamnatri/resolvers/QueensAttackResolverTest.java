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
    public void testQueensAttackResolver(){
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


        int result = QueensAttackResolver.queensAttack(4,0, 4, 4, obstacles);

        assertEquals(10, result);

    }
    
}
