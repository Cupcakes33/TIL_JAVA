package Section10.section10Q;

public class QMain {
    public static void main(String[] args) {
        Book book = new Book("JAVA", 10000, "Han", "12345");
        Album album = new Album("앨범1", 15000, "seo");
        Movie movie = new Movie("영화1", 18000, "감독1", "배우1");

        book.print();
        album.print();
        movie.print();

        int sum = book.getPrice() + album.getPrice() + movie.getPrice();
        System.out.println("상품 가격의 합은 " + sum + "원 입니다.");
    }
}
