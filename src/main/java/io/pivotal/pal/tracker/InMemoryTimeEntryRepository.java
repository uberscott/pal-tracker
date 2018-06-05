package io.pivotal.pal.tracker;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{
    private Map<Long,TimeEntry> map = new HashMap<>();
    private int idIndex = 0;

    @Override
    public TimeEntry create(TimeEntry any) {
        idIndex++;
        any.setId( idIndex);
        map.put(any.getId(), any );
        return any;
    }

    @Override
    public TimeEntry find(Long l) {
        return  map.get(l);
    }

    @Override
    public List<TimeEntry> list() {

        List<TimeEntry> rtn = new ArrayList<>(map.values());
        return  rtn ;
    }

    @Override
    public  TimeEntry update(Long id, TimeEntry any) {
        if( !map.containsKey(id))
            return null;
        any.setId(id);
        map.put( id, any );
        return any;
    }

    @Override
    public void delete(Long l) {

        map.remove(l);
    }

}
