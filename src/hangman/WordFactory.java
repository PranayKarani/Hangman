package hangman; // 26 Nov, 08:47 PM

import java.util.Random;

// This is class will generate random words from NamesLibrary.java depending upon te difficulty choosen.
// The generated word won't have missing letters yet.
public class WordFactory {

    public int missingLetters;
    NamesLibrary namesLibrary; // Declare NamesLibrary object
    Random       random; // Random object. This object is used to generate random data.
    String word;

    // Inintialize the declated objects in Constructor
    public WordFactory() {
        namesLibrary = new NamesLibrary();
        random = new Random();
    }

    // GENERATING THE

    // This method takes in difficutly (int)value (see Difficulty.java) and
    // returns randomly generated word.
    public String generateWord(int difficuilty, int option) {

        String selectedWord = null;
        int randomWordIndex = 0;

        switch (difficuilty) {
            case Difficulty.EASY:

                randomWordIndex = random.nextInt(9);

                switch (option) {

                    case NamesLibrary.BOLLYWOOD:
                        selectedWord = namesLibrary.bollyWords[randomWordIndex];
                        break;
                    case NamesLibrary.HOLLYWOOD:
                        selectedWord = namesLibrary.hollyWords[randomWordIndex];
                        break;
                    case NamesLibrary.OTHER:
                        selectedWord = namesLibrary.otherWords[randomWordIndex];
                        break;

                }
                break;
            case Difficulty.MEDIUM:

                randomWordIndex = 10 + random.nextInt(9);

                switch (option) {

                    case NamesLibrary.BOLLYWOOD:
                        selectedWord = namesLibrary.bollyWords[randomWordIndex];
                        break;
                    case NamesLibrary.HOLLYWOOD:
                        selectedWord = namesLibrary.hollyWords[randomWordIndex];
                        break;
                    case NamesLibrary.OTHER:
                        selectedWord = namesLibrary.otherWords[randomWordIndex];
                        break;

                }


                break;
            case Difficulty.HARD:

                randomWordIndex = 20 + random.nextInt(9);

                switch (option) {

                    case NamesLibrary.BOLLYWOOD:
                        selectedWord = namesLibrary.bollyWords[randomWordIndex];
                        break;
                    case NamesLibrary.HOLLYWOOD:
                        selectedWord = namesLibrary.hollyWords[randomWordIndex];
                        break;
                    case NamesLibrary.OTHER:
                        selectedWord = namesLibrary.otherWords[randomWordIndex];
                        break;

                }

                break;
        }
        return selectedWord;
    }

    public char[] finalWordToGuessFrom(String word, int difficuly) {

        this.word = word;
        char[] wordArray;
        wordArray = word.toCharArray();
        int[] missingLetterIndices;// indices of letters to be kidnapped

        switch (difficuly) {
            case Difficulty.EASY:

                // calculate how many letters would be missing
                missingLetters = 1 + random.nextInt(2);

                // letters at these indexes would be missing
                missingLetterIndices = new int[missingLetters];

                // setting everything to -1
                for(int x = 0;x < missingLetterIndices.length; x++){
                    missingLetterIndices[x] = -1;
                }

                // generating random indices
                for (int i = 0; i < missingLetterIndices.length; i++) {

                    missingLetterIndices[i] = returnNewRandom(missingLetterIndices);
                    System.out.print(missingLetterIndices[i]+", ");

                }

                // kidnapping letters
                for (int x : missingLetterIndices) {

                    wordArray[x] = '_';
                }

                break;
            case Difficulty.MEDIUM:

                // calculate how many letters would be missing
                missingLetters = 2 + random.nextInt(2);

                // letters at these indexes would be missing
                missingLetterIndices = new int[missingLetters];

                // setting everything to -1
                for(int x = 0;x < missingLetterIndices.length; x++){
                    missingLetterIndices[x] = -1;
                }

                // generating random indices
                for (int i = 0; i < missingLetterIndices.length; i++) {

                    missingLetterIndices[i] = returnNewRandom(missingLetterIndices);
                    System.out.print(missingLetterIndices[i]+", ");

                }

                // kidnapping letters
                for (int x : missingLetterIndices) {

                    wordArray[x] = '_';
                }

                break;

            case Difficulty.HARD:

                // calculate how many letters would be missing
                missingLetters = 3 + random.nextInt(2);

                // letters at these indexes would be missing
                missingLetterIndices = new int[missingLetters];

                // setting everything to -1
                for(int x = 0;x < missingLetterIndices.length; x++){
                    missingLetterIndices[x] = -1;
                }

                // generating random indices
                for (int i = 0; i < missingLetterIndices.length; i++) {

                    missingLetterIndices[i] = returnNewRandom(missingLetterIndices);

                }

                // kidnapping letters
                for (int x : missingLetterIndices) {
                    wordArray[x] = '_';
                }

                break;

        }

        return wordArray;
    }

    // THIS IS THE SECRET SAUCE
    int returnNewRandom(int[] arr) {

        int x = random.nextInt(word.length());

        if (isPresentInArray(x, arr)) {
            return returnNewRandom(arr);
        } else {
            return x;
        }

    }

    boolean isPresentInArray(int x, int[] arr) {
        boolean isPresent = false;
        for (int anArr : arr) {
            if (x == anArr) {
                isPresent = true;
                break;
            }
        }

        return isPresent;
    }


}
