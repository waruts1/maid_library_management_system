package org.maid.maid_library_management_system.repository;

import org.maid.maid_library_management_system.entity.BorrowingRecord;
import org.maid.maid_library_management_system.entity.Patron;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRepository extends JpaRepository<BorrowingRecord, Integer> {
    BorrowingRecord findTopByBook_IdAndPatron_Id(Integer bookId, Integer patronId);
}
