package com.boot.librarymanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.lang.NonNullFields;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookResponseType extends ResponseType {
    List<BookType> books;
    BookType book;
}
