public class Book {
    // TODO: Declare fields
  private String title;
  private String author;
  private String isbn;
  private int publicationYear;
  private int copies; 
  private int availableCopies; 

  public Book(String title, String author, String isbn, int publicationYear, int copies)
    throws InvalidBookException{
    if (title == null || "".equals(title.trim())){
      throw new InvalidBookException("Title cannot be null or empty", title, "title");
    }
    if (author == null || "".equals(author.trim())){
      throw new InvalidBookException("Author cannot be null or empty", title.trim(), "author");
    }
    if (author.trim().split("\\s+").length < 2){
      throw new InvalidBookException("Author must consist of at least two words", title.trim(), "author", author);
    }
    if (publicationYear < 1000 || publicationYear > java.time.Year.now().getValue()){
      throw new InvalidBookException("Publication year must be between 1000 and " + java.time.Year.now().getValue(), title.trim(), "publicationYear", String.valueOf(publicationYear));
    }
    if (copies < 0){
      throw new InvalidBookException("Copies cannnot be negative", title.trim(), "copies", String.valueOf(copies));
    }
    if (!isValidISBN(isbn)){
      throw new InvalidBookException("ISBN is not valid", title.trim(), "isbn", isbn);
    }
    this.title = title.trim();
    this.author = author.trim();
    this.isbn = isbn.trim();
    this.publicationYear = publicationYear;
    this.copies = copies;
    availableCopies = copies;
  }

  private boolean isValidISBN(String isbn){
    if (isbn.trim() == null){
      return false;
    }
    String cleanISBN = isbn.replaceAll("[\\s-]", "");
    if (cleanISBN.length() == 10){
      return isValidISBN10(cleanISBN);
    }
    if (cleanISBN.length() == 13){
      return isValidISBN13(cleanISBN);
    }
    else{
      return false;
    }
  }

  private boolean isValidISBN10(String isbn){
    try {
      if (isbn == null || isbn.trim().length() != 10){
        return false;
      }
      
      int sum = 0;

      for (int i=0; i<9; i++){
        char c = isbn.charAt(i);

        int digit = Integer.parseInt(String.valueOf(c));

        int weight = 10 - i;

        sum += digit * weight;
      }

      char lastChar = isbn.charAt(9);

      if (lastChar == 'X' || lastChar == 'x'){
        sum += 10;
      }
      else {
        int checkDigit = Integer.parseInt(String.valueOf(lastChar));
        sum += checkDigit;
      }
      return sum % 11 == 0;
    }

    catch (Exception e){
      return false;
    }
  }
    private boolean isValidISBN13(String isbn){
      try {
        if (isbn == null || isbn.trim().length() != 13){
          return false;
        }

        int sum = 0;

        for (int i=0; i<13 ; i+=2){
          char c = isbn.charAt(i);

          int oddDigit = Integer.parseInt(String.valueOf(c));

          sum += oddDigit;
        }

        for (int i=1; i<13; i+=2){
          char c = isbn.charAt(i);

          int evenDigit = Integer.parseInt(String.valueOf(c));
          
          sum += evenDigit * 3;
        }

        return sum % 10 == 0;
      }

      catch(Exception e){
        return false;
      }
    }

    // TODO: Implement getters
    public String getTitle(){
      return title;
    }

    public String getAuthor(){
      return author;
    }

    public String getIsbn(){
      return isbn;
    }

    public int getPublicationYear(){
      return publicationYear;
    }

    public int getCopies(){
      return copies;
    }

    public int getAvailableCopies(){
      return availableCopies;
    }

    // TODO: Implement borrowBook()
  public void borrowBook() throws BookNotAvailableException{
    if (availableCopies <= 0){
      throw new BookNotAvailableException("Book not available", title, 1, availableCopies);
    }
    availableCopies--;
  }

    // TODO: Implement returnBook()

  public void returnBook() throws InvalidBookException{
    if (availableCopies >= copies){
      throw new InvalidBookException("Book data is not valid");
    }
    availableCopies++;
  }

    // TODO: Implement toString()
  public String toString(){
    return title + " by " + author + " (" + publicationYear + ") [ISBN: " + isbn + "] - Available: " + availableCopies + "/" + copies;
  }
}
