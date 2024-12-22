public class ToDo {
    private boolean done;
    private String description;
    private String date;

    public ToDo (String description, String date) {
        this.done = false;
        this.description = description;
        this.date = date;
    }

    public boolean isDone() {
        return this.done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getDescription() {
        return this. description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
