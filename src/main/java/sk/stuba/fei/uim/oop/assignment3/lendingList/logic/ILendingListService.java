package sk.stuba.fei.uim.oop.assignment3.lendingList.logic;

import sk.stuba.fei.uim.oop.assignment3.lendingList.data.LendingList;

import java.util.List;

public interface ILendingListService {
    List<LendingList> getAllLists();
    LendingList getListById(Long id);
    LendingList create();
}
