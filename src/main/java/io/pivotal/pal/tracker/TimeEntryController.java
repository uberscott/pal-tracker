package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/time-entries")
public class TimeEntryController {
    private TimeEntryRepository repos;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.repos = timeEntryRepository;
    }

    @PostMapping(consumes="application/json")
    public ResponseEntity create( @RequestBody TimeEntry timeEntryToCreate) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repos.create(timeEntryToCreate));


    }


    @ResponseBody
    @RequestMapping(value="/time-entries/{id}",method=RequestMethod.GET)
    public ResponseEntity<TimeEntry> read(@PathVariable ("id") long l) {
        TimeEntry rtn = repos.find(l);
        if( rtn == null )
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(rtn);

    }


    @GetMapping
    public ResponseEntity<List<TimeEntry>> list() {
        return ResponseEntity.ok(repos.list());
    }

    @PutMapping(value="/time-entries/{id}")
    public ResponseEntity update(@PathVariable long id, @RequestBody TimeEntry expected) {


       TimeEntry rtn = repos.update(id,expected);
        if( rtn == null )
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(rtn);

    }


    @RequestMapping(value="/time-entries/{id}",method=RequestMethod.DELETE)
    public ResponseEntity<TimeEntry> delete(@PathVariable long id) {
        TimeEntry rtn = repos.delete(id);
        if( rtn == null )
        {
          //return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(rtn);
        }
    }
}
