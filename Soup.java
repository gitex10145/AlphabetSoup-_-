//Name Danilo Vranic
//Date 09/28/26
//Description This class stores the soup letters and company name and lets the user add, remove, and change the letters
public class Soup {
    //these are instance variables
    private String letters;
    private String company;

    // Input none
    // Output starts with an empty letter pool and company set to none
    // Precondition none
    // Postcondition letters is empty and company is set to none
    public Soup() {
        letters = "";
        company = "none";
    }

    // Input a company name
    // Output sets the company name
    // Precondition input should be a valid String
    // Postcondition company stores the new name
    public void setCompany(String company) {
        if (company == null || company.trim().isEmpty()) {
            this.company = "none";
        } else {
            this.company = company;
        }
    }

    // Input none
    // Output returns the company name
    // Precondition none
    // Postcondition returns the current company value
    public String getCompany() {
        return company;
    }

    // Input none
    // Output returns the current letters
    // Precondition none
    // Postcondition returns the letters string
    public String getLetters() {
        return letters;
    }

    // Input a word or letters to add
    // Output adds them to the soup letters
    // Precondition input should be a valid String
    // Postcondition word is added to letters
    public void add(String word) {
        if (word == null) {
            return;
        }
        letters += word;
    }

    // Input none
    // Output returns a random letter from the letters string
    // Precondition letters must contain at least one character
    // Postcondition returns one random letter from letters
    public char randomLetter() {
        if (letters == null || letters.length() == 0) {
            return '\0';
        }
        int index = (int) (Math.random() * letters.length());
        return letters.charAt(index);
    }

    // Input none
    // Output puts the company name in the middle of the letters
    // Precondition letters and company may be empty
    // Postcondition company is centered inside letters
    public String companyCentered() {
        if (letters == null) {
            letters = "";
        }
        if (company == null) {
            company = "";
        }
        if (company.length() == 0) {
            return letters;
        }
        int middle = letters.length() / 2;
        return letters.substring(0, middle) + company + letters.substring(middle);
    }

    // Input none
    // Output removes the first vowel in the letters
    // Precondition letters may be empty
    // Postcondition the first vowel is removed if it exists
    public void removeFirstVowel() {
        if (letters == null || letters.length() == 0) {
            return;
        }
        String vowels = "aeiouAEIOU";
        for (int i = 0; i < letters.length(); i++) {
            if (vowels.indexOf(letters.charAt(i)) != -1) {
                letters = letters.substring(0, i) + letters.substring(i + 1);
                return;
            }
        }
    }

    // Input a number of letters to remove
    // Output removes that many random letters
    // Precondition num is a valid integer and should not be larger than letters
    // Postcondition num letters are removed from a random spot
    public void removeSome(int num) {
        if (letters == null || letters.length() == 0 || num <= 0) {
            return;
        }
        if (num >= letters.length()) {
            letters = "";
            return;
        }
        int start = (int) (Math.random() * (letters.length() - num + 1));
        letters = letters.substring(0, start) + letters.substring(start + num);
    }

    // Input a word to remove
    // Output removes that word from the letters if it is there
    // Precondition word should be a valid String
    // Postcondition the word is removed from letters if present
    public void removeWord(String word) {
        if (word == null || word.isEmpty() || letters == null) {
            return;
        }
        letters = letters.replace(word, "");
    }
}
