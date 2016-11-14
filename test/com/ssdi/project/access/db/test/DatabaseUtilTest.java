package com.ssdi.project.access.db.test;

import java.sql.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ssdi.project.access.db.DatabaseUtil;

import org.junit.*;

public class DatabaseUtilTest {
	
	public DatabaseUtilTest() {
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
     * Test of closeStatement method, of class DBUtil.
     */
    @Test
    public void testCloseStatement() {
        System.out.println("closeStatement");
        Statement s = null;
        DatabaseUtil.closeStatement(s);
    }

    /**
     * Test of closePreparedStatement method, of class DBUtil.
     */
    @Test
    public void testClosePreparedStatement() {
        System.out.println("closePreparedStatement");
        Statement ps = null;
        DatabaseUtil.closePreparedStatement(ps);
    }

    /**
     * Test of closeResultSet method, of class DBUtil.
     */
    @Test
    public void testCloseResultSet() {
        System.out.println("closeResultSet");
        ResultSet rs = null;
        DatabaseUtil.closeResultSet(rs);
    }
	
	
}