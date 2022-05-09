package sk.stuba.fei.uim.oop.assignment3.lendingList.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.lendingList.data.LendingList;
import sk.stuba.fei.uim.oop.assignment3.lendingList.data.LendingListRepository;

import java.util.List;

@Service
public class LendingListService implements ILendingListService{

    @Autowired
    private LendingListRepository repository;

    @Override
    public List<LendingList> getAllLists() {
        return this.repository.findAll();
    }

    @Override
    public LendingList getListById(Long id) {
        return this.repository.getLendingListById(id);
    }

    @Override
    public LendingList createList() {
        LendingList created = new LendingList();
        return this.repository.save(created);
    }
}
