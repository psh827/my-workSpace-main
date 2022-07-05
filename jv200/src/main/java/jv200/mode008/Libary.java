package jv200.mode008;
/**
 * 싱글톤 패턴.
 * @author Administrator
 *
 */
public class Libary {
	private static Libary test = new Libary();

	private Libary(){
		
	}
	
	public static Libary getLibary() {
		return test;
	}

	private static int listLeng = 100;
	private static String[][] bookList = new String[listLeng][2];
	private static int bookIndex = 0;
	private String giveBook = "";

	
	public void addBook(Book book) {		
		if (bookIndex >= listLeng) {
			listLeng *= 2;
			String[][] copy = bookList;
			bookList = new String[listLeng][2];
			System.arraycopy(copy, 0, bookList, 0, copy.length);
		}
		bookList[bookIndex][0] = book.getBookName();
		bookList[bookIndex][1] = book.getSerial();
		bookIndex++;
	}
	
	public String getBook(int serial) {
		for(int i = 0; i < bookList.length; i++) {
			if(Integer.toString(serial).equals(bookList[i][1])){
				giveBook = bookList[i][0]; 
			}
		}
		return giveBook;	
	}
}
