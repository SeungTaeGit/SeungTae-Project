package seungtae.first.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import seungtae.first.list.List;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Repository
public class ItemRepository {

    private static Map<Long, List> itemStore = new ConcurrentHashMap<>();
    private static long ItemSequence = 0L;
    private static LocalDate nowTime = LocalDate.now();

    // 리스트 추가
    public List saveItem(List list) {
        list.setItemSequence(++ItemSequence);
        list.setDate(nowTime);
        itemStore.put(list.getItemSequence(), list);
        return list;
    }

    // 리스트 조회
    public List findByItemSequence(Long sequence) {
        return itemStore.get(sequence);
    }

    // 리스트 전체 조회
    public java.util.List<List> findAll() {
        return new ArrayList<>(itemStore.values());
    }

    public void update() {

    }
}
