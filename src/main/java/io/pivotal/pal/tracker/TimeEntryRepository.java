package io.pivotal.pal.tracker;

import org.springframework.http.ResponseEntity;

import java.util.*;

public interface TimeEntryRepository {

    public TimeEntry create(TimeEntry any);

    public TimeEntry find(long l);

    public List<TimeEntry> list() ;

    public  TimeEntry update(long eq, TimeEntry any);

    public TimeEntry delete(long l);


}
