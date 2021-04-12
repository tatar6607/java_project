package kutuphane_projesi.logic;

import kutuphane_projesi.models.Book;

import java.util.ArrayList;
import java.util.List;

public class BooksService {

    private static List<Book> bookList = new ArrayList<>();
    private static int count;

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(Book book) {
        bookList.add(book);
    }

    public static void findBook(int id) {
        if (bookList.size() <= 0) {
            System.out.println("Henuz hic kitap eklenmedi");
            System.out.println("Kitap eklemek icin ana menuden kitap ekle bolumune giris yapiniz.");
        } else {
            for (Book book : bookList) {
                if (book.getId() == id) {
                    System.out.println(id + " numarali kitap: " + book.toString());
                    break;
                } else {
                   count++;
                }
            }
            if(bookList.size()==count) {
                System.out.println("Boyle bir kitap bulunamadi.");
            }
        }
    }

    public static void deleteBook(int id) {

     try{
         if (bookList.size() <= 0) {
             System.out.println("Henuz hic kitap eklenmedi");
             System.out.println("Kitap eklemek icin ana menuden kitap ekle bolumune giris yapiniz.");
         } else {
             for (Book book : bookList) {
                 if (book.getId() == id) {
                     boolean isDeleted = bookList.remove(book);
                     String message = isDeleted ? id + " numarali kitap basariyla silindi" : "Silmeyi tekrar deneyiniz.";
                     System.out.println(message);
                     break;
                 } else {
                     count++;
                 }
             }

             if(count == bookList.size()) {
                 System.out.println("Boyle bir kitap bulunamadi.");
                 count = 0;
             }
         }
     }catch (Exception e) {

     }

    }
}
