package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    List<TimeEntry> list = new ArrayList<>();

    public TimeEntry create(TimeEntry timeEntry) {
        timeEntry.setId(list.size()+1);
        list.add(timeEntry);
        return timeEntry;
    }

    public TimeEntry find(long id) {
        for(TimeEntry time : list) {
            if(time.getId() == id) {
                return time;
            }
        }
        return null;
    }

    public List<TimeEntry> list() {
        return list;
    }

    public TimeEntry update(long id, TimeEntry timeEntry) {
        delete(id);
        timeEntry.setId(id);
        list.add(timeEntry);
        return timeEntry;
    }

    public void delete(long id) {
        list.remove(find(id));
    }
}
