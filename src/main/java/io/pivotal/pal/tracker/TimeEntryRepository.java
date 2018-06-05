package io.pivotal.pal.tracker;

import org.springframework.http.ResponseEntity;

import java.util.*;

public interface TimeEntryRepository {

    public TimeEntry create(TimeEntry any);

    public TimeEntry find(Long id);

    public List<TimeEntry> list() ;

    public  TimeEntry update(Long id, TimeEntry any);

    public void delete(Long id);


}
