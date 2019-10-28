public class Book {
    private String name;
    private Author[] authors;
    private double price;
    private int qty = 0;

    Book(String name, Author[] authors, double price) {
        this.name = name;
        this.price = price;
        for (int i = 0; i < authors.length; i++)
            this.authors[i] = authors[i];
    }

    Book(String name, Author[] authors, double price, int qty) {
        this.name = name;
        this.price = price;
        this.qty = qty;
        this.authors = new Author[authors.length];
        for (int i = 0; i < authors.length; i++)
            this.authors[i] = authors[i];
    }

    public String getName() {
        return name;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        String res = "Book[name=" + name + ",authors={";
        for (Author a : authors) {
            res += ("Author[name=" + a.getName() + ",email=" + a.getEmail() + ",gender=" + a.getGender() + "]");
        }
        res += "},price=" + price + ",qty=" + qty + "]";
        return res;
    }

    public String getAuthorNames() {
        String res = new String();
        for (int i = 0; i < authors.length; i++) {
            res += authors[i].getName();
            if (i != authors.length - 1) res += ", ";
        }
        return res;
    }
}
