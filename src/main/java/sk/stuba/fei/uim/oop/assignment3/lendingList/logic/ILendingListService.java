package sk.stuba.fei.uim.oop.assignment3.lendingList.logic;

import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.lendingList.data.LendingList;

import java.util.List;

public interface ILendingListService {
    List<LendingList> getAllLists();
    LendingList getListById(Long id) throws NotFoundException;
    LendingList createList();
    void deleteList(Long id)throws NotFoundException;
    LendingList addBookToList(Long id);
}
