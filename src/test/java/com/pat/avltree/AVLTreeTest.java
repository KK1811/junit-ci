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
        for (int i = 0; i < 10; i++) {
            tree.insert(i);
        }

        try{
            tree.insert(0);
        } catch(Exception e) {
            assertEquals(e.getMessage(), "duplicate Key!");
        }
    }

    @Test
    public void testDelete()
    {
        for (int i = 0; i < 10; i++) 
        {
            tree.delete(i);
        }

        assertEquals(tree.height(), -1);
    }

    @Test
    public void testFind()
    {
        tree.insert(0);
        assertTrue(tree.find(0) != null);
        tree.delete(0);
    }

    @Test
    public void testHeight()
    {
        assertEquals(tree.height(), -1);
        tree.insert(0);
        tree.insert(1);
        tree.insert(2);
        assertEquals(tree.height(), 1);
        tree.delete(0);
        tree.delete(1);
        tree.delete(2);
    }

    @Test
    public void testGetRoot()
    {
        assertEquals(tree.getRoot(), null);
        tree.insert(0);
        assertTrue(tree.getRoot() != null);
        tree.delete(0);
        assertEquals(tree.getRoot(), null);
    }

    @Test
    public void testGetBalance()
    {
        assertEquals(tree.getBalance(null), 0);

        tree.insert(0);
        tree.insert(1);

        assertEquals(tree.getBalance(tree.find(0)), 1);

        tree.delete(0);
        tree.delete(1);

        tree.insert(2);
        assertEquals(tree.getBalance(tree.find(0)), 0);
        tree.delete(2);
    }

}
