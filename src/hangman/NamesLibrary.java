package hangman; // 26 Nov, 08:56 PM

// This class will contain all the possible names for the game
public class NamesLibrary {

    public static final int BOLLYWOOD = 1;
    public static final int HOLLYWOOD = 2;
    public static final int OTHER = 3;

	// 0 - 9 > Easy
    // 10 - 19 > medium
    // 20 - 29 > hard


    public String[] bollyWords = {
            "ABC", "DEF", "GHI", "JKL","MNO","PQR","STU","VWX","YZA","BCD",
            "ABCD", "EFGH", "IJKL","MNOP","QRST","UVWX","YZAB","CDEF","GHIJ","KLMN",
            "ABCDE","ABCDE","ABCDE","ABCDE","ABCDE","ABCDE","ABCDE","ABCDE","ABCDE","ABCDE",
    };
	
    public String[] hollyWords = {
            "ABC", "DEF", "GHI", "JKL","MNO","PQR","STU","VWX","YZA","BCD",
            "ABCD", "EFGH", "IJKL","MNOP","QRST","UVWX","YZAB","CDEF","GHIJ","KLMN",
            "ABCDE","ABCDE","ABCDE","ABCDE","ABCDE","ABCDE","ABCDE","ABCDE","ABCDE","ABCDE",
    };
	
    public String[] otherWords = {
            "ABC", "DEF", "GHI", "JKL","MNO","PQR","STU","VWX","YZA","BCD",
            "ABCD", "EFGH", "IJKL","MNOP","QRST","UVWX","YZAB","CDEF","GHIJ","KLMN",
            "ABCDE","ABCDE","ABCDE","ABCDE","ABCDE","ABCDE","ABCDE","ABCDE","ABCDE","ABCDE",
    };



}
