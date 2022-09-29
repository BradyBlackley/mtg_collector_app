package com.example.mtg.service;

import com.example.mtg.model.Card;
import com.example.mtg.model.CardCopy;
import com.example.mtg.model.User;
import com.example.mtg.repository.jdbcRepositories.CardCopyJdbcRepository;
import com.example.mtg.service.result.Result;
import com.example.mtg.service.result.ResultType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardCopyService {
    @Autowired
    private CardCopyJdbcRepository repository;
    @Autowired
    private CardService cardService;
    @Autowired
    private UserService userService;

    Result<List<CardCopy>> findAllByUser(String userId) {
        Result<List<CardCopy>> result = new Result<>();
        result.setPayload(repository.findAllByUser(userId));
        if(result.getPayload() == null) {
            result.addMessage("No card copies found associated with given user " + userId, ResultType.NOT_FOUND);
        } else {
            result.addMessage(ResultType.SUCCESS.label, ResultType.SUCCESS);
        }
        return result;
    }

    Result<List<CardCopy>> findAllByCardId(String cardId, String userId) {
        Result<List<CardCopy>> result = new Result<>();
        result.setPayload(repository.findAllByCardId(cardId, userId));
        if(result.getPayload() == null) {
            result.addMessage("No card copies found associated with given card id " + cardId, ResultType.NOT_FOUND);
        } else {
            result.addMessage(ResultType.SUCCESS.label, ResultType.SUCCESS);
        }
        return result;
    }

    Result<CardCopy> findByCardCopyId(int cardCopyId) {
        Result<CardCopy> result = new Result<>();
        result.setPayload(repository.findByCardCopyId(cardCopyId));
        if(result.getPayload() == null) {
            result.addMessage("No card copy found associated with given card copy id " + cardCopyId, ResultType.NOT_FOUND);
        } else {
            result.addMessage(ResultType.SUCCESS.label, ResultType.SUCCESS);
        }
        return result;
    }

    Result<CardCopy> add(CardCopy cardCopy) {
        Result<CardCopy> result = new Result<>();
        Result<Card> cardResult = cardService.findCardById(cardCopy.getCard().getCardId());
        Result<User> userResult = userService.findById(cardCopy.getUser().getUserId());

        if(cardCopy.getCardCopyId() < 0) {
            result.addMessage("The given card copy id " + cardCopy.getCardCopyId() + " is invalid", ResultType.INVALID);
        } else if (repository.findByCardCopyId(cardCopy.getCardCopyId()) != null) {
            result.addMessage("The given card copy id " + cardCopy.getCardCopyId() + " already exists", ResultType.INVALID);
        } else if (cardService.findCardById(cardCopy.getCard().getCardId()) == null) {
            result.addMessage("The given card " + cardCopy.getCard() + " associated with card copy "
                    + cardCopy + " is not found", ResultType.NOT_FOUND);
        } else if (userService.findById(cardCopy.getUser().getUserId()) == null) {
            result.addMessage("The given user " + cardCopy.getUser() + " associated with card copy "
                    + cardCopy + " is not found", ResultType.NOT_FOUND);
        } else if (cardResult.getPayload() == null || !cardResult.isSuccess()) {
            result.addMessage(cardResult.getMessages().get(0), cardResult.getType());
            result.addMessage("The given card " + cardCopy.getCard() + " associated with card copy "
                    + cardCopy + " is invalid", ResultType.INVALID);
        } else if (userResult.getPayload() == null || !userResult.isSuccess()) {
            result.addMessage(userResult.getMessages().get(0), userResult.getType());
            result.addMessage("The given user " + cardCopy.getUser() + " associated with card copy "
                    + cardCopy + " is invalid", ResultType.INVALID);
        } else {
            result.setPayload(repository.add(cardCopy));
            if(result.getPayload() == null) {
                result.addMessage("Failed to add given card copy" + cardCopy, ResultType.ERROR);
            } else {
                result.addMessage(ResultType.SUCCESS.label, ResultType.SUCCESS);
            }
        }
        return result;
    }

    Result<Boolean> update(CardCopy cardCopy) {
        Result<Boolean> result = new Result<>();
        Result<Card> cardResult = cardService.findCardById(cardCopy.getCard().getCardId());
        Result<User> userResult = userService.findById(cardCopy.getUser().getUserId());

        if(cardCopy.getCardCopyId() < 0) {
            result.addMessage("The given card copy id " + cardCopy.getCardCopyId() + " is invalid", ResultType.INVALID);
        } else if (repository.findByCardCopyId(cardCopy.getCardCopyId()) == null) {
            result.addMessage("The given card copy id " + cardCopy.getCardCopyId() + " is not found", ResultType.NOT_FOUND);
        } else if (cardService.findCardById(cardCopy.getCard().getCardId()) == null) {
            result.addMessage("The given card " + cardCopy.getCard() + " associated with card copy "
                    + cardCopy + " is not found", ResultType.NOT_FOUND);
        } else if (userService.findById(cardCopy.getUser().getUserId()) == null) {
            result.addMessage("The given user " + cardCopy.getUser() + " associated with card copy "
                    + cardCopy + " is not found", ResultType.NOT_FOUND);
        } else if (cardResult.getPayload() == null || !cardResult.isSuccess()) {
            result.addMessage(cardResult.getMessages().get(0), cardResult.getType());
            result.addMessage("The given card " + cardCopy.getCard() + " associated with card copy "
                    + cardCopy + " is invalid", ResultType.INVALID);
        } else if (userResult.getPayload() == null || !userResult.isSuccess()) {
            result.addMessage(userResult.getMessages().get(0), userResult.getType());
            result.addMessage("The given user " + cardCopy.getUser() + " associated with card copy "
                    + cardCopy + " is invalid", ResultType.INVALID);
        } else {
            result.setPayload(repository.update(cardCopy));
            if(result.getPayload() == null) {
                result.addMessage("Failed to update given card copy" + cardCopy, ResultType.ERROR);
            } else {
                result.addMessage(ResultType.SUCCESS.label, ResultType.SUCCESS);
            }
        }
        return result;
    }

    Result<Boolean> delete(CardCopy cardCopy) {
        Result<Boolean> result = new Result<>();
        Result<Card> cardResult = cardService.findCardById(cardCopy.getCard().getCardId());
        Result<User> userResult = userService.findById(cardCopy.getUser().getUserId());

        if(cardCopy.getCardCopyId() < 0) {
            result.addMessage("The given card copy id " + cardCopy.getCardCopyId() + " is invalid", ResultType.INVALID);
        } else if (repository.findByCardCopyId(cardCopy.getCardCopyId()) == null) {
            result.addMessage("The given card copy id " + cardCopy.getCardCopyId() + " is not found", ResultType.NOT_FOUND);
        } else if (cardService.findCardById(cardCopy.getCard().getCardId()) == null) {
            result.addMessage("The given card " + cardCopy.getCard() + " associated with card copy "
                    + cardCopy + " is not found", ResultType.NOT_FOUND);
        } else if (userService.findById(cardCopy.getUser().getUserId()) == null) {
            result.addMessage("The given user " + cardCopy.getUser() + " associated with card copy "
                    + cardCopy + " is not found", ResultType.NOT_FOUND);
        } else if (cardResult.getPayload() == null || !cardResult.isSuccess()) {
            result.addMessage(cardResult.getMessages().get(0), cardResult.getType());
            result.addMessage("The given card " + cardCopy.getCard() + " associated with card copy "
                    + cardCopy + " is invalid", ResultType.INVALID);
        } else if (userResult.getPayload() == null || !userResult.isSuccess()) {
            result.addMessage(userResult.getMessages().get(0), userResult.getType());
            result.addMessage("The given user " + cardCopy.getUser() + " associated with card copy "
                    + cardCopy + " is invalid", ResultType.INVALID);
        } else {
            result.setPayload(repository.delete(cardCopy.getCardCopyId()));
            if(result.getPayload() == null) {
                result.addMessage("Failed to delete given card copy" + cardCopy, ResultType.ERROR);
            } else {
                result.addMessage(ResultType.SUCCESS.label, ResultType.SUCCESS);
            }
        }
        return result;
    }

}
