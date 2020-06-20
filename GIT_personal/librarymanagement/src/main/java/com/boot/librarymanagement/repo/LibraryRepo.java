package com.boot.librarymanagement.repo;

import com.boot.librarymanagement.entity.Book;
import com.boot.librarymanagement.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepo extends JpaRepository<Library, Long> {
    Library findBySectionName(String name);
}
