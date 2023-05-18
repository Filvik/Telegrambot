package ru.skillfactorydemo.tgbot.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.skillfactorydemo.tgbot.entity.Income;
import ru.skillfactorydemo.tgbot.entity.Spend;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class SpendRepositoryTest {

    @Autowired
    private SpendRepository spendRepository ;

    @Test
    public void testRepo() {
        //noinspection StatementWithEmptyBody
        for (int i = 0; i < 10; i++, spendRepository.save(new Spend()));
        final List<Spend> found = spendRepository.findAll();
        //assertEquals(10, found.size());
        assertEquals(10+1, found.size());//Один лишний добавляется при прочтении файла data.sql
    }

    @Test
    public void testData(){
        Optional<Spend> spend = spendRepository.findById(110L);
        assertTrue(spend.isPresent());
        assertEquals(new BigDecimal("4090.00"),spend.get().getSpend());
    }
}