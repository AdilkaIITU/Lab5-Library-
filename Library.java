import java.util.ArrayList;

public class Library {
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<Student> students = new ArrayList<>();
    public void AddBook(Book book){
        books.add(book);
    }
    public void ShowBookInLibrary(){
        System.out.println("Books: ");
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            System.out.println("Index book: "+i+"  Title: " + book.title + "  Author: "+ book.author + "  Isbn: "+ book.isbn + "  Year: "+ book.year + " quantity: "+ book.quantity);
        }
    }
    public void AddStudent(Student student){
        students.add(student);
    }
    public void ShowStudentInLibrary(){
        System.out.println("Students: ");
        for(int i = 0; i < students.size(); i++){
            Student student = students.get(i);
            System.out.println("Index student: "+i+ "  Id: "+ student.id+"  Name: " + student.name + "  Surname: "+ student.surname + "  Group: "+ student.group);
        }
    }
    public void AddAssign(int bookIndex, int studentIndex){
        Book book = new Book();
        for(int i = 0; i < books.size(); i++){
            if (bookIndex == i ){
                book = books.get(i);
            }
        }
        for(int i = 0; i < students.size(); i++){
            if (studentIndex == i){
                Student student = students.get(i);
                student.borrowedBooks.add(book);
                students.add(student);
                students.remove(studentIndex);
            }
        }

    }
    public void RemoveAssign(int studentIndex, String bookTitle ){
        Student student;
        Book bookTMP;
        for (int i = 0; i < students.size(); i++) {
            if (studentIndex == i){
                student = students.get(i);
                System.out.println("Student name:" + student.name);
                for (int j = 0; j < student.borrowedBooks.size(); j++) {
                    bookTMP = student.borrowedBooks.get(j);
                    if ( bookTMP.title.equals(bookTitle) ){
                        student.borrowedBooks.remove(bookTMP);
                        students.add(student);
                        students.remove(i);
                    }
                }

            }
        }

    }
    public void ShowAssign(){
        Student student;
        Book book;
        for (int i = 0; i < students.size(); i++) {
            student = students.get(i);
            System.out.println(student.name + ": ");
            if (student.borrowedBooks.size() > 0){
                for (int j = 0; j < books.size(); j++) {
                    book = student.borrowedBooks.get(j);
                    System.out.print( j +" - "+ book.title+" ");
                }
            }
            System.out.println();
        }
    }
}
