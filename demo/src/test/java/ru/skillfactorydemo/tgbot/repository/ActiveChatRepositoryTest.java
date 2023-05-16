package ru.skillfactorydemo.tgbot.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.skillfactorydemo.tgbot.entity.ActiveChat;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ActiveChatRepositoryTest {

    @Autowired
    private ActiveChatRepository activeChatRepository;

    @Test
    public void testRepo_found() {
        final ActiveChat activeChat = new ActiveChat();
        activeChat.setChatId(9999L);
        activeChatRepository.save(activeChat);
        Optional<ActiveChat> activeChatByChatId = activeChatRepository.findActiveChatByChatId(9999L);
        assertTrue(activeChatByChatId.isPresent());
        assertEquals(9999L, activeChatByChatId.get().getChatId());
    }

    @Test
    public void testRepo_notFound() {
        final ActiveChat activeChat = new ActiveChat();
        activeChat.setChatId(9999L);
        activeChatRepository.save(activeChat);
        Optional<ActiveChat> activeChatByChatId = activeChatRepository.findActiveChatByChatId(9998L);
        assertFalse(activeChatByChatId.isPresent());
    }
}