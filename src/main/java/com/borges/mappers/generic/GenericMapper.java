package com.borges.mappers.generic;

import org.springframework.data.domain.Page;

import java.util.List;

public interface GenericMapper<E, DTO> {

    DTO entityToDTO(E entity);

    E DTOToEntity(DTO dto);

    List<DTO> listEntityToListDTO(List<E> lista);

    default Page<DTO> pageEntitytoPageDTO(Page<E> pageEntity) {
        return pageEntity.map(this::entityToDTO);     }
}
