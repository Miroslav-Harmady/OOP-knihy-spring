package sk.stuba.fei.uim.oop.assignment3.lendingList.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
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
    public LendingList getListById(Long id) throws NotFoundException {
        LendingList list = this.repository.getLendingListById(id);
        if (list == null){
            throw new NotFoundException();
        }
        return list;
    }

    @Override
    public LendingList createList() {
        LendingList created = new LendingList();
        return this.repository.save(created);
    }

    @Override
    public void deleteList(Long id) throws NotFoundException {
        LendingList list = this.getListById(id);
        this.repository.delete(list);
    }
}
