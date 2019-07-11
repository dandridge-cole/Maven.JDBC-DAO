package models;

public class OrigText implements Dto {
    private int id;
    private String name;
    private String language;
    private String author;
    private Short year;


    public OrigText(int id, String name, String language, String author, Short year) {
        this.id = id;
        this.name = name;
        this.language = language;
        this.author = author;
        this.year = year;
    }


    public OrigText(String name, String language, String author, Short year) {
        this(0,name,language,author,year);
    }

    public OrigText(){this("","","",(short)0);}

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Short getYear() {
        return year;
    }

    public void setYear(Short year) {
        this.year = year;
    }
}
