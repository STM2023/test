package com.goit.proj2.controler;

import com.goit.proj2.service.Note;
import com.goit.proj2.service.NoteService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Validated
@RequiredArgsConstructor
@Controller
@RequestMapping("/note")
public class NoteController {

    //    @Autowired
//    private NoteService noteService;
    private final NoteService noteService;
    @RequestMapping(value = "/list", method = {RequestMethod.GET})
    public ModelAndView noteList() {
        ModelAndView result = new ModelAndView("notes/allNotes");
        result.addObject("notes", noteService.findAll());

        return result;
    }

    @RequestMapping(value = "/delete", method = {RequestMethod.POST})
    public ModelAndView deleteNoteById(@Valid @NotNull @RequestParam(value="id")  long id) throws  Exception {
        noteService.deleteById(id);
        return noteList();
    }

    @RequestMapping(value = "/edit", method = {RequestMethod.GET})
    public ModelAndView getNoteForEdit(@NotNull @RequestParam(value="id") long id) throws Exception {
        ModelAndView result = new ModelAndView("notes/updatesNotes");
        result.addObject("note", noteService.getById(id));

        return result;
    }




    @RequestMapping(value = "/edit", method = {RequestMethod.POST})
    public ModelAndView updateNote(
            @NotNull @RequestParam(value="id") long id,
            @Size(min = 1, max = 250) @RequestParam(value="title") String title,
            @NotEmpty @RequestParam(value="content") String content) throws Exception {

        Note note = new Note();
        note.setId(id);
        note.setTitle(title);
        note.setContent(content);
        noteService.save(note);
        return noteList();
    }


}


