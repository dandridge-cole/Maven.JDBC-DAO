package utility;

import models.OrigText;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class RunnerTest {
    private Runner runner = new Runner();


    @Test
    public void findById() {
        OrigText actual = runner.findById(1);
        Assert.assertNotNull(actual);
    }

    @Test
    public void findByIdFail() {
        OrigText actual = runner.findById(1999999);
        Assert.assertNull(actual);
    }

    @Test
    public void findAll() {
        List<OrigText> actual = runner.findAll();
        Assert.assertNotNull(actual);
        Assert.assertTrue(actual.size()>9);
    }

    @Test
    public void create() {
        List<OrigText> list = runner.findAll();
        Integer before = list.size();
        Integer expected = before+1;
        String deleteName = "deleteName";
        OrigText toAdd = new OrigText(deleteName,"deleteLang","deleteAuth",(short)1919);
        runner.create(toAdd);
        list.clear();
        list = runner.findAll();
        Integer actual = list.size();
        Assert.assertEquals(expected,actual);
        OrigText last = list.get(list.size()-1);
        Assert.assertEquals(deleteName,last.getName());
        runner.delete(last.getId());
    }

    @Test
    public void update() {
        String deleteName = "deleteName";
        OrigText toAdd = new OrigText(deleteName,"deleteLang","deleteAuth",(short)1919);
        runner.create(toAdd);
        List<OrigText> list = runner.findAll();
        Integer beforeSize = list.size();
        OrigText lastText = list.get(list.size()-1);
        int lastId = lastText.getId();
        String beforeName = lastText.getName();
        Assert.assertEquals(beforeName,"deleteName");
        String expected = "deleteThisName";
        OrigText replaceText = new OrigText(lastId,expected,lastText.getLanguage(),lastText.getAuthor(),lastText.getYear());
        runner.update(replaceText);
        list.clear();
        list = runner.findAll();
        Integer afterSize = list.size();
        Assert.assertEquals(beforeSize,afterSize);
        OrigText afterText = list.get(list.size()-1);
        String actual = afterText.getName();
        Assert.assertEquals(expected,actual);
        runner.delete(afterText.getId());
    }

    @Test
    public void delete() {
        String deleteName = "deleteName";
        OrigText toAdd = new OrigText(deleteName,"deleteLang","deleteAuth",(short)1919);
        runner.create(toAdd);
        List<OrigText> list = runner.findAll();
        Integer beforeSize = list.size();
        OrigText lastText = list.get(beforeSize-1);
        int lastId = lastText.getId();
        String expectedName = "deleteName";
        String actualName = lastText.getName();
        Assert.assertEquals(expectedName,actualName);
        runner.delete(lastId);
        list.clear();
        list = runner.findAll();
        Integer actual = list.size();
        Integer expected = beforeSize-1;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void updateFail() {
        List<OrigText> list = runner.findAll();
        OrigText replaceText = new OrigText(list.get(list.size()-1).getId()*50,"name","language","author",(short)1);
        Boolean myFalse = runner.update(replaceText);
        Assert.assertFalse(myFalse);
    }

    @Test
    public void deleteFail() {
        List<OrigText> list = runner.findAll();
        Integer beforeSize = list.size();
        OrigText lastText = list.get(beforeSize-1);
        int lastId = lastText.getId();
        Boolean myFalse = runner.delete(lastId*50);
        Assert.assertFalse(myFalse);
    }
}