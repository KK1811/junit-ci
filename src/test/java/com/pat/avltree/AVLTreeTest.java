package com.pat.avltree;

import static org.junit.Assert.*;

// import org.junit.Ignore;
import org.junit.Test;

public class AVLTreeTest 
{
    private AVLTree tree = new AVLTree();

    @Test
    public void testInsert()
    {
        for (int i = 0; i < 10; i++) 
        {
            tree.insert(i);
        }

        try{
            tree.insert(0);
        } catch(Exception e) {
            assertEquals(e.getMessage(), "duplicate Key!");
        }
    }

}
