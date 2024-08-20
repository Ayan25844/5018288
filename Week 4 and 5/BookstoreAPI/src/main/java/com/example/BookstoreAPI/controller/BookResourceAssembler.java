package com.example.BookstoreAPI.controller;

import org.springframework.stereotype.Component;

import com.example.BookstoreAPI.dto.BookDTO;

@Component
public class BookResourceAssembler extends RepresentationModelAssemblerSupport<BookDTO, EntityModel<BookDTO>> {

    public BookResourceAssembler() {
        super(BookController.class, BookDTO.class);
    }

    @Override
    public EntityModel<BookDTO> toModel(BookDTO bookDTO) {
        EntityModel<BookDTO> bookResource = EntityModel.of(bookDTO);
        Link selfLink = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getBookById(bookDTO.getId())).withSelfRel();
        bookResource.add(selfLink);
        return bookResource;
    }
}
