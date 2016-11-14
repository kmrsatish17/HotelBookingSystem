package com.ssdi.project.access.db.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ssdi.project.access.db.ConnectionPool;

public class ConnectionPoolTest {
	

    
    public ConnectionPoolTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }


    /**
     * Test of getConnection method, of class ConnectionPool.
     */
    @Test
    public void testGetConnection() {
    	System.out.println("getConnection");
        ConnectionPool instance = null;
        Connection expResult = null;
        assertEquals(expResult, instance);
    }

	
}