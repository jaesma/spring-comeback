package com.jaesma.controller;

import com.jaesma.model.TodoData;
import com.jaesma.model.TodoItem;
import com.jaesma.service.TodoItemService;
import com.jaesma.util.AttributeNames;
import com.jaesma.util.Mappings;
import com.jaesma.util.ViewNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

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

    @GetMapping(Mappings.ADD_ITEM)
    public String addEditItem(Model model) {
        TodoItem todoItem = new TodoItem("","", LocalDate.now());
        model.addAttribute(AttributeNames.TODO_ITEM, todoItem);
        return ViewNames.ADD_ITEM;
    }

    @PostMapping(Mappings.ADD_ITEM)
    public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM) TodoItem todoItem) {
        todoItemService.addItem(todoItem);
        return "redirect:/" + Mappings.ITEMS;
    }
}
