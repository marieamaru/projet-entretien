package com.example.demo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Objects;

public class Task {

    private final int id;
    private final String label;
    private final Type type;
    private final LocalDate date;
    private final boolean state;

    public Task(int id,String label, Type type, LocalDate date, boolean state) {
        this.id=id;
        this.label=label;
        this.type=type;
        this.date=date;
        this.state=state;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public Type getType() {
        return type;
    }

    public LocalDate getDate() {
        return date;
    }

    public boolean getState() {
        return state;
    }


    public int compareByDate(Task task) {
        Objects.requireNonNull(task);
        if (this.getDate().isBefore(task.getDate())) {
            return -1;
        }
        return 1;
    }

    public int compareByLabel(Task task){
        Objects.requireNonNull(task);
        return this.getLabel().toLowerCase().compareTo(task.label.toLowerCase());
    }
    /*
    Une tâche comporte les propriétés suivantes :
    - Un identifiant (numérique
    - Un label (la tâche à accomplir)
    - Un type de tâche (personnel, professionnel)
    - Une date de création
    - Un état (faite / non faite)

    La liste comporte les actions suivantes

            - [ ]  Ajouter une tâche (via l'identifiant)
            - [ ]  Supprimer une tâche (via l'identifiant)
            - [ ]  Editer une tâche (via l'identifiant)
            - [ ]  Trier par la date d'ajout
            - [ ]  Trier par tâche (alphanumérique)

    */
}
