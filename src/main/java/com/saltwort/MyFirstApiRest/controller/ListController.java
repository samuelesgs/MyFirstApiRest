package com.saltwort.MyFirstApiRest.controller;
import com.saltwort.MyFirstApiRest.dto.response.ApiResponse;
import com.saltwort.MyFirstApiRest.dto.response.ListDto;
import com.saltwort.MyFirstApiRest.model.List;
import com.saltwort.MyFirstApiRest.service.ListService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/list")
public class ListController {

    private final ListService listService;

    public ListController(ListService listService) {
        this.listService = listService;
    }

    @PostMapping("/create")
    public ApiResponse<ListDto> createList(@Valid @RequestBody ListDto bodyParams) {
        List list = listService.createList(bodyParams);
        if (list == null) {
            return ApiResponse.error("Failed to create list", 400);
        }
        return ApiResponse.success(bodyParams);
    }

    @PutMapping("/update/{id}")
    public ApiResponse<ListDto> updateList(@PathVariable Long id, @Valid @RequestBody ListDto body) {
        List list = this.listService.updateList(id, body);
        if (list == null) {
            return ApiResponse.error("Failed to update list", 400);
        }
        return ApiResponse.success(body);
    }
}
