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

    public List createList(ListDto bodyParams) {
        List list = this.convertEntitiesDto.constructListEntity(bodyParams);
        if (list != null) {
            return this.save(list);
        }
        return null;
    }

    public List findById(Long id) {
        return listRepository.findById(id).orElse(null);
    }

    public List updateList(Long id, ListDto bodyParams) {
        List list = listRepository.findById(id).orElse(null);
        if (list != null) {
            list.setDetail(bodyParams.getDetail());
            list.setDisabled(bodyParams.getDisabled());
            list.setPriority(bodyParams.getPriority());
            list.setShowAmount(bodyParams.getShowAmount());
            list.setShowHome(bodyParams.getShowHome());
            list.setName(bodyParams.getName());
            return listRepository.save(list);
        }
        return null;
    }

    public List[] findByUserId(Long fkUser) {
        return listRepository.findByUserId(fkUser).toArray(new List[0]);
    }
}
