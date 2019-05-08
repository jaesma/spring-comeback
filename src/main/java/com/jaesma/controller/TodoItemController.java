package com.jaesma.controller;

import com.jaesma.model.TodoData;
import com.jaesma.util.Mappings;
import com.jaesma.util.ViewNames;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class TodoItemController {

    // -- model attributes -- >
    @ModelAttribute
    public TodoData todoData() {
        return new TodoData();
    }

    // localhost:8080/todo-list/items
    @GetMapping(Mappings.ITEMS)
    public String items() {
        return ViewNames.ITEMS_LIST;
    }
}
