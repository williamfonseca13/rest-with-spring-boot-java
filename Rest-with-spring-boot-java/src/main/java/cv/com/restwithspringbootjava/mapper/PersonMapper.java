package cv.com.restwithspringbootjava.mapper;

import cv.com.restwithspringbootjava.model.Person;
import cv.com.restwithspringbootjava.data.dto.v1.PersonDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PersonMapper {
    Person toEntity(PersonDto personDto);

    PersonDto toDto(Person person);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Person partialUpdate(PersonDto personDto, @MappingTarget Person person);
}