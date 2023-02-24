package Models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Notes", schema = "dbo", catalog = "db_a92a77_testdb")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String note;
    private LocalDate createDate;

    public Note(String name, String note, LocalDate createDate) {
        this.name = name;
        this.note = note;
        this.createDate = createDate;
    }

    public Note() {

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDate getCreateTime() {
        return createDate;
    }

    public void setCreateTime(LocalDate createTime) {
        this.createDate = createTime;
    }

    @Override
    public String toString(){
        return "\nNote Id: " + id
                + "\nNote name: " + name
                + "\nNote text: " + note
                + "\nNote creating date: " + createDate + "\n\n";
    }

}
