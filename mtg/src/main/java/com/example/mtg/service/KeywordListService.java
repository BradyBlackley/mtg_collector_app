package com.example.mtg.service;

import com.example.mtg.model.Keyword;
import com.example.mtg.model.KeywordList;
import com.example.mtg.repository.repositoryInterfaces.KeywordListRepository;
import com.example.mtg.service.result.Result;
import com.example.mtg.service.result.ResultType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeywordListService {
    @Autowired
    KeywordListRepository repository;
    @Autowired
    KeywordService keywordService;
    @Autowired
    CardService cardService;

    public Result<KeywordList> findByCardId(String cardId) {
        Result<KeywordList> result = new Result<>();
        result.setPayload(repository.findByCardId(cardId));
        if(result.getPayload() == null) {
            result.addMessage("No keyword list found associated with given card id " + cardId,
                    ResultType.NOT_FOUND);
        } else {
            result.addMessage("success", ResultType.SUCCESS);
        }
        return result;
    }

    public Result<KeywordList> add(KeywordList keywordList) {
        Result<KeywordList> result = new Result<>();
        if(!validateKeywordList(keywordList)) {
            result.addMessage("Keyword or card associated with given keyword list is not valid",
                    ResultType.INVALID);
        } else if(repository.findByCardId(keywordList.getCard().getCardId()) != null) {
            result.addMessage("The given keyword list associated with card "
                    + keywordList.getCard().getCardId() + " already exists", ResultType.INVALID);
        } else {
            result.setPayload(repository.add(keywordList));
            if(result.getPayload() == null) {
                result.addMessage("Failed to add given keyword list " + keywordList, ResultType.ERROR);
            } else {
                result.addMessage(ResultType.SUCCESS.label, ResultType.SUCCESS);
            }
        }
        return result;
    }

    public Result<Boolean> update(KeywordList keywordList) {
        Result<Boolean> result = new Result<>();
        if(!validateKeywordList(keywordList)) {
            result.addMessage("Keyword or card associated with given keyword list is not valid",
                    ResultType.INVALID);
        } else if(repository.findByCardId(keywordList.getCard().getCardId()) == null) {
            result.addMessage("The given keyword list associated with card "
                    + keywordList.getCard().getCardId() + " is not found", ResultType.INVALID);
        } else {
            result.setPayload(repository.update(keywordList));
            if(!result.getPayload()) {
                result.addMessage("Failed to update given keyword list " + keywordList, ResultType.ERROR);
            } else {
                result.addMessage(ResultType.SUCCESS.label, ResultType.SUCCESS);
            }
        }
        return result;
    }

    public Result<Boolean> delete(KeywordList keywordList) {
        Result<Boolean> result = new Result<>();
        if(!validateKeywordList(keywordList)) {
            result.addMessage("Keyword or card associated with given keyword list is not valid",
                    ResultType.INVALID);
        } else if(repository.findByCardId(keywordList.getCard().getCardId()) == null) {
            result.addMessage("The given keyword list associated with card "
                    + keywordList.getCard().getCardId() + " is not found", ResultType.INVALID);
        } else {
            result.setPayload(repository.delete(keywordList));
            if(!result.getPayload()) {
                result.addMessage("Failed to delete given keyword list " + keywordList, ResultType.ERROR);
            } else {
                result.addMessage(ResultType.SUCCESS.label, ResultType.SUCCESS);
            }
        }
        return result;
    }

    public boolean validateKeywordList(KeywordList keywordList) {
        return validateKeywords(keywordList.getKeywords())
               && cardService.validateCard(keywordList.getCard());

    }

    private boolean validateKeywords(List<Keyword> keywordList) {
        boolean valid = true;
        for (Keyword keyword : keywordList) {
            if(!keywordService.validateKeyword(keyword)) {
                valid = false;
            }
        }
        return valid;
    }

}
