package kutuphane_projesi.models;

public class Book {

    private Integer id = 1000;
    private static Integer count = 0;
    private String bookName;
    private Author author;
    private String publishDate;
    private Double price;

    public Book() {
    }

    public Book(String bookName, Author author, String publishDate, Double price) {
        count++;
        id += count;
        this.bookName = bookName;
        this.author = author;
        this.price = price;
        this.publishDate = publishDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static Integer getCount() {
        return count;
    }

    public static void setCount(Integer count) {
        Book.count = count;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", author=" + author +
                ", publishDate='" + publishDate + '\'' +
                ", price=" + price +
                '}';
    }
}
