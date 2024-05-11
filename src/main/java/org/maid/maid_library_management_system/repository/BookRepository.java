package org.maid.maid_library_management_system.repository;

import org.maid.maid_library_management_system.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
