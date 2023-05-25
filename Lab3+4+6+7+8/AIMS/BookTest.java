public class BookTest {
    public static void main(String[] args) {
        Book book = new Book("A Tale of Two cities");
    
        book.setContent("Where is the child? - Úrsula wondered. Aureliano explained to her in a few words: 'He's alive; he's at the bottom of the chest - he said -; but I didn't want to bring him until I was sure that he was alive, because I didn't want to raise false hopes.' Úrsula did not understand the explanation: 'What chest?' she asked. 'The chest of the broken things,' he answered; 'the one in the corner of the workshop.' Úrsula felt a cold chill: 'God have mercy on us!' she exclaimed. 'You've locked him up alive!'");

        System.out.println(book.getContentTokens());
        System.out.println(book.getWordFrequency());
    }
}
