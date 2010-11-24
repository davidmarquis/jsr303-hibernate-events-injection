package com.github.davidmarquis;

import com.github.davidmarquis.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import javax.validation.ConstraintViolationException;

@ContextConfiguration(value = "classpath:applicationContext.xml")
public class TestCustomValidator extends AbstractJUnit4SpringContextTests {

    @Autowired
    private SessionFactory sessionFactory;

    @Test(expected = ConstraintViolationException.class)
    public void testCustomValidation() {

        User toSave = new User();
        toSave.setEmail("test@toto.com");

        Session session = SessionFactoryUtils.getNewSession(sessionFactory);
        session.save(toSave);

    }
}
