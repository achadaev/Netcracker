public class Main {
	public static void main(String[] args) {
		Author author = new Author("Chekhov", "qwe@gmail.com", 'm');
		Author author3 = new Author("Chekhov", "qwe@gmail.com", 'm');
		Author author2 = new Author("Black", "black@gmail.com", 'm');

		System.out.println(author.equals(author3));
		System.out.println("author.hashCode() = " + author.hashCode());
		System.out.println("author3.hashCode() = " + author3.hashCode());
	}
}