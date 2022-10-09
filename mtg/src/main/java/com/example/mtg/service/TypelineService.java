package com.example.mtg.service;

import com.example.mtg.model.Type;
import com.example.mtg.model.Typeline;
import com.example.mtg.repository.repositoryInterfaces.TypelineRepository;
import com.example.mtg.service.result.Result;
import com.example.mtg.service.result.ResultType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        } else if (!validateTypeline(typeline)) {
            result.addMessage("Card or types associated with given typeline " + typeline + " are not valid",
                    ResultType.INVALID);
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

        if(repository.findByCardId(typeline.getCard().getCardId()) == null) {
            result.addMessage("Given typeline " + typeline.getCard() + " is not found",
                    ResultType.NOT_FOUND);
        } else if (!validateTypeline(typeline)) {
            result.addMessage("Card or types associated with given typeline " + typeline + " are not valid",
                    ResultType.INVALID);
        } else {
            result.setPayload(repository.update(typeline));
            if(!result.getPayload()) {
                result.addMessage("Failed to update given typeline", ResultType.ERROR);
            } else {
                result.addMessage("success", ResultType.SUCCESS);
            }
        }

        return result;
    }

    public Result<Boolean> delete(Typeline typeline) {
        Result<Boolean> result = new Result<>();

        if(repository.findByCardId(typeline.getCard().getCardId()) == null) {
            result.addMessage("Given typeline " + typeline.getCard() + " is not found", ResultType.NOT_FOUND);
        } else if (!validateTypeline(typeline)) {
            result.addMessage("Card or types associated with given typeline are not valid", ResultType.INVALID);
        } else {
            result.setPayload(repository.delete(typeline));
            if(!result.getPayload()) {
                result.addMessage("Failed to delete given typeline", ResultType.ERROR);
            } else {
                result.addMessage("success", ResultType.SUCCESS);
            }
        }

        return result;
    }

    public boolean validateTypeline(Typeline typeline) {
        boolean valid = true;
        for(Type type : typeline.getTypes()) {
            if(!typeService.validateType(type)) {
                valid = false;
            }
        }
        return cardService.validateCard(typeline.getCard()) && valid;
    }
}
