package com.example.mtg.service;

import com.example.mtg.model.ColorIdentity;
import com.example.mtg.repository.repositoryInterfaces.ColorIdentityRepository;
import com.example.mtg.service.result.Result;
import com.example.mtg.service.result.ResultType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColorIdentityService {
    @Autowired
    ColorIdentityRepository repository;
    @Autowired
    CardService cardService;

    public Result<ColorIdentity> findByCardId(String cardId) {
        Result<ColorIdentity> result = new Result<>();
        result.setPayload(repository.findByCardId(cardId));
        if(result.getPayload() == null) {
            result.addMessage("No color identities found associated with given card id " + cardId,
                    ResultType.NOT_FOUND);
        } else {
            result.addMessage("success", ResultType.SUCCESS);
        }
        return result;
    }

    public Result<ColorIdentity> add(ColorIdentity colorIdentity) {
        Result<ColorIdentity> result = new Result<>();
        if(!validateColorIdentity(colorIdentity)) {
            result.addMessage("The card " + colorIdentity.getCard() +
                            " associated with given color identity " + colorIdentity + " is not valid",
                    ResultType.INVALID);
        } else if (repository.findByCardId(colorIdentity.getCard().getCardId()) != null) {
            result.addMessage("The given color identity " + colorIdentity + " already exists",
                    ResultType.INVALID);
        } else if (!cardService.findCardById(colorIdentity.getCard().getCardId()).isSuccess()) {
            result.addMessage("The card " + colorIdentity.getCard() + " associated with given color identity "
                    + colorIdentity + " is not found ", ResultType.NOT_FOUND);
        } else {
            result.setPayload(repository.add(colorIdentity));
            if(result.getPayload() == null) {
                result.addMessage("Failed to add given color identity" + colorIdentity, ResultType.ERROR);
            } else {
                result.addMessage(ResultType.SUCCESS.label, ResultType.SUCCESS);
            }
        }

        return result;
    }

    public Result<Boolean> update(ColorIdentity colorIdentity) {
        Result<Boolean> result = new Result<>();
        if(!validateColorIdentity(colorIdentity)) {
            result.addMessage("The card " + colorIdentity.getCard() +
                            " associated with given color identity " + colorIdentity + " is not valid",
                    ResultType.INVALID);
        } else if (repository.findByCardId(colorIdentity.getCard().getCardId()) == null) {
            result.addMessage("The given color identity " + colorIdentity + " is not found",
                    ResultType.INVALID);
        } else if (!cardService.findCardById(colorIdentity.getCard().getCardId()).isSuccess()) {
            result.addMessage("The card " + colorIdentity.getCard() + " associated with given color identity "
                    + colorIdentity + " is not found ", ResultType.NOT_FOUND);
        } else {
            result.setPayload(repository.update(colorIdentity));
            if(!result.getPayload()) {
                result.addMessage("Failed to update given color identity" + colorIdentity, ResultType.ERROR);
            } else {
                result.addMessage(ResultType.SUCCESS.label, ResultType.SUCCESS);
            }
        }

        return result;
    }

    public Result<Boolean> delete(ColorIdentity colorIdentity) {
        Result<Boolean> result = new Result<>();
        if(!validateColorIdentity(colorIdentity)) {
            result.addMessage("The card " + colorIdentity.getCard() +
                            " associated with given color identity " + colorIdentity + " is not valid",
                    ResultType.INVALID);
        } else if (repository.findByCardId(colorIdentity.getCard().getCardId()) == null) {
            result.addMessage("The given color identity " + colorIdentity + " is not found",
                    ResultType.INVALID);
        } else if (!cardService.findCardById(colorIdentity.getCard().getCardId()).isSuccess()) {
            result.addMessage("The card " + colorIdentity.getCard() + " associated with given color identity "
                    + colorIdentity + " is not found ", ResultType.NOT_FOUND);
        } else {
            result.setPayload(repository.delete(colorIdentity));
            if(!result.getPayload()) {
                result.addMessage("Failed to delete given color identity" + colorIdentity, ResultType.ERROR);
            } else {
                result.addMessage(ResultType.SUCCESS.label, ResultType.SUCCESS);
            }
        }

        return result;
    }

    public boolean validateColorIdentity(ColorIdentity colorIdentity) {
        return cardService.validateCard(colorIdentity.getCard());
    }
}
