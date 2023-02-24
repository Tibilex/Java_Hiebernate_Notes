import Controller.NoteController;
import Models.Note;
import Utils.HibernateFactoryUtil;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    private static NoteController _noteController;
    private static Scanner _console;
    public static void main(String[] args) {
        _noteController = new NoteController();
        _console = new Scanner(System.in);
        int menuChoice = 0;
        while ( true ) {
            try {
                System.out.print("""
                         Menu
                        |===========================|
                        | 1 = Show all Notes\t\t|
                        | 2 = Show note by id\t\t|
                        | 3 = Add note\t\t\t\t|
                        | 4 = Delete note\t\t\t|                
                        | 0 = Exit\t\t\t\t\t|
                        |===========================|
                        """);
                menuChoice = _console.nextInt();
                switch (menuChoice) {
                    case 1:
                        System.out.println(_noteController.getAllNotes());
                        break;
                    case 2:
                        System.out.print("Enter note Id: ");
                        int id = _console.nextInt();
                        System.out.println("\nSelected note:");
                        System.out.println(_noteController.searchNoteById(id));
                        break;
                    case 3:
                        System.out.println("\nEnter note name: ");
                        String name = _console.nextLine();
                        System.out.print("Enter note text: ");
                        String noteText = _console.nextLine();
                        Note note = new Note(name, noteText, LocalDate.now());
                        _noteController.addNote(note);
                        break;
                    case 4:
                        System.out.print("Enter note Id: ");
                        int noteId = _console.nextInt();
                        _noteController.deleteNote(_noteController.searchNoteById(noteId));
                        break;
                    case 0:

                        return;
                    default:
                }

            } catch ( Exception ex ) {
                System.out.println(ex.getMessage());
            }
        }
    }
}