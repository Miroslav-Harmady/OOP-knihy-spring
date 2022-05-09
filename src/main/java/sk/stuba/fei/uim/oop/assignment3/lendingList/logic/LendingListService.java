package sk.stuba.fei.uim.oop.assignment3.lendingList.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.book.data.Book;
import sk.stuba.fei.uim.oop.assignment3.book.logic.BookService;
import sk.stuba.fei.uim.oop.assignment3.book.web.bodies.BookIdRequest;
import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.lendingList.data.LendingList;
import sk.stuba.fei.uim.oop.assignment3.lendingList.data.LendingListRepository;
import sk.stuba.fei.uim.oop.assignment3.lendingList.web.bodies.ListResponse;

import java.util.List;

@Service
public class LendingListService implements ILendingListService{

    @Autowired
    private LendingListRepository listRepository;

    @Autowired
    private BookService bookService;

    @Override
    public List<LendingList> getAllLists() {
        return this.listRepository.findAll();
    }

    @Override
    public LendingList getListById(Long id) throws NotFoundException {
        LendingList list = this.listRepository.getLendingListById(id);
        if (list == null){
            throw new NotFoundException();
        }
        return list;
    }

    @Override
    public LendingList createList() {
        LendingList created = new LendingList();
        return this.listRepository.save(created);
    }

    @Override
    public void deleteList(Long id) throws NotFoundException {
        LendingList list = this.getListById(id);
        if (list.isLent()){
            for (Book book: list.getList()) {
                book.setLendCount(book.getLendCount() - 1);
            }
        }
        this.listRepository.delete(list);
    }

    @Override
    public LendingList addBookToList(Long id, BookIdRequest request) throws NotFoundException, IllegalOperationException {
        LendingList list = this.getListById(id);
        if(list.getList().contains(this.bookService.getBookById(request.getId())) || list.isLent()){
            throw new IllegalOperationException();
        }
        list.getList().add(this.bookService.getBookById(request.getId()));
        return list;
    }

    @Override
    public void removeBookFromList(Long id, BookIdRequest request) throws NotFoundException {
        LendingList list = this.getListById(id);
        Book bookToRemove = this.bookService.getBookById(request.getId());
        list.getList().remove(bookToRemove);
    }

    @Override
    public void lendList(Long id) throws NotFoundException, IllegalOperationException {
        LendingList list = this.getListById(id);
        if (list.isLent()){
            throw new IllegalOperationException();
        }
        for (Book book:list.getList()) {
            book.setLendCount(book.getLendCount() + 1);
        }
        list.setLent(true);
    }
}
