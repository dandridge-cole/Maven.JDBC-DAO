package models;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrigTextTest {

    @Test
    public void getId() {
        Integer expected = 1;
        OrigText text = new OrigText(expected,null,null,null,null);
        Integer actual = text.getId();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setId() {
        Integer expected = 1;
        OrigText text = new OrigText(null,null,null,null);
        text.setId(expected);
        Integer actual = text.getId();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getName() {
        String expected = "name";
        OrigText text = new OrigText(expected,null,null,null);
        String actual = text.getName();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setName() {
        String expected = "name";
        OrigText text = new OrigText(null, null,null,null);
        text.setName(expected);
        String actual = text.getName();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getLanguage() {
        String expected = "language";
        OrigText text = new OrigText(null, expected,null,null);
        String actual = text.getLanguage();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setLanguage() {
        String expected = "language";
        OrigText text = new OrigText(null, null,null,null);
        text.setLanguage(expected);
        String actual = text.getLanguage();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getAuthor() {
        String expected = "author";
        OrigText text = new OrigText(null,null, expected,null);
        String actual = text.getAuthor();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setAuthor() {
        String expected = "author";
        OrigText text = new OrigText(null, null,null,null);
        text.setAuthor(expected);
        String actual = text.getAuthor();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getYear() {
        Short expected = (short)1;
        OrigText text = new OrigText(null,null,null, expected);
        Short actual = text.getYear();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setYear() {
        Short expected = (short)1;
        OrigText text = new OrigText(null, null,null,null);
        text.setYear(expected);
        Short actual = text.getYear();
        Assert.assertEquals(expected,actual);
    }
}