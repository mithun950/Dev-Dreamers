package library;

import library.models.Book;
import library.services.Library;
import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. View Books");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Book Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Book Author: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(id, title, author));
                    System.out.println("Book added successfully.");
                    break;

                case 2:
                    System.out.print("Enter Book ID to remove: ");
                    String removeId = scanner.nextLine();
                    library.removeBook(removeId);
                    System.out.println("Book removed successfully.");
                    break;

                case 3:
                    library.viewBooks();
                    break;

                case 4:
                    System.out.print("Enter Book ID to borrow: ");
                    String borrowId = scanner.nextLine();
                    Book bookToBorrow = library.findBookById(borrowId);
                    if (bookToBorrow != null && bookToBorrow.isAvailable()) {
                        bookToBorrow.setAvailable(false);
                        System.out.println("Book borrowed successfully.");
                    } else {
                        System.out.println("Book is not available.");
                    }
                    break;

                case 5:
                    System.out.print("Enter Book ID to return: ");
                    String returnId = scanner.nextLine();
                    Book bookToReturn = library.findBookById(returnId);
                    if (bookToReturn != null && !bookToReturn.isAvailable()) {
                        bookToReturn.setAvailable(true);
                        System.out.println("Book returned successfully.");
                    } else {
                        System.out.println("This book was not borrowed.");
                    }
                    break;

                case 6:
                    System.out.println("Exiting the system.");
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
