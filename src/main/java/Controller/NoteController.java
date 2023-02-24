package Controller;

import Models.Note;
import Utils.HibernateFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class NoteController {

    public Note searchNoteById(int id) {
        return HibernateFactoryUtil.getSessionFactory().openSession().get(Note.class, id);
    }
    public List<Note> getAllNotes(){
        List<Note> notesList = (List<Note>)HibernateFactoryUtil.getSessionFactory().openSession().createQuery("From Note").list();
        return notesList;
    }
    public void addNote( Note note ) {
        Session session = HibernateFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(note);
        transaction.commit();
        session.close();
    }

    public void deleteNote ( Note note ) {
        Session session = HibernateFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.remove(note);
        transaction.commit();
        session.close();
    }

    public void updateNote( Note note ) {
        Session session = HibernateFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(note);
        transaction.commit();
        session.close();
    }
}
