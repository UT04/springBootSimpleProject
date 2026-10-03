package com.example.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.demo.dto.PersonRequestDto;
import com.example.demo.model.Person;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    // Singleton-Instanz für nicht-Spring-Integration
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    // Entity -> DTO
    PersonRequestDto personToPersonRequestDto(Person person);

    // DTO -> Entity
    Person personRequestDtoToPerson(PersonRequestDto requestDto);

    // Listen-Mapping (optional)
    List<PersonRequestDto> personsToPersonRequestDtos(List<Person> persons);
}
