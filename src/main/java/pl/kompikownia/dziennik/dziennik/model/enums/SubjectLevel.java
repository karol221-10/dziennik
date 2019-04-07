package pl.kompikownia.dziennik.dziennik.model.enums;

public enum SubjectLevel {
    PODSTAWOWY,
    ROZSZERZONY;
    public String toLowerCase() {
        return this.name().toLowerCase();
    }
}
