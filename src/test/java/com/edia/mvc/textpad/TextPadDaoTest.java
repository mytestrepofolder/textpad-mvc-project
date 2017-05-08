package com.edia.mvc.textpad;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import com.edia.mvc.textpad.dao.TextPadDAO;
import com.edia.mvc.textpad.dao.TextPadDAOImpl;
import com.edia.mvc.textpad.entity.TextPad;


public class TextPadDaoTest {

    private EmbeddedDatabase db;

    TextPadDAO userDao;
    
    @Before
    public void setUp() {

    	db = new EmbeddedDatabaseBuilder()
    		.setType(EmbeddedDatabaseType.HSQL)
    		.addScript("db/sql/createdb.sql")
    		.addScript("db/sql/insertdata.sql")
    		.build();
    }

    @Test
    public void testFindByname() {
    	NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(db);
    	TextPadDAOImpl userDao = new TextPadDAOImpl();
    	userDao.setNamedParameterJdbcTemplate(template);
    	
    	TextPad test = userDao.getTextById(1);
  
    	Assert.assertNotNull(test);
    	Assert.assertEquals(1, test.getId());
    	Assert.assertEquals("Text1", test.getTextTilte());
    	Assert.assertEquals("This is text 1", test.getTextDesc());
    	Assert.assertEquals("2017-05-08T11:46:56.900+02:00", test.getCreationDate().toString());
    }

    @After
    public void tearDown() {
        db.shutdown();
    }

}