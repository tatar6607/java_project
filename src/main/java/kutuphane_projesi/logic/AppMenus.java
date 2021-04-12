package kutuphane_projesi.logic;

import kutuphane_projesi.models.Author;
import kutuphane_projesi.models.Book;

import java.util.Scanner;

public class AppMenus {

    private final Scanner scan = new Scanner(System.in);
    private String[] menuItems = {"Kitap ekle", "Numara ile kitap sil", "Numara ile kitap ara", "Tüm kitapları listele", "Bitir "};
    private int i = 1;
    private boolean isContinue;

    public void getAppMenuMassage() {
        System.out.println("========= KİTAP PROGRAMI =============");
        for (String item : menuItems) {
            System.out.println(i++ + ": " + item);
        }
        i = 1;
        System.out.println("\nLutfen menuden rakamlari kullanarak secim yapiniz.");
    }

    public void getAppMenu() {
        int secim = scan.nextInt();
        switch (secim) {
            case 1:
                addBook();
                break;
            case 2:
                deleteBookWithId();
                break;
            case 3:
                searchBookWithId();
                break;
            case 4:
                showAllBooks();
                break;
            case 5:
                quitToApp();
                break;
            default:
                System.out.println("Lutfen gecerli bir secim yapiniz");
                getAppMenu();
        }

    }

    private void addBook() {
        System.out.println("============ KITAP EKLEME BOLUMU ============");
        do {
            System.out.println("Lutfen kitap bilgilerini giriniz.\n");
            scan.nextLine();

            System.out.println("Kitap adi: ");
            String bookName = scan.nextLine();

            System.out.println("Yazar adi:  ");
            String yazar = scan.nextLine();
            Author author = new Author(yazar);

            System.out.println("Yayin yili: ");
            String date = scan.nextLine();

            System.out.println("Fiyat: ");
            double price = scan.nextDouble();

            Book book = new Book(bookName, author, date, price);

            BooksService bookAdd = new BooksService();
            bookAdd.setBookList(book);

            System.out.println("Yeni kitap eklemek icin \"E\"  \nAna menuye isinlanmak icin herhangi bir harf giriniz.");
            setContinue("E");
        } while (isContinue);

        getAppMenuMassage();
        getAppMenu();

    }

    private void deleteBookWithId() {
        System.out.println("============ KITAP SILME BOLUMU ============");
        int id = 0;
        do {
            System.out.println("Lutfen silmek istediginiz kitabin numarasini yaziniz.");
            id = scan.nextInt();
            BooksService.deleteBook(id);
            System.out.println("Yeni kitap silmek icin \"S\" \nAna menuye isinlanmak icin herhangi bir harf giriniz");
            String del = scan.next();
            isContinue = del.equalsIgnoreCase("s");
        } while (isContinue);

        getAppMenuMassage();
        getAppMenu();

    }

    private void searchBookWithId() {
        System.out.println("============ KITAP ARAMA BOLUMU ============");
        do {
            System.out.println("Lutfen kitap numarasini giriniz.");
            int id = scan.nextInt();
            BooksService.findBook(id);
            System.out.println("Yeni kitap aramak icin \"A\" \nAna menuye isinlanmak icin herhangi bir harf giriniz");
            setContinue("a");
        } while (isContinue);
        getAppMenuMassage();
        getAppMenu();
    }

    private void showAllBooks() {

        System.out.println("============ KITAPLARI LISTELEME BOLUMU ============");
        BooksService books = new BooksService();

        for (int i = 0; i < books.getBookList().size(); ) {
            System.out.println(++i + ". kitap: " + books.getBookList().get(i - 1).toString());
        }

        getAppMenuMassage();
        getAppMenu();

    }

    private void quitToApp() {

        try {
            System.out.println("Sizi uygulamanin disina gercek dunyaya isinliyoruz");
            Thread.sleep(1000);
            int i = 1;
            while (i < 4) {
                System.out.println("Islem basarisiz.... Tekrar deneniyor.");
                Thread.sleep(900);
                i++;
            }
            Thread.sleep(500);
            System.out.println("Malesef isinlanilan yer yalan dunya :)");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public void setContinue(String letter) {
        String text = scan.next();
        isContinue = text.equalsIgnoreCase(letter);
    }
}
