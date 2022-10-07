package com.example.mtg.service;

import com.example.mtg.model.Typeline;
import com.example.mtg.repository.repositoryInterfaces.TypelineRepository;
import com.example.mtg.service.result.Result;
import com.example.mtg.service.result.ResultType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypelineService {
    @Autowired
    private TypelineRepository repository;
    @Autowired
    private TypeService typeService;
    @Autowired
    private CardService cardService;

    public Result<Typeline> findByCardId(String cardId) {
        Result<Typeline> result = new Result<>();
        result.setPayload(repository.findByCardId(cardId));

        if(result.getPayload() == null){
            result.addMessage("No typeline found associated with given card id " + cardId, ResultType.NOT_FOUND);
        } else {
            result.addMessage(ResultType.SUCCESS.label, ResultType.SUCCESS);
        }

        return result;
    }

    public Result<Typeline> add(Typeline typeline) {
        Result<Typeline> result = new Result<>();

        if(repository.findByCardId(typeline.getCard().getCardId()) != null) {
            result.addMessage("Typeline associated with given card " + typeline.getCard() + " already exists",
                    ResultType.INVALID);
        } else if (true) {
            result.addMessage("", ResultType.INVALID);
        } else {
            result.setPayload(repository.add(typeline));
            if(result.getPayload() == null) {
                result.addMessage("Failed to add given typeline", ResultType.ERROR);
            } else {
                result.addMessage("success", ResultType.SUCCESS);
            }
        }

        return result;
    }

    public Result<Boolean> update(Typeline typeline) {
        Result<Boolean> result = new Result<>();
        result.setPayload(repository.update(typeline));

        if(true) {
            result.addMessage("", ResultType.INVALID);
        } else if (true) {
            result.addMessage("", ResultType.INVALID);
        } else {
            result.addMessage("success", ResultType.SUCCESS);
        }

        return result;
    }

    public Result<Boolean> delete(int typeId, String cardId) {
        Result<Boolean> result = new Result<>();
        result.setPayload(repository.delete(typeId, cardId));

        if(true) {
            result.addMessage("", ResultType.INVALID);
        } else if (true) {
            result.addMessage("", ResultType.INVALID);
        } else {
            result.addMessage("success", ResultType.SUCCESS);
        }

        return result;
    }
}
