import java.util.Scanner;

public class Main {
    public static Library library = new Library();
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        while (true){
            System.out.println();
            System.out.println("Choose variant");
            System.out.println("1 - add book");
            System.out.println("2 - add student");
            System.out.println("3 - add assign book for student");
            System.out.println("4 - remove assign book for student");
            System.out.println("5 - show all assigns");
            System.out.println("6 - show all student");
            System.out.println("7 - show all book");
            switch (scan.nextInt()){
                case 1:
                    addBook();
                    break;
                case 2:
                    addStudent();
                    break;
                case 3:
                    Assign();
                    break;
                case 4:
                    Remove();
                    break;
                case 5:
                    ShowAssign();
                    break;
                case 6:
                    ShowStudent();
                    break;
                case 7:
                    ShowBook();
                    break;
                default:
                    break;
            }


        }
    }
    public static void addBook(){
        Book book = new Book();
        System.out.println("Enter book title");
        book.setTitle(scan.next());
        System.out.println("Enter book author");
        book.setAuthor(scan.next());
        System.out.println("Enter book isbn");
        book.setIsbn(scan.next());
        System.out.println("Enter book year");
        book.setYear(scan.nextInt());
        System.out.println("Enter book quantity");
        book.setQuantity(scan.nextInt());
        library.AddBook(book);

    }
    public static void addStudent(){
        Student student = new Student();

        System.out.println("Enter student ID");
        student.setId(scan.nextInt());
        System.out.println("Enter student name");
        student.setName(scan.next());
        System.out.println("Enter student surname");
        student.setSurname(scan.next());
        System.out.println("Enter student group");
        student.setGroup(scan.next());
        library.AddStudent(student);


    }
    public static void Assign(){
        library.ShowBookInLibrary();
        System.out.println("Choose book");
        int bookIndex = scan.nextInt();
        library.ShowStudentInLibrary();
        System.out.println("Choose student");
        int studentIndex = scan.nextInt();
        library.AddAssign( bookIndex, studentIndex);
    }
    public static void Remove(){
        library.ShowStudentInLibrary();
        System.out.println("Choose student");
        int studentIndex = scan.nextInt();
        System.out.println("Choose Title");
        String bookTitle = scan.next();
        library.RemoveAssign( studentIndex, bookTitle );
    }
    public static void ShowAssign(){
        library.ShowAssign();
    }
    public static void ShowStudent(){
        library.ShowStudentInLibrary();
    }
    public static void ShowBook(){
        library.ShowBookInLibrary();
    }
}