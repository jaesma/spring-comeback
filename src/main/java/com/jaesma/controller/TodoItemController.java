package com.jaesma.controller;

import com.jaesma.model.TodoData;
import com.jaesma.service.TodoItemService;
import com.jaesma.util.Mappings;
import com.jaesma.util.ViewNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class TodoItemController {

    // -- fields -- >
    private final TodoItemService todoItemService;

    // -- constructor injection of TodoItemService -- >
    @Autowired
    public TodoItemController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    // -- model attributes -- >
    @ModelAttribute
    public TodoData todoData() {
        return todoItemService.getData();
    }

    // localhost:8080/items
    @GetMapping(Mappings.ITEMS)
    public String items() {
        return ViewNames.ITEMS_LIST;
    }
}
