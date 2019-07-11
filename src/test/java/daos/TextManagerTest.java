package daos;

import models.OrigText;
import org.junit.Assert;
import org.junit.Test;
import utility.ConnectionFactory;

import java.sql.Connection;
import java.util.List;

import static org.junit.Assert.*;

public class TextManagerTest {
    private TextManager tm = new TextManager();

    @Test
    public void findById() {
        OrigText actual = tm.findById(1);
        Assert.assertNotNull(actual);
    }

    @Test
    public void findAll() {
        List<OrigText> actual = tm.findAll();
        Assert.assertNotNull(actual);
        Assert.assertTrue(actual.size()>9);
    }

    @Test
    public void create() {
        List<OrigText> list = tm.findAll();
        Integer before = list.size();
        Integer expected = before+1;
        String deleteName = "deleteName";
        OrigText toAdd = new OrigText(deleteName,"deleteLang","deleteAuth",(short)1919);
        tm.create(toAdd);
        list.clear();
        list = tm.findAll();
        Integer actual = list.size();
        Assert.assertEquals(expected,actual);
        OrigText last = list.get(list.size()-1);
        Assert.assertEquals(deleteName,last.getName());
        tm.delete(last.getId());
    }

    @Test
    public void update() {
        String deleteName = "deleteName";
        OrigText toAdd = new OrigText(deleteName,"deleteLang","deleteAuth",(short)1919);
        tm.create(toAdd);
        List<OrigText> list = tm.findAll();
        Integer beforeSize = list.size();
        OrigText lastText = list.get(list.size()-1);
        int lastId = lastText.getId();
        String beforeName = lastText.getName();
        Assert.assertEquals(beforeName,"deleteName");
        String expected = "deleteThisName";
        OrigText replaceText = new OrigText(lastId,expected,lastText.getLanguage(),lastText.getAuthor(),lastText.getYear());
        tm.update(replaceText);
        list.clear();
        list = tm.findAll();
        Integer afterSize = list.size();
        Assert.assertEquals(beforeSize,afterSize);
        OrigText afterText = list.get(list.size()-1);
        String actual = afterText.getName();
        Assert.assertEquals(expected,actual);
        tm.delete(afterText.getId());
    }

    @Test
    public void delete() {
        String deleteName = "deleteName";
        OrigText toAdd = new OrigText(deleteName,"deleteLang","deleteAuth",(short)1919);
        tm.create(toAdd);
        List<OrigText> list = tm.findAll();
        Integer beforeSize = list.size();
        OrigText lastText = list.get(beforeSize-1);
        int lastId = lastText.getId();
        String expectedName = "deleteName";
        String actualName = lastText.getName();
        Assert.assertEquals(expectedName,actualName);
        tm.delete(lastId);
        list.clear();
        list = tm.findAll();
        Integer actual = list.size();
        Integer expected = beforeSize-1;
        Assert.assertEquals(expected,actual);
    }
}