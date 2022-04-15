package com.pat.avltree;

import static org.junit.Assert.*;

import org.junit.Test;

public class AVLTreeTest 
{
    private AVLTree tree = new AVLTree();

    @Test
    public void testInsert()
    {
        assertEquals(tree.height(), -1);

        for (int i = 0; i < 5; i++) {
            tree.insert(i);
        }

        for (int i = 10; i > 5; i--) {
            tree.insert(i);
        }
        
        tree.insert(-10);

        assertTrue(tree.height() != -1);

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

        tree.delete(-10);

        assertEquals(tree.height(), -1);
    }

    @Test
    public void testFind()
    {
        tree.insert(0);
        assertTrue(tree.find(0) != null);
        tree.insert(1);
        assertTrue(tree.find(0) != null);
        assertTrue(tree.find(1) != null);

        tree.delete(0);
        tree.delete(1);
        
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

    @Test
    public void findBug()
    {
        tree.insert(1);
        tree.insert(0);
        try{
            tree.delete(1);
            tree.delete(0);
        } catch (Exception e) {
            fail("Exception " + e);
        }
        
        /* If the tree has only 2 nodes such that the root has only a left child, 
        a null object is passed to the mostLeftChild function and the code gives an error*/
    }

}
