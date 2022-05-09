package sk.stuba.fei.uim.oop.assignment3.lendingList.logic;

import sk.stuba.fei.uim.oop.assignment3.book.web.bodies.BookIdRequest;
import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.lendingList.data.LendingList;

import java.util.List;

public interface ILendingListService {
    List<LendingList> getAllLists();
    LendingList getListById(Long id) throws NotFoundException;
    LendingList createList();
    void deleteList(Long id)throws NotFoundException;
    LendingList addBookToList(Long id, BookIdRequest request) throws NotFoundException, IllegalOperationException;
    void removeBookFromList(Long id, BookIdRequest request) throws NotFoundException;
    void lendList(Long id)throws NotFoundException, IllegalOperationException;
}
