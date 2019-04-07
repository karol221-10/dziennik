package pl.kompikownia.dziennik.dziennik.model.enums;

public enum SubjectType {
    ZAWODOWY,
    OGÓLNOKSZTALCĄCY;

    public String toLowerCase() {
        return this.name().toLowerCase();
    }
}
