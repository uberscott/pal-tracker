package io.pivotal.pal.tracker;

import java.time.LocalDate;

public class TimeEntry {
    private long id;
    private long projectId;
    private long userId;
    private LocalDate date;
    private int hours;


    public TimeEntry(){}

    public TimeEntry(  long projectId,long userId, LocalDate date, int hours) {
        this( 0l,  projectId, userId, date, hours);
    }

    public TimeEntry( long id,long projectId,long userId,  LocalDate date, int hours) {
        this.setId(id);
        this.setProjectId(projectId);
        this.setUserId(userId);
        this.setDate(date);
        this.setHours(hours);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public boolean equals( Object o )
    {
        TimeEntry te = (TimeEntry)o;
        return id == te.getId() &&
               projectId == te.getProjectId() &&
                userId == te.getUserId() &&
                date.equals(te.getDate());
    }
}
