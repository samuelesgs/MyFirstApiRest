package com.saltwort.MyFirstApiRest.service;

import com.saltwort.MyFirstApiRest.dto.response.ListDto;
import com.saltwort.MyFirstApiRest.model.ConvertEntitiesDto;
import com.saltwort.MyFirstApiRest.model.List;
import com.saltwort.MyFirstApiRest.repository.ListRepository;
import org.springframework.stereotype.Service;

@Service
public class ListService {

    private final ListRepository listRepository;
    private final ConvertEntitiesDto convertEntitiesDto;


    public ListService(ListRepository listRepository, ConvertEntitiesDto convertEntitiesDto) {
        this.listRepository = listRepository;
        this.convertEntitiesDto = convertEntitiesDto;
    }

    public List save(List list) {
        return listRepository.save(list);
    }

    public List insert(ListDto value) {
        List list = convertEntitiesDto.constructListEntity(value);
        return this.save(list);
    }
}
