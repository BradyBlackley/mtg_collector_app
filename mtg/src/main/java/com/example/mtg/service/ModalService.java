package com.example.mtg.service;

import com.example.mtg.model.Modal;
import com.example.mtg.repository.repositoryInterfaces.ModalRepository;
import com.example.mtg.service.result.Result;
import com.example.mtg.service.result.ResultType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModalService {
    @Autowired
    private ModalRepository repository;
    @Autowired
    private CardService cardService;

    public Result<Modal> findByFrontCardId(String cardId) {
        Result<Modal> result = new Result<>();
        result.setPayload(repository.findByFrontCardId(cardId));
        if(result.getPayload() == null) {
            result.addMessage("No cards found by given front card id " + cardId, ResultType.NOT_FOUND);
        } else {
            result.addMessage(ResultType.SUCCESS.label, ResultType.SUCCESS);
        }
        return result;
    }

}
